package com.atul.arrays;

import java.util.Arrays;

public class Arrays10 {
    public static void main(String[] args) {
        String s = "001011";
        System.out.println(Arrays.toString(minOperations(s)));
    }

    public static int[] minOperations(String boxes) {
        int[] temp = new int[boxes.length()];
        int length = boxes.length();
        for (int i = 0; i < length; i++) {
            int noOfOperation = 0;
            for (int j = 0; j < length; j++) {
                if(i != j && boxes.charAt(j) != '0'){
                    noOfOperation += Math.abs(j-i);
                }
            }
            temp[i] = noOfOperation;
        }
        return temp;
    }
}
