package com.atul.contest;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Contest20_08_2023 {
    public static void main(String[] args) {

    }

    public static boolean isDateValid(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            return false;
        }
        return true;
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int first = 0;
        int second = 0;
        while (first < n && second < m) {
            char ch1 = str1.charAt(first);
            char ch2 = str2.charAt(second);
            if (ch1 == ch2) {
                first++;
                second++;
            } else {
                int num1 = ch1 - 'a';
                int num2 = ch2 - 'a';
                first++;
                if ((num1 + 1) % 26 == num2) {
                    second++;
                }
            }
        }
        return second == m;
    }


    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j) continue;

                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        int num = 1;
        List<Integer> list = new ArrayList<>();
        while (cur < n) {
            if (!set.contains(num)) {
                list.add(num);
                set.add(k - num);
                num++;
                cur++;
            } else {
                num++;
            }
        }
        int sum = 0;
        for (int it : list) {
            sum += it;
        }
        return sum;
    }

    public boolean isAcronym(List<String> words, String s) {
        String str = "";
        for (String it : words) {
            str += it.charAt(0);
        }

        return s.equals(str);
    }

    static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static int maximizeTheProfitYO(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (List<Integer> o1, List<Integer> o2) -> {
            return Integer.compare(o1.get(0), o2.get(0));
        });
        System.out.println(offers);
        return recur(0, offers);
    }

    private static int recur(int i, List<List<Integer>> offers) {
        if (i == offers.size()) return 0;
        if (cache.containsKey(i)) return cache.get(i);
        int index = search(offers, offers.get(i).get(1));
        int res = recur(index, offers) + offers.get(i).get(2);
        res = Math.max(res, recur(i + 1, offers));
        cache.put(i, res);
        return res;
    }

    private static int search(List<List<Integer>> offers, int target) {
        int start = 0;
        int end = offers.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (offers.get(mid).get(0) <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }


    public static int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> a.get(0) == b.get(0) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        //Map<String, Integer> dp = new HashMap<>();
        int len = offers.size();
        Integer[][] dp = new Integer[len + 1][len + 2];
        return solve(offers, 0, -1, dp);
    }

    private static int solve(List<List<Integer>> nums, int index, int prev, Integer[][] dp) {
        if (index >= nums.size()) {
            return 0;
        }
        if (dp[index][prev + 1] != null) return dp[index][prev + 1];

        int pick = Integer.MIN_VALUE;
        if (prev == -1 || nums.get(prev).get(1) < nums.get(index).get(0)) {
            pick = nums.get(index).get(2) + solve(nums, index + 1, index, dp);
        }
        int notPick = solve(nums, index + 1, prev, dp);
        return dp[index][prev + 1] = Math.max(pick, notPick);
    }

}
