package com.atul.recursion;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class SubsetSums {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> subsetSums(int arr, int N){
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        //solve(arr, 0, 0, result, N);
        return result;
    }

    private static void solve(ArrayList<Integer> arr, int i, int sum, ArrayList<Integer> result, int n){

        if(i==n){
            result.add(sum);
            return;
        }

        sum+=arr.get(i);
        solve(arr, i+1, sum, result, n);
        sum-= arr.get(i);

        solve(arr, i+1, sum, result, n);
    }
}
