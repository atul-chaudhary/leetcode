package com.atul.dynamic_programming;

import java.util.ArrayList;

public class MinimumSubSetDifference {
    public static void main(String[] args) {
        int[] arr = {1,6,11,5};//{ 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45 };
        int sum = 0;
        for (int it: arr){
            sum+= it;
        }
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        ArrayList<Integer> ar  = subSetSum(arr, sum, dp);
        System.out.println(ar);
        int min = Integer.MAX_VALUE;
        for(int i=0;i < ar.size();i++){
            min  = Math.min(min, Math.abs(sum - 2*ar.get(i)));
        }
        System.out.println(min);
    }

    public static ArrayList<Integer> subSetSum(int [] arr, int sum, boolean[][] dp){
        int n = arr.length;;
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<= sum;i++){
            if(dp[n][i]){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
