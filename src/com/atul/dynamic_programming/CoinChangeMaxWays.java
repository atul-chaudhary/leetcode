package com.atul.dynamic_programming;

import java.util.Arrays;

public class CoinChangeMaxWays {
    public static void main(String[] args) {
        int[] change = {1,2,5};
        int sum = 11;
        System.out.println(coinChange(change, sum, change.length));

        ///
        int n = change.length;
        int[][] dp = new int[n+1][sum+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(coinChangeMemo(change, sum, n , dp));
    }

    public static int coinChangeMemo(int[] arr, int sum, int n, int[][] dp){
        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        if(arr[n-1] <= sum){
            dp[n][sum] = coinChangeMemo(arr, sum - arr[n-1], n, dp) + coinChangeMemo(arr, sum, n-1, dp);
            return dp[n][sum];
        }else{
            dp[n][sum] = coinChangeMemo(arr,sum, n-1, dp);
            return dp[n][sum];
        }
    }

    public static int coinChange(int[] arr, int sum, int n){
        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }

        if(arr[n-1] <= sum){
            return coinChange(arr, sum - arr[n-1], n) + coinChange(arr, sum, n-1);
        }else{
            return coinChange(arr,sum, n-1);
        }
    }
}
