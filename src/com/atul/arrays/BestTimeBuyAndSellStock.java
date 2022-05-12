package com.atul.arrays;

public class BestTimeBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfitLinear(arr));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public static int maxProfitLinear(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min){
                min = prices[i];
            }
            //System.out.println(min);
            if((prices[i] - min) > profit){
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}
