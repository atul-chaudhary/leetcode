package com.atul.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,5));
    }

    public static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        List<String> result = new ArrayList<>();
        solve(arr, 0, result, "");
        System.out.println(result);
        return result.get(k-1);
    }

    private static void solve(int[] arr, int cur, List<String> result, String temp){
        if(cur == arr.length){
            result.add(temp);
        }

        for(int i=cur;i<arr.length;i++){
            swap(i, cur, arr);
            temp = createString(arr);
            solve(arr, cur+1, result, temp);
            swap(i, cur, arr);
            temp = createString(arr);
        }
    }

    private static String createString(int[] arr){
        String s = "";
        for(int it : arr){
            s+=String.valueOf(it);
        }
        return s;
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
