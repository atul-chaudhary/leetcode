package com.atul.dynamic_programming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(solve(nums, nums.length - 1));
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(solveTabSap(nums));
    }

    private static int solveTabSap(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int left = nums[i];
            if (i > 1) left += prev2;
            int right = prev;
            int cur = Math.max(left, right);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    private static int solveTab(int[] nums, int[] dp) {
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int left = nums[i];
            if (i > 1) left += dp[i - 2];
            int right = dp[i - 1];
            dp[i] = Math.max(left, right);
        }
        return dp[nums.length - 1];
    }

    private static int solve(int[] nums, int index) {
        if (index == 0) {
            return nums[0];
        }
        if (index < 0) return 0;

        int left = solve(nums, index - 2) + nums[index];
        int right = solve(nums, index - 1);

        return Math.max(left, right);
    }
}
