package com.atul.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {

    }



    static int lcs(String s1, String s2, int i, int j, int count, Integer[][][] dp) {
        if (i == 0 || j == 0) {
            return count;
        }
        if(dp[i][j][count] != null) return dp[i][j][count];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            count = lcs(s1, s2, i - 1, j - 1, count + 1, dp);
        }
        count = Math.max(count, Math.max(lcs(s1, s2, i, j - 1, 0, dp), lcs(s1, s2, i - 1, j, 0, dp)));
        return dp[i][j][count] = count;
    }

    private static int[] max = new int[1];

    private static int solveLCSUB(String s1, String s2, int i, int j, int curMax, Integer[][][] dp) {
        if (i < 0 || j < 0) return curMax;
        if (dp[i][j][curMax] != null) return dp[i][j][curMax];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j][curMax] = solveLCSUB(s1, s2, i - 1, j - 1, curMax + 1, dp);
            max[0] = Math.max(max[0], dp[i][j][curMax]);
            return dp[i][j][curMax];
        } else {
            return dp[i][j][curMax] = Math.max(solveLCSUB(s1, s2, i, j - 1, 0, dp), solveLCSUB(s1, s2, i - 1, j, 0, dp));
        }
    }

    //lcs dp
    private static int solveTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    //lcs
    private static int solve(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s1, s2, i, j - 1, dp), solve(s1, s2, i - 1, j, dp));
        }
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            prev += nums[i];
            int temp = Math.max(prev, nums[i]);
            if (temp > max) {
                max = temp;
                prev = temp;
            }
        }
        return max;
    }

    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        Map<String, Integer> dp = new HashMap<>();
        return solve(s, 0, '0', dp);
    }

    private static int solve(String s, int index, char prev, Map<String, Integer> dp) {
        if (index >= s.length()) return 0;

        if (dp.containsKey(index + "|" + prev)) return dp.get(index + "|" + prev);
        int flip = Integer.MAX_VALUE;
        int noFlip = Integer.MAX_VALUE;
        if (s.charAt(index) == '0') {
            if (prev == '0') {
                flip = 1 + solve(s, index + 1, '1', dp);
                noFlip = solve(s, index + 1, '0', dp);
            } else {
                flip = 1 + solve(s, index + 1, '1', dp);
            }
        } else {
            if (s.charAt(index) == '1') {
                if (prev == '0') {
                    flip = 1 + solve(s, index + 1, '0', dp);
                    noFlip = solve(s, index + 1, '1', dp);
                } else {
                    noFlip = solve(s, index + 1, '1', dp);
                }
            }
        }
        int ans = Math.min(flip, noFlip);
        dp.put(index + "|" + prev, ans);
        return ans;
    }
}
