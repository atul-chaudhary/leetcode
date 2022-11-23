package com.atul.arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] arr = {-6,-5,-1,2,3,7,8};
        System.out.println(maximumProduct(arr));
    }

    public static int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        int neg1 = Integer.MAX_VALUE;
        int neg2 = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(first < nums[i]){
                third = second;
                second = first;
                first = nums[i];
            }else if(second < nums[i]){
                third = second;
                second = nums[i];
            }else if(third < nums[i]){
                third = nums[i];
            }

            if(neg1 > nums[i]){
                neg2 = neg1;
                neg1 = nums[i];
            }else if(neg2 > nums[i]){
                neg2 = nums[i];
            }
        }
        return Math.max(first*second*third, first*neg1*neg2);
    }
}
