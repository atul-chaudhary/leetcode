package com.atul.sorting;

import java.util.Arrays;

public class Sum3Closest {
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int left = i+1;
            int right = n-1;
            while (left < right){
                int sum = num + nums[left]+ nums[right];
                int cal = Math.abs(target - sum);
                if(cal < diff){
                    diff = cal;
                    result = sum;
                }
                if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }else if(sum == target){
                    break;
                }
            }
        }
        return result;
    }
}
