package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int[][] mat = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        maxEnvelopes(mat);
    }

    public static int maxEnvelopes(int[][] mat) {

        Arrays.sort(mat, (arr1, arr2) -> {
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
        });

        for (int[] arr: mat){
            System.out.println(Arrays.toString(arr));
        }
        return 0;
    }
}
