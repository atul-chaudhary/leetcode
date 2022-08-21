package com.atul.dynamic_programming;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        System.out.println(solve(arr));
        System.out.println(solve(arr, 0, 1, 2, arr.length));
    }

    private static int solve(int[] arr, int index, int buy, int cap, int n){
        if(cap == 0) return 0;
        if(index == n) return 0;
        int profit = 0;
        if(buy == 1){
            profit = Math.max(
                    -arr[index] + solve(arr, index +1, 0, cap, n),
                    0 + solve(arr, index +1, 1, cap, n)
            );
        }else{
            profit = Math.max(
              arr[index] + solve(arr, index + 1,  1, cap -1, n),
                    0 + solve(arr, index +1, 0, cap, n)
            );
        }
        return profit;
    }

    private static int solve(int[] arr) {
        int minLeft = Integer.MAX_VALUE;
        int profitLeft = 0;
        int[] profitL = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            minLeft = Math.min(minLeft, arr[i]);
            profitLeft = Math.max(profitLeft,arr[i]-minLeft);
            profitL[i] = profitLeft;
        }
        int maxRight = Integer.MIN_VALUE;
        int profitRight = 0;
        int[] profitR = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, arr[i]);
            profitRight = Math.max(profitRight, maxRight -  arr[i]);
            profitR[i] = profitRight;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, profitL[i]+ profitR[i]);
        }
        return max;
    }
}
