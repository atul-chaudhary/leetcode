package com.atul.dynamic_programming;

import java.util.Arrays;

public class CountSortedVowelStrings {
    public static void main(String[] args) {
        int n=33;
        System.out.println(countVowelStrings(n));
    }

    public static int countVowelStrings(int n) {
        int[] arr = new int[5];
        int i=0;
        for(int it: arr) arr[i++] = 1;
        i=1;
        while(i < n){
            i++;
            for(int j = arr.length-2;j>=0;j--){
                arr[j] = arr[j+1]+arr[j];
            }
            System.out.println(Arrays.toString(arr));
        }
        int sum = 0;
        for(int it : arr) sum+=it;

        return sum;
    }
}
