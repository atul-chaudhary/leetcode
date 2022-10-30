package com.atul.dynamic_programming;

public class JumpGameII {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1};
        System.out.println((int)'w'-'a');
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return solve(nums, 0, 0, dp);
    }

    private static int solve(int[] nums, int index, int count, Integer[] dp){
        if(index >= nums.length-1) return count;
        if(dp[index] != null) return dp[index];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            int temp = solve(nums, index+i, count+1,dp);
            min = Math.min(min, temp);
        }
        return dp[index] = min;
    }
}
