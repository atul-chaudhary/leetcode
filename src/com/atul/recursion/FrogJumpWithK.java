package com.atul.recursion;

public class FrogJumpWithK {
    public static void main(String[] args) {
        int[] nums = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[nums.length + 1];
        System.out.println( solveTab(nums, dp, 2));
    }

    private static int solveTab(int[] nums, int[] dp, int k) {
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if(i-j<0) continue;
                int jum = dp[i-j] + Math.abs(nums[i] -nums[i-j]);
                min = Math.min(min, jum);
            }
            dp[i] = min;
        }

        return dp[nums.length-1];
    }

}
