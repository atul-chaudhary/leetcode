package com.atul.dynamic_programming;

public class LongesCommonSubString {
    public static void main(String[] args) {
        String s = "absc";
        String b = "abc";
        int[][] dp = new int[s.length() + 1][b.length() + 1];
        int[] max = new int[1];
        System.out.println(LongestCommonSubStringMemo(s, b, s.length(), b.length(), 0, dp, max));
        System.out.println(max[0]);
    }

    public static int LongestCommonSubStringMemo(String x, String y, int n, int m, int curr_max, int[][] dp, int[] max) {
        if (m == 0 || n == 0) return curr_max;

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            dp[n][m] = LongestCommonSubStringMemo(x, y, n -1, m - 1, curr_max + 1, dp, max);
            max[0] = Math.max(max[0], dp[n][m]);
            return dp[n][m];

        } else {
            dp[n][m] = Math.max(LongestCommonSubStringMemo(x, y, n - 1, m, 0, dp, max), LongestCommonSubStringMemo(x, y, n, m - 1, 0, dp, max));
            //max[0] = Math.max(max[0], dp[n][m]);
            return dp[n][m];
        }

        //return max[0];
    }

    public static int LongestCommonSubString(String x, String y, int m, int n, int curr_max) {
        if (m == 0 || n == 0) return curr_max;

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return LongestCommonSubString(x, y, m - 1, n - 1, curr_max + 1);

        return Math.max(LongestCommonSubString(x, y, m - 1, n, 0), LongestCommonSubString(x, y, m, n - 1, 0));
    }
}
