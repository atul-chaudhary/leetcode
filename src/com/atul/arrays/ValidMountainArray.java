package com.atul.arrays;

import java.util.stream.Stream;

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 5};
        System.out.println(validMountainArray(arr));
    }

    public static synchronized boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if(len < 3)
            return false;
        for (int i = 0; i < len-1; i++) {

        }
        return false;
    }
}


