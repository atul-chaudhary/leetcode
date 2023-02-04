package com.atul.unkown;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
        int[] score = {319776, 611683, 835240, 602298, 430007, 574, 142444, 858606, 734364, 896074};
        int[] age = {4, 5, 2, 1, 1, 2, 4, 1, 4};
        System.out.println(bestTeamScore(score, age));
    }

    static class Pair {
        int age;
        int score;

        public Pair(int age, int score) {
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return age + " " + score;
        }
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Pair[] nums = new Pair[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair(ages[i], scores[i]);
        }
        Arrays.sort(nums, (a, b) -> a.age == b.age ? a.score - b.score : a.age - b.age);
        Integer[][] dp = new Integer[n][n];
        return solve(nums, -1, null, dp);
    }

    private static int solve(Pair[] nums, int index, Integer prev, Integer[][] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (prev != -1 && dp[index][prev] != null) return dp[index][prev + 1];
        int pick = 0;
        if (prev == -1 || nums[index].score >= nums[prev].score) {
            pick = nums[index].score + solve(nums, index + 1, index, dp);
        }
        int notPick = solve(nums, index + 1, prev, dp);
        int result = Math.max(pick, notPick);
        if (prev != -1) {
            dp[index][prev] = result;
        }
        return result;
    }
}
