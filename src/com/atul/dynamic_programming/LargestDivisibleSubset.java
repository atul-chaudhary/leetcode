package com.atul.dynamic_programming;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> result = new ArrayList<>();
        solve(arr, 0, -1, arr.length,new ArrayList<>());
        System.out.println(actualResult);
        //System.out.println(largestDivisibleSubset(arr));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return solve(nums);
    }

    private static ArrayList<Integer> solve(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        int max_index = 0;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] % arr[prev] == 0 && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                max_index = i;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(hash));

//        for (int i = 0; i < n; i++) {
//            if (dp[i] > max) {
//                max = dp[i];
//                max_index = i;
//            }
//        }
        ArrayList<Integer> result = new ArrayList<>();
        int prev = 0;
        while (true) {
            result.add(arr[max_index]);
            prev = max_index;
            max_index = hash[max_index];
            if (prev == max_index) {
                break;
            }
        }
        Collections.sort(result);
        return result;
    }


    static ArrayList<Integer> actualResult = new ArrayList<>();
    private static void solve(int[] arr, int index, int prev, int n, ArrayList<Integer> result) {
        if (index >= n){
            if(result.size() > actualResult.size()){
                actualResult.clear();
                actualResult.addAll(result);
            }
            return;
        };

        solve(arr, index + 1, prev, n, result);
        if (prev == -1 || arr[index] % arr[prev] == 0 || arr[prev] % arr[index] == 0) {
            result.add(arr[index]);
            solve(arr, index + 1, prev, n, result);
            result.remove(result.size()-1);
        }
    }
}
