package com.atul.arrays;

import java.util.Arrays;
import java.util.TreeMap;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        int[] temp  =sortedSquares(arr);
        System.out.println(Arrays.toString(temp));
    }

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int p1 = 0;
        int p2 = len-1;
        int[] arr = new int[len];
        int index = len-1;
        while(p1 < p2){
            int a = Math.abs(nums[p1]);
            int b = Math.abs(nums[p2]);
            if(a < b){
                arr[index] = b;
                p2--;
                index--;
            }else {
                arr[index] = a;
                p1++;
                index--;
            }
        }
        if (p1 == p2){
            arr[index] = nums[p1];
        }
        for(int i = 0; i<len;i++){
            arr[i] = arr[i] * arr[i];
        }
        return arr;
    }
}
