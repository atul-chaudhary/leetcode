package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int result = maxSlidingWindow(arr, 3);
        System.out.println(result);
    }

    public static int maxSlidingWindow(int[] nums, int k) {
        int l = nums.length - k +1;
        int[] arr = new int[l];
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                count++;
            }

            if(count > k){
                count  =0;
                max = Integer.MIN_VALUE;
            }

            arr[i] = max;
        }
        System.out.println(Arrays.toString(arr));
        return 0;
    }
}
