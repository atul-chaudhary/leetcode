package com.atul.contest;

public class CountNumberBadPairs {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(countBadPairs(arr));
    }

    public  static long countBadPairs(int[] nums) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(j - i != nums[j] - nums[i]){
                    count++;
                }
            }
        }
        return count;
    }
}
