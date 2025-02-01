class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] f = new int[2], s = new int[2], t = new int[3];
        int n = startTime.length;
        for (int i = 1; i < n; i++) {
            int start = endTime[i - 1], end = startTime[i], len = end - start;
            if (len > f[1] - f[0]) {
                t[0] = s[0];
                t[1] = s[1];
                s[0] = f[0];
                s[1] = f[1];
                f[0] = start;
                f[1] = end;
            } else if (len > s[1] - s[0]) {
                t[0] = s[0];
                t[1] = s[1];
                s[0] = start;
                s[1] = end;
            } else if (len > t[1] - t[0]) {
                t[0] = start;
                t[1] = end;
            }
        }
        int start = 0, end = startTime[0], len = end - start;
        if (len > f[1] - f[0]) {
            t[0] = s[0];
            t[1] = s[1];
            s[0] = f[0];
            s[1] = f[1];
            f[0] = start;
            f[1] = end;
        } else if (len > s[1] - s[0]) {
            t[0] = s[0];
            t[1] = s[1];
            s[0] = start;
            s[1] = end;
        } else if (len > t[1] - t[0]) {
            t[0] = start;
            t[1] = end;
        }
        start = endTime[n - 1];
        end = eventTime;
        len = end - start;
        if (len > f[1] - f[0]) {
            t[0] = s[0];
            t[1] = s[1];
            s[0] = f[0];
            s[1] = f[1];
            f[0] = start;
            f[1] = end;
        } else if (len > s[1] - s[0]) {
            t[0] = s[0];
            t[1] = s[1];
            s[0] = start;
            s[1] = end;
        } else if (len > t[1] - t[0]) {
            t[0] = start;
            t[1] = end;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int busy = endTime[i] - startTime[i];
            int sum = (i == n - 1 ? eventTime : startTime[i + 1]) - (i == 0 ? 0 : endTime[i - 1]);
            if (busy <= t[1] - t[0] || (busy <= s[1] - s[0] && endTime[i] != s[0] && startTime[i] != s[1]) || (busy <= f[1] - f[0] && endTime[i] != f[0] && startTime[i] != f[1])) {
                res = Math.max(res, sum);
            } else {
                res = Math.max(res, sum - busy);
            }
        }
        return res;
    }
}