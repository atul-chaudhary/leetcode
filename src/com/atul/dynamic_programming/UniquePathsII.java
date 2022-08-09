package com.atul.dynamic_programming;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] dp = new int[arr.length][arr[0].length];
        System.out.println(solveTab(arr ,dp));
    }

    private static int solveTab(int[][] arr, int[][] dp){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i>0 && j>0 && arr[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if(i ==0 && j==0) dp[i][j] = 1;
                else {
                    int left = 0, right = 0;
                    if (i > 0) left = dp[i - 1][j];
                    if (j > 0) right = dp[i][j - 1];
                    dp[i][j] = left + right;
                }
            }
        }

        return dp[arr.length-1][arr[0].length-1];
    }
    private static int solve(int[][] arr, int i, int j, int n, int m, int[][] dp) {
        if (i >= n || j >= m) {
            return 0;
        }

        if (arr[i][j] == 1) {
            return 0;
        }

        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];
        int left = solve(arr, i + 1, j, n, m, dp);
        int right = solve(arr, i, j + 1, n, m, dp);
        return dp[i][j] = left + right;
    }
}
