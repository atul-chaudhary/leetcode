package com.atul.dynamic_programming;

import java.security.spec.RSAOtherPrimeInfo;

public class BestTimeBuySellStockwithTransactionFee {

    public static void main(String[] args) {
        int[] arr = {1,3,2,8,4,9};
        int fee = 2;
        Integer[][] dp = new Integer[arr.length+1][2];
        System.out.println(solve(arr, 0, 1, arr.length, dp, fee));
        System.out.println(solev(arr, fee));
    }

    private static int solev(int[] arr, int fee){
        int n = arr.length;
        int[][] dp = new int[n+1][2];
        for (int index = n-1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                if(buy == 1){
                    dp[index][buy] = Math.max(-arr[index] + dp[index +1][0],
                            dp[index +1][1]);
                }else{
                    dp[index][buy] = Math.max(arr[index] - fee + dp[index + 1][1], dp[index+1] [0]);
                }
            }
        }
        return dp[0][1];
    }

    private static int solve(int[] arr, int index, int buy, int n, Integer[][] dp, int fees){
        if(index >= n) return 0;

        if(dp[index][buy] != null) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[index] + solve(arr, index +1, 0, n,dp, fees),
                    solve(arr, index +1, 1, n,dp, fees));
        }else{
            profit = Math.max(arr[index] - fees + solve(arr, index + 1, 1, n,dp, fees),
                    solve(arr, index+1, 0, n,dp, fees)
            );
        }
        return dp[index][buy] = profit;
    }
}
