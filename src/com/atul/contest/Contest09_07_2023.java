package com.atul.contest;

import java.beans.IntrospectionException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Contest09_07_2023 {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 2, 1};
        int[] nums2 = {2, 2, 3, 4};
        System.out.println(maxNonDecreasingLength(num1, nums2));
    }

    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(nums1[i], nums2[i]);
            result[i] = min;
        }
        System.out.println(Arrays.toString(result));
        int count = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (result[i] < result[i - 1]) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }


    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        Integer[] dp = new Integer[n + 1];
        int result = solve(nums, 0, target, dp);
        if(result <= -1){
            return -1;
        }
        return result;
    }

    private static int solve(int[] nums, int i, int target, Integer[] dp) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (dp[i] != null) return dp[i];
        int max = Integer.MIN_VALUE;
        for (int j = i + 1; j < nums.length; j++) {
            int num = nums[j] - nums[i];
            if (num >= -target && num <= target) {
                int temp = 1 + solve(nums, j, target, dp);
                max = Math.max(max, temp);

            }
        }
        return dp[i] = max;
    }

    public int getMax(int index, int[] nums, int target, Integer[] dp) {
        if (index >= nums.length - 1)
            return 0;
        if (dp[index] != null)
            return dp[index];
        int result = Integer.MIN_VALUE;
        for (int i = index + 1; i < nums.length; i++) {
            if ((target * -1) <= nums[i] - nums[index] && nums[i] - nums[index] <= target)
                result = Math.max(result, getMax(i, nums, target, dp) + 1);
        }
        return dp[index] = result;
    }
}
