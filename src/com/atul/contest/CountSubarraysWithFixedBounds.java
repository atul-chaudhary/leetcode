package com.atul.contest;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int min  = 1;
        int max = 1;
        int[] arr = {1,1,1,1};
        System.out.println(countSubarrays(arr, min, max));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        boolean mimfalg = false;
        boolean maxFlag = false;
        int cur_min = Integer.MAX_VALUE;
        int cur_max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= maxK && nums[i] >= minK){
                cur_max = Math.max(cur_max, nums[i]);
                cur_min = Math.min(cur_min, nums[i]);
                if(cur_min == minK && cur_max == maxK){
                    count++;
                }
                if(nums[i] == minK && nums[i]==maxK) count++;
            }else{
                cur_min = Integer.MAX_VALUE;
                cur_max = Integer.MIN_VALUE;
            }
        }
        return count;
    }
}
