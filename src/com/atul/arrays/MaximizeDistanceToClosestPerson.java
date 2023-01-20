package com.atul.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(maxDistToClosest(nums));
    }

    public static int maxDistToClosest(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                left[i] = i;
                lastIndex = i;
            } else {
                left[i] = lastIndex;
            }
        }
        lastIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                right[i] = i;
                lastIndex = i;
            } else {
                right[i] = lastIndex;
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int max = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) continue;
            int min = Integer.MAX_VALUE;
            if(right[i] == -1){
                min = i - left[i];
            }else if(left[i] == -1){
                min = right[i] - i;
            }else {
                min = Math.min(right[i] - i, i - left[i]);
            }
            max = Math.max(max, min);
        }
        return max;
    }
}
