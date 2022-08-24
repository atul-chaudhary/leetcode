package com.atul.dynamic_programming;

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int n = prices.length;
        Integer dp[][]  = new Integer[n+1][2];
        System.out.println(solve(prices, 0, 1, n, dp));
        System.out.println(solve(prices));
    }

    private static int solve(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n+2][2];
        for (int index = n-1; index >=0 ; index--) {
            for (int buy = 0; buy < 2; buy++) {
                if(buy == 1){
                    dp[index][buy] = Math.max(-arr[index] + dp[index +1][0],
                            dp[index +1][1]);
                }else{
                    dp[index][buy] = Math.max(arr[index] + dp[index + 2][1],
                            dp[index+1][0]
                    );
                }
            }
        }
        return dp[0][1];
    }

    private static int solve(int[] arr, int index, int buy, int n, Integer[][] dp){
        if(index >= n) return 0;

        if(dp[index][buy] != null) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[index] + solve(arr, index +1, 0, n,dp),
                    solve(arr, index +1, 1, n,dp));
        }else{
            profit = Math.max(arr[index] + solve(arr, index + 2, 1, n,dp),
                    solve(arr, index+1, 0, n,dp)
            );
        }
        return dp[index][buy] = profit;
    }
}
