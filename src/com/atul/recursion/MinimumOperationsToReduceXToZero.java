package com.atul.recursion;

public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int target = 5;
        System.out.println(minOperations(nums, target));
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int result = solve(nums, x, left, right);
        return result == (int)1e6 ? -1 : result;
    }

    private static int solve(int[] nums, int target, int left, int right) {
        if (target == 0) return 0;
        if (target < 0 || left > right) return (int) 1e6;

        int leftPick = 1+solve(nums, target - nums[left], left + 1, right);
        int rightPick = 1+solve(nums, target - nums[right], left, right - 1);

        return Math.min(leftPick, rightPick);
    }
}
