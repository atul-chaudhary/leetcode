package com.atul.arrays;

import java.util.Arrays;

public class Arrays3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] result = runningSum(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        for(int i=0; i< nums.length;i++){
            if(i==0){
                temp[i] = nums[i];
            }else{
                temp[i] = temp[i-1] + nums[i];
            }
        }
        return temp;
    }
}
