package com.atul.contest;

import java.util.*;

public class Contest29_01_2023 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,1};
        System.out.println(putMarbles(nums, 2));
    }

    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] nums = new int[n - 1];
        for (int i = 1; i < n; i++) {
            nums[i - 1] = weights[i] + weights[i - 1];
        }
        Arrays.sort(nums);
        return max(nums, k-1) - min(nums, k-1);
    }

    private static long max(int[] weights, int k) {
        int n = weights.length;
        long sum = 0;
        for (int i = n - 1; i >= n - k; i--) {
            sum += weights[i];
        }
        return sum;
    }

    private static long min(int[] weights, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += weights[i];
        }
        return sum;
    }

    public static long countQuadruplets(int[] nums) {
        List<Integer> indexs = new ArrayList<>();
        HashMap<String, Integer> dp = new HashMap<>();
        return solve(nums, 0, indexs, 0, dp);
    }

    private static int solve(int[] nums, int index, List<Integer> cur, int count, HashMap<String, Integer> dp) {
        if (count == 4) {
            if (check(cur, nums)) {
                return 1;
            }
            return 0;
        }
        if (index >= nums.length || count > 4) return 0;
        if (dp.containsKey(index + cur.toString())) return dp.get(index + cur.toString());
        cur.add(index);
        int pick = solve(nums, index + 1, cur, count + 1, dp);
        cur.remove(cur.size() - 1);
        int notPick = solve(nums, index + 1, cur, count, dp);
        int result = pick + notPick;
        dp.put(index + cur.toString(), result);
        return result;
    }

    private static boolean check(List<Integer> cur, int[] nums) {
        int i = cur.get(0);
        int j = cur.get(1);
        int k = cur.get(2);
        int l = cur.get(3);
        if (nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l]) {
            return true;
        }
        return false;
    }

    public static int distinctIntegers(int n) {
        HashSet<Integer> set = new HashSet<>();
        solve(n, set);
        return set.size() + 1;
    }

    private static void solve(int n, HashSet<Integer> set) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                set.add(i);
                solve(i, set);
            }
        }
    }
}
