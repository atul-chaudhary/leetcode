package com.atul.dynamic_programming;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int n = nums.length;
        int left = solve(nums, 0, n-2);
        int right = solve(nums,1, n-1);
        Math.max(left, right);
    }

    private static int solve(int[] nums, int start, int end){
        int st = start;
        int prev = nums[start];
        int prev2 = 0;
        for (int i = start; i <= end; i++) {
            int left = nums[i];
            if(i-st > 1) left += prev2;

            int right = prev;
            int cur = Math.max(left, right);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
