package com.atul.arrays;

import com.atul.strings.Interf;

import java.util.function.Predicate;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};

        Predicate<Integer> predicate = e-> e%2==0;
        maxSlidingWindow(arr, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        for(int i=0;i< nums.length;i=i+k-1){
            for (int j = i; j < i+k; j++) {
                System.out.print(nums[j]+ " ");
            }
            System.out.println();
        }
        return null;
    }
}
