package com.atul.revision;

import java.util.HashMap;
import java.util.List;

public class DP {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int n = nums.length;
        HashMap<String, Integer> dp = new HashMap<>();
        System.out.println(solveTargetSum(nums, nums.length, target, 0, dp));
    }

    public List<String> addOperators(String num, int target) {
        return null;
    }

    private static int solveTargetSumWithChanges(int[] nums, int index, int target, int curSum, HashMap<String, Integer> dp) {
        if (index <= 0) {
            if(curSum == target){
                return 1;
            }
            return 0;
        }
        if(!dp.containsKey(index+"|"+curSum)){
            int post = solveTargetSum(nums, index - 1, target, curSum + nums[index - 1], dp);
            int neg = solveTargetSum(nums, index - 1, target, curSum - nums[index - 1], dp);
            dp.put(index+"|"+curSum, post+neg);
            return post+neg;
        }
        return dp.get(index+"|"+curSum);
    }



    private static int solveTargetSum(int[] nums, int index, int target, int curSum, HashMap<String, Integer> dp) {
        if (index <= 0) {
            if(curSum == target){
                return 1;
            }
            return 0;
        }
        if(!dp.containsKey(index+"|"+curSum)){
            int post = solveTargetSum(nums, index - 1, target, curSum + nums[index - 1], dp);
            int neg = solveTargetSum(nums, index - 1, target, curSum - nums[index - 1], dp);
            dp.put(index+"|"+curSum, post+neg);
            return post+neg;
        }
        return dp.get(index+"|"+curSum);
    }

    private static int solveCount(int[] nums, int sum, int index, Boolean[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (index == 0) {
            return 0;
        }
        return solveCount(nums, sum - nums[index - 1], index - 1, dp) + solveCount(nums, sum, index - 1, dp);
    }


    private static boolean solveTab(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];

                }
            }
        }
        return dp[n][sum];
    }

    private static boolean solve(int[] nums, int sum, int index, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (index < 0) {
            return false;
        }
        if (dp[index][sum] != null) return dp[index][sum];
        if (nums[index] > sum) {
            return dp[index][sum] = solve(nums, sum, index - 1, dp);
        }
        return dp[index][sum] = solve(nums, sum - nums[index], index - 1, dp) ||
                solve(nums, sum, index - 1, dp);
    }
}
