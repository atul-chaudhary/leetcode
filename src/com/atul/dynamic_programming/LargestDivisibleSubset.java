package com.atul.dynamic_programming;

import java.util.ArrayList;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1,2,4,8};
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(solve(arr, 0, -1, arr.length,new ArrayList<>()));
    }

    private static ArrayList<Integer> solve(int [] arr, int index, int prev, int n, ArrayList<Integer> result){
        if(index == n) return result;

        solve(arr, index +1, prev, n, result);
        if(prev == -1 || arr[index] % arr[prev] == 0){
            result.add(arr[index]);
            solve(arr, index + 1, prev, n, result);
            //result.remove(result.size()-1);
        }
        return result;
    }
}
