package com.atul.dynamic_programming;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        int[][] dp = new int[arr.length+1][4];
        for (int [] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(solve(arr, arr.length -1, 3, dp));
        for (int [] row : dp){
            System.out.println(Arrays.toString(row));
        }

    }

    private static int solveDp(int[][] arr, int[][] dp){
        return 0;
    }

    private static int solve(int[][] arr, int row, int prev, int[][] dp){
        if(row == 0){
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if(i != prev){
                    max = Math.max(max, arr[row][i]);
                }
            }
            return max;
        }
        //if(dp[row][prev] != -1) return dp[row][prev];
        int max = Integer.MIN_VALUE;
        for (int col = 0; col < 3; col++) {
            if(prev == 3 || col != prev){
                int result = arr[row][col] + solve(arr, row -1, col, dp);
                max = Math.max(max, result);
                //dp[row][col] = max;
            }
        }
        return dp[row][prev] = max;
    }
}
