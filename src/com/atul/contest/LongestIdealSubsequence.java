package com.atul.contest;

import java.util.Arrays;
import java.util.Map;

public class LongestIdealSubsequence {
    public static void main(String[] args) {
        String s = "lopjigzbaq";
        int k = 5;
        System.out.println(longestIdealString(s, k));
    }

    public static int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length()+1][27];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = solveMemo(s, 0, 26, k, dp);
        //int result  = dfs(s, 0, k, 26, dp);
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return result;
    }

    private static int solveMemo(String s, int index, int prev, int k, int[][] dp) {
        if (index >= s.length()) {
            return 0;
        }

        if (dp[index][prev] != -1) return dp[index][prev];


        int left = 0;
        int cur = s.charAt(index) - 'a';
        if (prev == 26 || Math.abs(prev -cur) <= k) {
            left = 1 + solveMemo(s, index + 1, cur, k, dp);
        }

        int right = solveMemo(s, index + 1, prev, k, dp);

        return dp[index][prev] = Math.max(left, right);
    }

    public static int dfs(String s, int currentPosition, int k, int previousChar, int[][] dp) {
        if (currentPosition >= s.length()) {
            return 0;
        }
        if (dp[currentPosition][previousChar] != -1) {
            return dp[currentPosition][previousChar];
        }
        int result = dfs(s, currentPosition + 1, k, previousChar, dp);

        int currentChar = s.charAt(currentPosition) - 'a';
        if (previousChar == 26 || Math.abs(currentChar - previousChar) <= k) {
            result = Math.max(result, 1 + dfs(s, currentPosition + 1, k, currentChar, dp));
        }
        dp[currentPosition][previousChar] = result;
        return result;
    }

    private static int solve(String s, int index, char prev, int k) {
        if (index >= s.length()) {
            return 0;
        }

        int left = 0;
        if (prev == ' ' || Math.abs(prev - s.charAt(index)) <= k) {
            left = 1 + solve(s, index + 1, s.charAt(index), k);
        }

        int right = solve(s, index + 1, prev, k);

        return Math.max(left, right);
    }
}
