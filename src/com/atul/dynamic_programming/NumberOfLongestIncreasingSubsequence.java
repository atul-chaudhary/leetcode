package com.atul.dynamic_programming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max = 1;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            count[i] = 1;
            for(int prev = 0; prev < i; prev++){

                if(arr[prev] < arr[i] && 1+ dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                    count[i] = count[prev];
                }else if(arr[prev] < arr[i] && 1+dp[prev] == dp[i]){
                    count[i] += count[prev];
                }
            }
            max = Math.max(max, dp[i]);

        }
        int result = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == max) result += count[i];
        }

        return result;
    }
}
