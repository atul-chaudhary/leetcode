package com.atul.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        } else {
            int p1 = 0, p2 = 1;
            while (p2 < len) {
                if (arr[p1] == 0 && arr[p2] != 0) {
                    int temp = arr[p1];
                    arr[p1] = arr[p2];
                    arr[p2] = temp;
                    p1++;
                    p2++;
                } else if (arr[p2] == 0) {
                    p2++;
                } else {
                    p1++;
                }
                System.out.println(p1+ " "+ p2);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroesLinear(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[j] > 0) {
                        arr[i] = arr[j];
                        arr[j] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
