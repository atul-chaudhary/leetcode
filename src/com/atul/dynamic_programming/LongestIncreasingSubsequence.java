package com.atul.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = nums.length;
//        Integer[][] dp = new Integer[n][n+1];
//        System.out.println(solve(nums, 0, -1, nums.length, dp));
//        System.out.println(solveTab(nums));
        System.out.println(solve(nums));
    }

    //printing
    private static ArrayList<Integer> solve(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for (int index = 0; index < n; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if(arr[prev] < arr[index] && 1 + dp[prev] > dp[index]){
                    dp[index] =  1+ dp[prev];
                    hash[index] = prev;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(hash));
        int max = 1;
        int max_index = 0;
        for (int i = 0; i < n; i++) {
                if(arr[i] > max){
                    max = arr[i];
                    max_index = i;
                }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int prev = 0;
        while(true){
            arrayList.add(arr[max_index]);
            prev = max_index;
            max_index = hash[max_index];
            if(prev == max_index){
                break;
            }
        }

        return arrayList;
    }

    //this is more optimised version
    private int solveOtp(int[] arr){
        int n = arr.length;
        int[]dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=0;i<n;i++){
            for(int prev =0 ; prev < i;prev++){
                if(arr[prev] < arr[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
        }

        int ans = 1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private static int solveTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for (int index = n-1; index >= 0 ; index--) {
            for (int prev = index-1; prev >= -1 ; prev--) {
                int nottake = dp[index + 1][prev +1];
                int take = 0;
                if (prev == -1 || arr[index] > arr[prev]) {
                    take = 1 + dp[index + 1][index+1];
                }
                dp[index][prev+1] = Math.max(nottake, take);
            }
        }
        return dp[0][0];
    }

    private static int solve(int[] arr, int index, int prev, int n, Integer[][] dp) {
        if (index == n) {
            return 0;
        }
        if (dp[index][prev + 1] != null) return dp[index][prev+1];
        int nottake = solve(arr, index + 1, prev, n, dp);
        int take = 0;
        if (prev == -1 || arr[index] > arr[prev]) {
            take = 1 + solve(arr, index + 1, index, n, dp);
        }
        return dp[index][prev+1] = Math.max(nottake, take);
    }
}
