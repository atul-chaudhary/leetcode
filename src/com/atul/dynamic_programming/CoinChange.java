package com.atul.dynamic_programming;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int target = 11;
        System.out.println(coinChange(arr, target));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        Integer[] dp = new Integer[amount+1];
        int ans = solve(coins, amount, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

    private static int solveTab(int[] nums, int target){
        int[] dp = new int[target];
        return 0;
    }

    private static int solve(int[] nums, int target){
        if(target == 0) return 0;
        if(target < 0) return Integer.MAX_VALUE;

        int result = Integer.MAX_VALUE;
        for(int coin : nums){
            int ans = solve(nums, target - coin);
            if(ans != Integer.MAX_VALUE){
                result = Math.min(result, 1+ ans);
            }
        }
        return result;
    }

    private static int solve(int[] nums, int target, Integer[] dp){
        if(target == 0) return 0;
        if(target < 0) return Integer.MAX_VALUE;

        if(dp[target] != null) return dp[target];

        int result = Integer.MAX_VALUE;
        for(int coin : nums){
            int ans = solve(nums, target - coin, dp);
            if(ans != Integer.MAX_VALUE){
                result = Math.min(result, 1+ ans);
            }
        }
        return dp[target] = result;
    }
}
