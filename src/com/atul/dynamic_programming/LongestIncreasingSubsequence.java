package com.atul.dynamic_programming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = nums.length;
        Integer[][] dp = new Integer[n][n+1];
        System.out.println(solve(nums, 0, -1, nums.length, dp));
        System.out.println(solveTab(nums));
    }

    private static int solveTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for (int index = n-1; index >= 0 ; index--) {
            for (int prev = index-1; prev >= -1 ; prev--) {
                int nottake = dp[index + 1][prev +1];
                int take = 0;
                if (prev == -1 || arr[index] > arr[prev]) {
                    take = 1 + dp[index + 1][index+1];
                }
                dp[index][prev+1] = Math.max(nottake, take);
            }
        }
        return dp[0][0];
    }

    private static int solve(int[] arr, int index, int prev, int n, Integer[][] dp) {
        if (index == n) {
            return 0;
        }
        if (dp[index][prev + 1] != null) return dp[index][prev+1];
        int nottake = solve(arr, index + 1, prev, n, dp);
        int take = 0;
        if (prev == -1 || arr[index] > arr[prev]) {
            take = 1 + solve(arr, index + 1, index, n, dp);
        }
        return dp[index][prev+1] = Math.max(nottake, take);
    }
}
