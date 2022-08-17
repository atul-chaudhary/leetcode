package com.atul.dynamic_programming;

public class CoinChange {
    public static void main(String[] args) {
        //System.out.println((int) 1e9);
        int[] arr = {1, 2, 5};
        int target = 11;
        System.out.println(solve(arr, arr.length-1, target));
    }

    private static int solve(int[] arr, int index, int target){
        if(index == 0){
            if(target % arr[index] == 0) return target / arr[index];
            return (int) 1e9;
        }
        int notPick = solve(arr, index - 1, target);
        int pick = Integer.MAX_VALUE;
        if(arr[index] <= target) {
            pick = 1 + solve(arr, index, target - arr[index]);
        }
        return Math.min(notPick, pick);
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
}
