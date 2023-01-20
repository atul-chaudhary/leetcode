package com.atul.dynamic_programming;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {

    }

    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
           int curSum = 0;
            for (int j = i; j < n; j++) {
                curSum+=nums[i];
                if(curSum % k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int maxSum = nums[0];
        int totalSum = nums[0];
        int curMin = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < n; i++) {
            //case1
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);

            //case2
            curMin = Math.min(curMin + nums[i], nums[i]);
            minSum = Math.min(minSum, curMin);
            totalSum += nums[i];
        }
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}
