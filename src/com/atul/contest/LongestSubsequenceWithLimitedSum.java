package com.atul.contest;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        int[] nums = {4,5,2,1};//{736411,184882,914641,37925,214915};
        int[] que = {3,10,21};//{331244,273144,118983,118252,305688,718089,665450};
//        System.out.println(Arrays.toString(answerQueries(nums, que)));
//        System.out.println(Arrays.toString(solvefinal(nums, que)));
        System.out.println(Arrays.toString(answerQueriesTreeMap(nums, que)));
    }

    public static int[] answerQueriesTreeMap(int[] nums, int[] queries) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            map.put(sum, i+1);
        }
        System.out.println(map);
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            Integer ceil = map.floorKey(queries[i]);
            if(ceil != null){
                res[i] = map.get(ceil);
            }
        }
        return res;
    }

    //correct ans = [2,2,1,1,2,3,3]
    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int res= solve(nums, queries[i], 0, nums.length, 0);
            result[i] = res;
        }
        return result;
    }

    private static int[] solvefinal(int[] nums, int[] queries){
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = queries[i];
            int sum = 0;
            int count =0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if(sum <= cur){
                    count++;
                }else{
                    break;
                }
            }
            result[i] = count;
        }
        return result;
    }


    private static int solve(int[] arr, int sum, int i, int n, int cur){
        if(i >= n) return 0;
        int take = 0;
        if(cur+arr[i] <= sum){
            take  = 1 + solve(arr, sum, i+1, n, cur+arr[i]);
        }
        int notTake = solve(arr, sum, i+1, n, cur);
        return Math.max(take, notTake);
    }
}
