package com.atul.dynamic_programming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(solve(arr, arr.length - 1, arr[0].length - 1));

        int[][] dp = new int[arr.length][arr[0].length];
//        for(int[] row : dp){
//            Arrays.fill(row, -1);
//        }
        System.out.println(minCost(arr, arr.length-1, arr[0].length-1));
        //System.out.println(minSumPathUtil(arr.length-1, arr[0].length-1, arr, dp));
    }

    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        for(int[] row : tc){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];

        for(int[] row : tc){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = Math.min(
                        tc[i - 1][j],
                        tc[i][j - 1]) + cost[i][j];

        return tc[m][n];
    }

    private static int solveTab(int[][] arr, int[][] dp) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0 && j == 0) dp[i][j] = arr[i][j];
                else {
//                    int up = 0, left = 0;
//                    if (i > 0) up = arr[i][j] + dp[i - 1][j];
//                    else dp[i][j] = arr[i][j] + (int) Math.pow(10,9);
//                    if (j > 0) left = arr[i][j] + dp[i][j - 1];
//                    else dp[i][j] = arr[i][j] + (int) Math.pow(10,9);
//                    dp[i][j] = Math.min(up, left);
                    int up = arr[i][j];
                    if (i > 0) up += dp[i - 1][j];
                    else up += (int) Math.pow(10, 9);

                    int left = arr[i][j];
                    if (j > 0) left += dp[i][j - 1];
                    else left += (int) Math.pow(10, 9);

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[arr.length - 1][arr[0].length - 1];
    }

    private static int solve(int[][] arr, int i, int j) {
        if (i == 0 && j == 0) return arr[0][0];
        if (i < 0 || j < 0) return (int) Math.pow(10, 9);

        int up = arr[i][j] + solve(arr, i - 1, j);
        int left = arr[i][j] + solve(arr, i, j - 1);

        return Math.min(up, left);
    }
}
