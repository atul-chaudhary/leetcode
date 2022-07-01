package com.atul.arrays;

import java.util.Arrays;

public class NumberOfVisiblePeopleInQueue {
    public static void main(String[] args) {
        int[] arr = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(canSeePersonsCount(arr)));
    }

    public static int[] canSeePersonsCount(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int mtn = Integer.MIN_VALUE;
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if(j== i+1){
                    mtn = arr[j];
                }
                int mina = Math.min(arr[i], arr[j]);
                if(mtn <= mina){
                    count++;
                }
                if(mtn > arr[j]){
                    mtn = arr[j];
                }
            }
            result[i] = count;
        }
        return result;
    }
}
