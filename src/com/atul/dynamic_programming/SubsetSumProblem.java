package com.atul.dynamic_programming;

import java.util.Arrays;

public class SubsetSumProblem {
    static int[][] dp;

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int target = 11;
        dp = new int[arr.length+1][target+1];

        long startTime = System.nanoTime();
        System.out.println(solveRecursion(arr, target, arr.length));
        long endTime = System.nanoTime();

        System.out.println("Total execution time: " + (endTime - startTime));


        for (int[] it : dp){
            Arrays.fill(it, -1);
            System.out.println(Arrays.toString(it));
        }

        long startTime1 = System.nanoTime();
        System.out.println(solve(arr, target, arr.length));
        long endTime1 = System.nanoTime();

        System.out.println("Total execution time VV : " + (endTime1 - startTime1));

        for (int[] it : dp){
            System.out.println(Arrays.toString(it));
        }

    }

    public static boolean solveRecursion(int[] arr, int target, int size) {

        if(target == 0){
            return true;
        }
        if(size == 0){
            return false;
        }

        if(arr[size-1] > target){
            return solveRecursion(arr, target, size -1);
        }

        return solveRecursion(arr, target - arr[size - 1], size - 1) || solveRecursion(arr, target, size - 1);
    }

    public static int solve(int[] arr, int target, int size) {
        if(target == 0){
            return 1;
        }
        if(size == 0){
            return 0;
        }

        if (dp[size][target] != -1){
            return dp[size][target];
        }

        if(arr[size-1] > target){
            dp[size][target] = solve(arr, target, size -1);
            return dp[size][target];
        }

        if(solve(arr, target - arr[size - 1], size - 1) != 0 || solve(arr, target, size - 1) != 0){
            return dp[size][target] = 1;
        }else{
            return dp[size][target] = 0;
        }
    }
}
