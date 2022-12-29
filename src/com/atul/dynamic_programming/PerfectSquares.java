package com.atul.dynamic_programming;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        Integer[] dp = new Integer[n + 1];
        //return solve(n, dp);
        return solveTab(n);
    }

    private static int solveTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= n; j++) {
                int temp = j * j;
                if (i - temp >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
            }
        }
        return dp[n];
    }

    private static int solve(int n, Integer[] dp) {
        if (n == 0) return 0;
        if (dp[n] != null) return dp[n];
        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            int temp = i * i;
            ans = Math.min(ans, 1 + solve(n - temp, dp));
        }
        return dp[n] = ans;
    }
}
