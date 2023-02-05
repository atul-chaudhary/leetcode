package com.atul.contest;


import java.util.*;

public class Contest05_02_2023 {
    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        System.out.println(minCapability(nums, 2));
    }

    public static int minCapability(int[] nums, int k) {
        return solve(nums, 0, false, k, Integer.MIN_VALUE);
    }

    private static int solve(int[] nums, int index, boolean prev, int k, int max) {
        if (index >= nums.length || k < 0) {
            return max;
        }
        int pick = 0;
        if (prev == false) {
            pick = solve(nums, index + 1, true, k - 1, Math.max(max, nums[index]));
        }
        int notPick = solve(nums, index + 1, false, k, max);
        return Math.min(pick, notPick);
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        boolean[] ans = new boolean[n];
        int[] dp = new int[n];
        if (check(words[0])) {
            ans[0] = true;
        }
        dp[0] = ans[0] ? 1 : 0;
        for (int i = 1; i < n; i++) {
            String str = words[i];
            if (check(str)) {
                ans[i] = true;
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int count = dp[v] - dp[u];
            if (ans[u]) count++;
            result[i] = count;
        }
        return result;
    }

    private static boolean check(String str) {
        int n = str.length();
        char first = str.charAt(0);
        char last = str.charAt(n - 1);
        return isVovwel(first) && isVovwel(last);
    }

    private static boolean isVovwel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public static long pickGifts(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            int floor = (int) Math.floor(Math.sqrt(num));
            pq.offer(floor);
        }
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

}
