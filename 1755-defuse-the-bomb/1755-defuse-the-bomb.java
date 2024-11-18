class Solution {
    public int[] decrypt(int[] code, int k) {
        int res[] = new int[code.length];
        int n = code.length;

        if (k > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= i + k; j++) {
                    int temp = (j % n);
                    res[i] += code[temp];
                }
            }
        } else if (k < 0) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i - 1; j >= i + k; j--) { 
                    int temp = (j + n) % n; 
                    res[i] += code[temp];
                }
            }
        } else if(k==0){
            return res; 
        }

        return res;
    }
}
