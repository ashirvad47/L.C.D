class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] di = new int[]{-1, 1, 1, -1};
        int[] dj = new int[]{ 1, 1,-1, -1};

        int[][][] len2 = new int[4][n][m];
        int[][][] len0 = new int[4][n][m];

        for (int d = 0; d < 4; ++d) {
            int stepI = di[d], stepJ = dj[d];
            int iStart = stepI == 1 ? n - 1 : 0;
            int iEnd = stepI == 1 ? -1 : n;
            int iInc = stepI == 1 ? -1 : 1;
            int jStart = stepJ == 1 ? m - 1 : 0;
            int jEnd = stepJ == 1 ? -1 : m;
            int jInc = stepJ == 1 ? -1 : 1;

            for (int ii = iStart; ii != iEnd; ii += iInc) {
                for (int jj = jStart; jj != jEnd; jj += jInc) {
                    int ni = ii + stepI, nj = jj + stepJ;
                    if (grid[ii][jj] == 2) {
                        int next = (ni >= 0 && ni < n && nj >= 0 && nj < m) ? len0[d][ni][nj] : 0;
                        len2[d][ii][jj] = 1 + next;
                    } else {
                        len2[d][ii][jj] = 0;
                    }
                    if (grid[ii][jj] == 0) {
                        int next = (ni >= 0 && ni < n && nj >= 0 && nj < m) ? len2[d][ni][nj] : 0;
                        len0[d][ii][jj] = 1 + next;
                    } else {
                        len0[d][ii][jj] = 0;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 1) continue;
                for (int d = 0; d < 4; ++d) {
                    int stepI = di[d], stepJ = dj[d];
                    int ni = i + stepI, nj = j + stepJ;
                    int straight = 1;
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) straight += len2[d][ni][nj];
                    if (straight > ans) ans = straight;

                    int ci = i, cj = j;
                    int k = 0;
                    while (true) {
                        int L1 = k + 1;
                        int dTurn = (d + 1) & 3;
                        int ti = ci + di[dTurn], tj = cj + dj[dTurn];
                        if (ti >= 0 && ti < n && tj >= 0 && tj < m) {
                            boolean expectTwo = (L1 % 2 == 1);
                            int ext = expectTwo ? len2[dTurn][ti][tj] : len0[dTurn][ti][tj];
                            int total = L1 + ext;
                            if (total > ans) ans = total;
                        } else {
                            if (L1 > ans) ans = L1;
                        }

                        int ni2 = ci + stepI, nj2 = cj + stepJ;
                        if (ni2 < 0 || ni2 >= n || nj2 < 0 || nj2 >= m) break;
                        int expectedNext = ((k + 1) % 2 == 1) ? 2 : 0;
                        if (grid[ni2][nj2] != expectedNext) break;
                        ci = ni2; cj = nj2; k++;
                    }
                }
            }
        }

        return ans;
    }
}