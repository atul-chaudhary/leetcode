package com.atul.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        int [] temp = new int[k];
        int len = nums.length;
        k = k%len;
        for(int i=len-1;i>=0;i--){
            if(i >= len-k){
                temp[len-i-1] = nums[i];
            }else {
                nums[i+k] = nums[i];
            }
        }
        for(int i=0;i<k;i++){
            nums[i] = temp[i];
        }
    }
}
