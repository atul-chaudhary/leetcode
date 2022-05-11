package com.atul.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len ==1){
            return;
        }else {
            int p1 = 0;
            int p2 = 1;
            while(p1 < len && p2 < len){
                if(nums[p1] == 0 && nums[p2] != 0){
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                    p1++;
                    p2++;
                }
                if( p1< len && nums[p1] != 0){
                    p1++;
                }
                if(p2<len && nums[p2] != 0){
                    p2++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
