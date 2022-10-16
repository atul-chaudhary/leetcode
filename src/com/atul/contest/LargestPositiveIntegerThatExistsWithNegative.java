package com.atul.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class LargestPositiveIntegerThatExistsWithNegative {
    public static void main(String[] args) {
        int[] arr = {-10,8,6,7,-2,-3};
        System.out.println(findMaxK(arr));
    }


    public static int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int it : nums) {
            if (it < 0 && set.contains(Math.abs(it))) {
                max = Math.max(max, Math.abs(it));
            } else if (it > 0 && set.contains(-it)){
                max = Math.max(max, it);
            }
            set.add(it);
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
