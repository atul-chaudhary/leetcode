package com.atul.contest;

import java.util.ArrayList;

public class NumberZeroFilledSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(arr));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long count = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                temp.add(nums[j]);
            }
            list.add(new ArrayList<>(temp));
            //if(isOnlyZeros) count++;
        }
        System.out.println(list);
        return count;
    }
}
