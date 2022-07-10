package com.atul.dynamic_programming;

public class MinimumNumberOfDeletionsAndInsertions {
    public static void main(String[] args) {
        String a = "efaebad";
        String b = "gehide";
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        System.out.println(longesSubString(a, b, a.length(), b.length(), dp));
    }

    private static int longesSubString(String a, String b, int n, int m, int[][] dp) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        max = dp[n][m];
        int dele = 0;
        if (n > max) {
            dele = n - max;
        }
        int insert = 0;
        if (m > max) {
            insert = m - max;
        }
        return dele + insert;
    }
}
