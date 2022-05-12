package com.atul.arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,2,2,2,0,1,3,3,3,3,3};
        System.out.println(MaxCount(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = Math.max(count, result);
            } else count = 0;
        }

        return result;
    }

    //to handle multiple types
    //{1,1,0,2,2,2,0,1,3,3,3,3,3}

    public static int MaxCount(int[] arr) {
        int count = 0;
        int max = 0;
        int currentElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(currentElement == arr[i]){
                count++;
                max = Math.max(max, count);
            }else if(currentElement != arr[i]){
                currentElement = arr[i];
                count = 1;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
