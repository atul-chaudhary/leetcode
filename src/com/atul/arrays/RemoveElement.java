package com.atul.arrays;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 2));
    }
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int first = 0;
        int last = len-1;
        while (first < last){
            if(nums[first] == val && nums[last] != val){
                int temp = nums[first];
                nums[first] = nums[last];
                nums[last] = temp;
                first++;
                last--;
            }
            if(nums[last] == val){
                last--;
            }
            if(nums[first] != val){
                first++;
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i]!= val){
                count++;
            }else {
                nums[i] = 0;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return count;
    }
}
