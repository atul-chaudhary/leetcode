package com.atul.dynamic_programming;

import java.util.Arrays;

public class BestTimeToBuyAndSell4 {
    public static void main(String[] args) {
        int[] arr  = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(solve(arr, 0, 1, k, arr.length));
        System.out.println(maxProfit(k, arr));
    }

    public  static int maxProfit(int k, int[] prices) {
        return solveTab(prices, k);
    }

    private static int solveTab(int[] arr, int k){
        int n = arr.length;
        int[][][] dp = new int[n+1][2][k+1];
        for (int index = n-1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < k + 1; cap++) {
                    if(buy == 1){
                        dp[index][buy][cap] = Math.max(-arr[index] + dp[index + 1][0][cap] , dp[index +1][1][cap]);
                    }else{
                        dp[index][buy][cap]  = Math.max(arr[index] + dp[index + 1][1][cap-1], dp[index+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }

    private static int solve(int[] arr, int index, int buy, int cap, int n){
        if(cap==0) return 0;
        if(index == n) return 0;

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[index] + solve(arr, index + 1, 0, cap, n), solve(arr, index +1, 1, cap, n));
        }else{
            profit  = Math.max(arr[index] + solve(arr, index + 1, 1, cap-1, n), solve(arr, index+1, 0, cap, n));
        }
        return profit;
    }
}
