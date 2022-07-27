package com.atul.recursion;

import java.util.*;

public class combinationSum {
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2,5};
        List<Integer> ds = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        //Arrays.sort(arr);
        solve(arr, 0, 5, ds, result, arr.length);
        System.out.println(result);
    }

    private static void solve(int[] arr, int i, int target, List<Integer> ds, Set<List<Integer>> result, int n) {
        if(i == n){
            if(target==0){
                result.add(new ArrayList<>(ds));
                return;
            }
            return;
        }
        //if (arr[i] <= target) {
            ds.add(arr[i]);
            solve(arr, i+1, target - arr[i], ds, result, n);
            ds.remove(ds.size() - 1);
        //}
        solve(arr, i + 1, target, ds, result, n);
    }
}
