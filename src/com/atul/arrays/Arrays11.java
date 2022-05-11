package com.atul.arrays;

public class Arrays11 {
    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 56, 10000, 167};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //long maxlong = Long.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }

            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println(min+ " "+ max);
    }
}
