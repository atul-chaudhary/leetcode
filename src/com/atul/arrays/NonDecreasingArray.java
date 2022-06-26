package com.atul.arrays;

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] arr  ={5,7,1,8};
        System.out.println(checkPossibility(arr));
    }
    public static boolean checkPossibility(int[] nums) {
        int count_num = 0;
        if(nums.length==1){
            return true;
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                count_num++;
            }
        }

        if(count_num > 1){
            return false;
        }

        for(int i=1;i<nums.length-1;i++){
            if(nums[i] <= nums[i-1] && nums[i] < nums[i+1]){
                if(nums[i+1] - nums[i-1] < 0){
                    return false;
                }
            }
            if(nums[i] >= nums[i-1] && nums[i] > nums[i+1]){
                System.out.println(nums[i]);
                if(nums[i+1] - nums[i-1] < 0){
                    return false;
                }
            }

        }

        return true;
    }
}
