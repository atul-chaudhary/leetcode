package com.atul.dynamic_programming;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return solveTab(nums);
        //return solve(nums, 0, dp);
    }
    private static boolean solveTab(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (dp[i+j]== true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }


    private static boolean solve(int[] nums, int i, Boolean[] dp) {
        if (i+nums[i] >= nums.length-1) return true;
        if(dp[i] != null) return dp[i];
        for (int j = 1; j <= nums[i]; j++) {
            if (solve(nums, i+j, dp) == true) {
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}
