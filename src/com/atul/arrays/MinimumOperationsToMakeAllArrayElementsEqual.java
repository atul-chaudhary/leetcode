package com.atul.arrays;

import java.util.*;

public class MinimumOperationsToMakeAllArrayElementsEqual {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6};
        System.out.println(beautifulSubsets(nums, 2));
        System.out.println(((-7%5)+5)%5);
        //System.out.println(minOperations(nums, que));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        return solve(nums, k, 0, list);
    }

    private static int solve(int[] nums, int k, int index, List<Integer> list) {
        if (index >= nums.length) {
            if (list.size() > 0) {
                return 1;
            }
            return 0;
        }
        int pick = 0;
        if (!list.contains(nums[index] - k)) {
            list.add(nums[index]);
            pick = solve(nums, k, index + 1, list);
            list.remove(list.size() - 1);
        }
        int notPick = solve(nums, k, index + 1, list);
        return pick + notPick;
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        long[] pref = new long[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] += pref[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(pref));
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int find = queries[i];
            int index = solve(nums, find);
            long cur = ((long) find * (index + 1)) - (index >= 0 ? pref[index] : 0);
            cur += (pref[n - 1] - (index >= 0 ? pref[index] : 0)) - ((long) find * (n - index - 1));
            result.add(cur);
        }
        return result;
    }

    private static int solve(int[] nums, int find) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
