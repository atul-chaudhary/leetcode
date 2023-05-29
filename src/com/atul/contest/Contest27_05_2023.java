package com.atul.contest;

import java.util.*;

public class Contest27_05_2023 {
    public static void main(String[] args) {
        String cur = "leetscode";
        String[] dict = {"leet", "code", "leetcode"};
        System.out.println(minExtraChar(cur, dict));

        //int[] nums = {0, -7};
        //System.out.println(maxStrength(nums));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        Map<String, Integer> dp = new HashMap<>();
        int ans = solve(s, 0, set, dp);
        return ans;
    }

    private static int solve(String cur, int index, Set<String> set, Map<String, Integer> dp) {
        if (index >= cur.length()) {
            return 0;
        }
        if (dp.containsKey(cur + "|" + index)) return dp.get(cur + "|" + index);

        String curStr = "";
        int ans = cur.length();
        for (int i = index; i < cur.length(); i++) {
            curStr += cur.charAt(i);

            int currExtra = set.contains(curStr) ? 0 : curStr.length();
            int nextExtra = solve(cur, i + 1, set, dp);
            int total = currExtra + nextExtra;
            ans = Math.min(ans, total);

        }

        dp.put(cur+"|"+index, ans);
        return ans;
    }

    public static long maxStrength(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) return nums[0];
        int pos = 0;
        int neg = 0;
        int zero = 0;
        for (int it : nums) {
            if (it == 0) zero++;
            else if (it > 0) pos++;
            else neg++;
        }
        if (zero == n) return 0;
        if (zero == n - 1 && neg == 1) return 0;
        Map<String, Long> dp = new HashMap<>();
        return solve(nums, 0, 1, dp);
    }

    private static long solve(int[] nums, int index, long cur, Map<String, Long> dp) {
        if (index >= nums.length) {
            return cur;
        }

        if (dp.containsKey(index + "|" + cur)) return dp.get(index + "|" + cur);
        long pick = solve(nums, index + 1, nums[index] * cur, dp);
        long notPick = solve(nums, index + 1, cur, dp);

        System.out.println(pick + "<<>??" + notPick);
        long ans = Math.max(pick, notPick);
        dp.put(index + "|" + cur, ans);
        return ans;
    }
}
