package com.atul.arrays;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] arr = {1,1,4,2,1,3};
        System.out.println(heightChecker(arr));
    }
    public static int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != temp[i]){
                count++;
            }
        }
        return count;
    }
}
