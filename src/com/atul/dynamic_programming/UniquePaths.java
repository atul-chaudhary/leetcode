package com.atul.dynamic_programming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int n = 3;
        int m = 7;
        int[][]dp = new int[n+1][m+1];
        System.out.println(solveTab(n,m, dp));
    }
    private static int solveTab(int n, int m, int[][] dp){
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<= m;i++){
            dp[0][i] = 1;
        }
        for (int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i+1 <= n  && j+1 <= m)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[n][m];
    }

    private static int solve(int i, int j, int n, int m, int[][] dp){
        if(i== n-1 && j==m-1){
            return 1;
        }
        if(i >= n || j >= m){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = solve(i+1, j, n, m, dp) + solve(i, j+1, n, m,dp);
         return dp[i][j];
    }
}
