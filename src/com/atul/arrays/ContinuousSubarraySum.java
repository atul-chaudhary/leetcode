package com.atul.arrays;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 0};//{23,2,4,6,7};
        int k = 2;//6;

        boolean result = checkSubarraySum(arr, k);
        System.out.println(result);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int curSum = nums[i];
            for (int j = i + 1; j < len; j++) {
                curSum += nums[j];
                if (curSum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkSubarraySumNew(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % k == 0) {
            for (int i = 0; i < len; i++) {
                int result = sum / k;
                if (result == nums[i])
                    return true;
            }
        }
        return false;
    }
}
