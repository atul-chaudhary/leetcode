package com.atul.arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {0,0};
        System.out.println(arr.length);
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int max = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(nums));
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1 == nums[i]){
                count++;
                max = Math.max(max, count);
            }else{
                count = 1;
            }
        }
        return max;
    }
}
