package com.atul.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] nums = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[nums.length + 1];
//        Arrays.fill(dp, -1);
//        System.out.println(solve(nums, nums.length - 1, dp));
        System.out.println(solveTab(nums, 0, dp));
    }

    private static int solveTab(int[] nums, int index, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int left = dp[i - 1] + Math.abs(nums[i] - nums[i - 1]);
            int right = 0;
            if (i > 1) {
                right = dp[i-2]+Math.abs(nums[i]-nums[i-2]);
            }
            dp[i] = Math.min(left, right);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }

    private static int solve(int[] nums, int index, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) return dp[index];
        int left = solve(nums, index - 1, dp) + Math.abs(nums[index] - nums[index - 1]);
        int rigth = 0;
        if (index > 1) {
            rigth = solve(nums, index - 2, dp) + Math.abs(nums[index] - nums[index - 2]);
        }
        return dp[index] = Math.min(left, rigth);
    }
}
