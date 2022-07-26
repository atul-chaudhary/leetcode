package com.atul.recursion;

import java.util.ArrayList;

public class SumOfFirstNNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        subse(arr, 0,arr.length - 1, arrayList, new ArrayList<>());
        System.out.println(arrayList);
    }

    public static void subse(int[] arr, int i,int n, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> cur) {
        if (i > n) {
            list.add(new ArrayList<>(cur));
            return;
        }
        cur.add(arr[i]);
        subse(arr, i+1, n ,list, cur);
        cur.remove(cur.size()-1);

        subse(arr, i+1, n,list, cur);
    }

    public static int solve(int i, int n) {

        if (i == 1) return 1;

        int result = solve(i - 1, n);

        return result + i;
    }

    public static void reverse(int[] arr, int i, int j) {
        if (i == j) return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i + 1, j - 1);
    }
}
