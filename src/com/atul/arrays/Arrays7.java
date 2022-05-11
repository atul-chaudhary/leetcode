package com.atul.arrays;

import java.util.Arrays;

public class Arrays7 {

    public static void main(String[] args) {
        int[] arr = {2,3,5,4,1,7};
        System.out.println(Arrays.toString(shuffle(arr, 3 )));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] temp = new int[2*n];
        for (int i = 0, j = 0; i < n; i++, j = j+2) {
            temp[j] = nums[i];
        }
        for (int i = n, j = 1; i < 2*n; i++, j = j+2) {
            temp[j] = nums[i];
        }

        //System.out.println(Arrays.toString(temp));
        return temp;
    }
}
