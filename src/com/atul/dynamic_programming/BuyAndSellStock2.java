package com.atul.dynamic_programming;

import java.util.Arrays;

public class BuyAndSellStock2 {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//        System.out.println(solve(arr, 0, 1, arr.length));

        int n =6;
        long Arr[] = {7,1,5,3,6,4};

        System.out.println("The maximum profit that can be generated is "+getMaximumProfit(Arr, n));
    }

    static long getMaximumProfit(long Arr[], int n)
    {

        long dp[][]=new long[n+1][2];
        for(long row[]: dp)
            Arrays.fill(row,-1);

        dp[n][0] = dp[n][1] = 0;


        for(int ind= n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                long profit=0;

                if(buy==0){// We can buy the stock
                    profit = Math.max(0+dp[ind+1][0], -Arr[ind] + dp[ind+1][1]);
                }

                if(buy==1){// We can sell the stock
                    profit = Math.max(0+dp[ind+1][1], Arr[ind] + dp[ind+1][0]);
                }

                dp[ind][buy]  = profit;
            }
        }
        System.out.println();
        for(long[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[0][0];
    }

    private static int solve(int[] arr, int index, int buy, int n){
        if(index == n) return 0;

        int profit = 0;
        if(buy == 1){
            profit  = Math.max(-arr[index]+ solve(arr, index+1, 0, n), solve(arr, index+1, 1, n));
        }else{
            profit =  Math.max(arr[index]+solve(arr, index+1, 1, n), solve(arr, index+1, 0, n));
        }

        return profit;
    }
}
