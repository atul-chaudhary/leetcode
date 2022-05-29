package com.atul.arrays;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i] > 0){
                nums[Math.abs(nums[i]-1)] *=-1;
            }
        }
        System.out.println(Arrays.toString(nums));
        int result = -1;
        for(int i=0;i < len ;i++){
            if(nums[i] >=0 ){
                result = i+1;
            }
        }
        return result;
    }
}
