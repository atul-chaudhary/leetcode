package com.atul.dynamic_programming;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int n = arr.length;
//        int min = Integer.MAX_VALUE;
//        int[][] dp = new int[n][n];
//        for(int [] row : dp){
//            Arrays.fill(row, -1);
//        }
//        for(int i=0;i<n;i++){
//            min = Math.min(min, solve(arr, 0, i, n, dp));
//        }
//        System.out.println(min);

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

    }

    public int minFallingPathSum(int[][] A) {
        int len = A.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Math.min(
                        Math.min(j > 0
                                ? dp[i - 1][j - 1]
                                : Integer.MAX_VALUE,
                                j + 1 < len
                                        ? dp[i - 1][j + 1]
                                        : Integer.MAX_VALUE),
                        dp[i - 1][j]) + A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++)
            res = Math.min(res, dp[len - 1][i]);
        return res;
    }

    private static int solve(int[][] arr, int i, int j, int n, int[][] dp) {
        if (j < 0 || j > n - 1) return (int) Math.pow(10, 9);

        if (i == n - 1) return arr[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        int left = arr[i][j] + solve(arr, i + 1, j - 1, n, dp);
        int down = arr[i][j] + solve(arr, i + 1, j, n, dp);
        int right = arr[i][j] + solve(arr, i + 1, j + 1, n, dp);

        return dp[i][j] = Math.min(left, Math.min(down, right));
    }
}
