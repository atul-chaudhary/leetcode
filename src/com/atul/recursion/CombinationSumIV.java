package com.atul.recursion;

import java.util.ArrayList;

public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int i = 100000000;
        int j = 400000000;
        long l = (long) i*j;
        System.out.println(l);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        System.out.println(getSumCount(target, 0, nums, result, new ArrayList<>()));
        System.out.println(result);
    }

    public static int getSumCount(int target, int currentSum, int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ds) {
        if (currentSum == target) {
            res.add(new ArrayList<>(ds));
            return 1;
        }
        if (currentSum > target)
            return 0;

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            ds.add(nums[i]);
            left += getSumCount(target, currentSum + nums[i], nums, res, ds);
            ds.remove(ds.size()-1);
        }
        return left;
    }
}

