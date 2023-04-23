package com.atul.dynamic_programming;

public class ProfitableSchemes {

    public static void main(String[] args) {
        String a = "mbadm";
        System.out.println(minInsertions(a));
    }

    public static int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        Integer[][] dp = new Integer[n + 1][n + 1];
        int len = lcs(s, rev, 0, 0, dp);
        return n - len;
    }

    private static int lcs(String a, String b, int i, int j, Integer[][] dp) {
        if (i >= a.length() || j >= b.length()) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + lcs(a, b, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(lcs(a, b, i + 1, j, dp), lcs(a, b, i, j + 1, dp));
        }
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = profit.length;
        Integer[][][] dp = new Integer[102][102][102];
        return solve(profit, group, 0, minProfit, n, 0, 0, dp);
    }

    static int mod = (int) 1e9 + 7;

    private static int solve(int[] profit, int[] group, int index, int minProfit, int n, int cur, int total, Integer[][][] dp) {
        if (index >= profit.length) {
            if (cur >= minProfit && total <= n) {
                return 1;
            }
            return 0;
        }
        if (n < total) return 0;
        if (dp[index][cur][total] != null) return dp[index][cur][total];
        int pick = solve(profit, group, index + 1, minProfit, n, Math.min(cur + profit[index], minProfit), total + group[index], dp) % mod;
        int notPick = solve(profit, group, index + 1, minProfit, n, cur, total, dp) % mod;
        return dp[index][cur][total] = (pick + notPick) % mod;
    }
}
