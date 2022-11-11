package com.atul.greedy;

import java.util.Arrays;

public class LargestSumAverages {
    public static void main(String[] args) {
        int[] arr = {9,1,2,3,9};
        System.out.println(largestSumOfAverages(arr, 3));
    }

    public static double largestSumOfAverages(int[] nums, int k) {
        Arrays.sort(nums);
        double sum = 0.0;
        int count = 0;
        int temp_sum = 0;
        int n =nums.length;
        for (int i = n-1; i >= 0; i--) {
            if(k>1){
                sum+=nums[i];
            }else {
                temp_sum+=nums[i];
                count++;
            }
            k--;
        }
        System.out.println(sum);
        sum+=((temp_sum)*1.0)/count;
        return sum;
    }
}
