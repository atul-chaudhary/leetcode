package com.atul.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonDecreasingSubsequences {

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();
        solve(nums, 0, cur, result);
        return new ArrayList<>(result);
    }

    private static void solve(int[] nums, int index, List<Integer> cur, HashSet<List<Integer>> result) {
        if (index >= nums.length) {
            if (isValid(cur)) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        cur.add(nums[index]);
        solve(nums, index + 1, cur, result);
        cur.remove(cur.size() - 1);
        solve(nums, index + 1, cur, result);
    }

    private static boolean isValid(List<Integer> cur) {
        int n = cur.size();
        if(n < 2) return false;
        for (int i = 1; i < n; i++) {
            if (cur.get(i) < cur.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
