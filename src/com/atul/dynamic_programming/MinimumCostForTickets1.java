package com.atul.dynamic_programming;

public class MinimumCostForTickets1 {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] cost = {2, 7, 15};
        System.out.println(mincostTickets(days, cost));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer[][] dp = new Integer[n + 1][365 + 31];
        return solve(days, 0, costs, 0, dp);
    }

    private static int solve(int[] days, int index, int[] cost, int prev, Integer[][] dp) {
        if (index >= days.length) {
            return 0;
        }

        if (dp[index][prev] != null) return dp[index][prev];

        if (days[index] <= prev) {
            return dp[index][prev] = solve(days, index + 1, cost, prev, dp);
        } else {
            return dp[index][prev] = Math.min(cost[0] + solve(days, index + 1, cost, days[index], dp),
                    Math.min(cost[1] + solve(days, index + 1, cost, days[index] + 6, dp),
                            cost[2] + solve(days, index + 1, cost, days[index] + 29, dp)));
        }
    }
}
