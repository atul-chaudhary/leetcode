package com.atul.contest;

import java.util.HashSet;

public class CountNumberDistinctIntegersAfterReverseOperations {
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        System.out.println(countDistinctIntegers(nums));
    }

    public static int countDistinctIntegers(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int it : nums){
            set.add(it);
            StringBuilder sb = new StringBuilder(String.valueOf(it));
            sb.reverse();
            set.add(Integer.parseInt(sb.toString()));
        }

        return set.size();
    }
}
