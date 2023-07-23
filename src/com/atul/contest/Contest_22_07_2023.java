package com.atul.contest;

import java.util.*;

public class Contest_22_07_2023 {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(isGood(nums));
    }

    public static boolean isGood(int[] nums) {
        int n = nums.length;
        int num = n - 1;
        Arrays.sort(nums);
        if (nums[n - 1] != num || nums[n - 2] != num) return false;
        for (int i = 1; i < num; i++) {
            if (nums[i - 1] != i) {
                return false;
            }
        }
        return true;
    }

    public static String sortVowels(String s) {
        int n = s.length();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                map.put((int) ch, map.getOrDefault((int) ch, 0) + 1);
            }
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                int it = map.firstKey();
                map.put(it, map.get(it) - 1);
                if (map.get(it) == 0) {
                    map.remove(it);
                }
                result += (char) it;
            } else {
                result += ch;
            }
        }
        return result;
    }

    private static boolean isVowel(char ch) {
        String l = String.valueOf(ch).toLowerCase();
        char cha = l.charAt(0);
        if (cha == 'a' || cha == 'e' || cha == 'i' || cha == 'o' || cha == 'u') {
            return true;
        }

        return false;
    }

    static int mod = (int) 1e9 + 7;

    private static int solve(int num, int n, int x) {


        int times = 0;
        for (int i = num; i <= n; i++) {
            int pow = (int) Math.pow(i, x);
            if (num + pow <= n) {
                times += 1 + solve(i, n, x);
            }
        }
        return times;
    }

    public static long maxScore(int[] nums, int x) {
        int n = nums.length;
        Long[][] dp = new Long[n + 1][2];
        long result = solve(nums, 1, x, nums[0] % 2, dp);
        return result + nums[0];
    }

    private static long solve(int[] nums, int index, int x, int prev, Long[][] dp) {
        if (index >= nums.length) return 0;
        if (dp[index][prev] != null) return dp[index][prev];
        long first = 0;
        long sec = 0;
        if ((prev == 0 && nums[index] % 2 == 0) || (prev == 1 && nums[index] % 2 == 1)) {
            first = nums[index] + solve(nums, index + 1, x, nums[index] % 2, dp);
        } else {
            sec = (nums[index] + solve(nums, index + 1, x, nums[index] % 2, dp)) - x;
        }
        long notPick = solve(nums, index + 1, x, prev, dp);
        return dp[index][prev] = Math.max(first, Math.max(sec, notPick));
    }

}
