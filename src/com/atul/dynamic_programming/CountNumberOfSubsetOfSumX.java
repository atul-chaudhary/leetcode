package com.atul.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CountNumberOfSubsetOfSumX {
    public static void main(String[] args) {
        int[] arr = {1, 5,11, 5};
        int target = 11;
        int[][] dp = new int[arr.length+1][target+1];

        System.out.println(topDown(arr, target));

        ConcurrentHashMap<String, Integer> map =new ConcurrentHashMap<>();
        map.put("atul1", 30);
        map.put("atul2", 29);
        map.put("atul3", 45);
        map.put("atul4", 32);
        map.put("atul5", 33);

        System.out.println(map);
    }

    public static int topDown(int[] arr, int target){
        int[][] t = new int[arr.length+1][target+1];
        int n = arr.length;
        for(int i = 0;i < arr.length +1;i++){
            t[i][0] = 1;
        }

        for(int[] row : t){
            System.out.println(Arrays.toString(row));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        System.out.println();
        for(int[] row : t){
            System.out.println(Arrays.toString(row));
        }
        return t[n][target];
    }

    static int findWaysUtilDp(int ind, int target, int[] arr,int[][] dp){
        if(target==0)
            return 1;

        if(ind == 0)
            return arr[0] == target?1:0;

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = findWaysUtil(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target] = notTaken + taken;
    }

    static int findWaysUtil(int ind, int target, int[] arr,int[][] dp){
        if(target==0)
            return 1;

        if(ind == 0)
            return arr[0] == target ? 1 : 0;

        int notTaken = findWaysUtil(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = findWaysUtil(ind-1,target-arr[ind],arr,dp);

        return notTaken + taken;
    }

    public  static int numSubseq(int[] arr, int target) {
        long count = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                temp.add(arr[j]);
                result.add(new ArrayList<>(temp));
            }
        }
        System.out.println(result);
        for (List<Integer> integers : result) {
            int sum = 0;
            for (int j = 0; j < integers.size(); j++) {
                sum += integers.get(j);
            }
            if (sum == target) count++;
        }
        return (int) (count % 1000000007);
    }

    static int count = 0;
    public static boolean solve(int[] arr, int n, int sum, String s) {
        if (sum == 0) {
            //count++;
            System.out.println(s);
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (arr[n - 1] > sum) {
            return solve(arr, n - 1, sum, s + " " + arr[n - 1]);
        }

        return solve(arr, n - 1, sum - arr[n - 1], s + " " + arr[n - 1]) || solve(arr, n - 1, sum, s + " " + arr[n - 1]);
    }
}
