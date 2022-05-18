package com.atul.arrays;

public class ValidMountain {
    public static void main(String[] args) {
        int[] arr = {3, 5, 5};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        int len = arr.length;
        int i = 0;
        for (i = 0; i < len - 1; i++) {
            if (arr[i] < arr[i + 1]) continue;
            else break;
        }
        //System.out.println(i);
        if (i == 0 || i == len - 1) return false;
        for (int j = i; j < len - 1; j++) {
            //System.out.println(arr[j]);
            if (arr[j] > arr[j + 1]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
