package com.atul.arrays;

import java.util.Arrays;

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray(nums);
        update(1, 2);
        System.out.println(Arrays.toString(arr));
    }

    static int[] arr;
    public static void NumArray(int[] nums) {
        int i=0;
        int sum = 0;
        arr = new int[nums.length];
        for(int it:nums){
            sum+=it;
            arr[i++] = sum;
        }

        return;
    }

    public static void update(int index, int val) {
        if(index == 0){
            arr[index] = val;
            int sum = val;
            for(int i =index+1;i<arr.length;i++){
                sum+=arr[i];
                arr[i] = sum;
            }

        }else{
            int sum = arr[index-1]+val;
            arr[index] = sum;
            for(int i=index+1;i<arr.length;i++){
                sum+=arr[i];
                arr[i] = sum;
            }
        }
    }

    public static int sumRange(int left, int right) {
        if(left == 0){
            return arr[right];
        }
        return arr[right] - arr[left-1];
    }
}
