package com.atul.contest;

public class LongestSubarrayWithMaximumBitwiseAND {
    public static void main(String[] args) {
        int[] sum = {311155,311155,311155,311155,311155,311155,311155,311155,201191,311155};
        System.out.println(longestSubarray(sum));
    }

    public static int longestSubarray(int[] nums) {
        int max = 0;
        for(int it : nums){
            max = Math.max(max, it);
        }
        System.out.println(max);
        int count = 0;
        int max_count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max == nums[i]){
                count++;
                max_count = Math.max(max_count, count);
            }else{
                count = 0;
            }
        }
        return max_count;
    }
}
