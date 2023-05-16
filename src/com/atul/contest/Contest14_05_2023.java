package com.atul.contest;

import java.util.ArrayList;
import java.util.*;

public class Contest14_05_2023 {
    public static void main(String[] args) {
        int[][] nums = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        System.out.println(maxMoves(nums));
    }

    public static int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = Integer.MIN_VALUE;
        Integer[][] dp = new Integer[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            int temp = Math.max(ans, dfs(grid, i, 0, dp));
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    private static int dfs(int[][] grid, int i, int j, Integer[][] dp) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (dp[i][j] != null) return dp[i][j];
        int first = 0;
        if (isValid(grid, i - 1, j + 1) && grid[i - 1][j + 1] > grid[i][j]) {
            first = 1 + dfs(grid, i - 1, j + 1, dp);
        }

        int second = 0;
        if (isValid(grid, i, j + 1) && grid[i][j + 1] > grid[i][j]) {
            second = 1 + dfs(grid, i, j + 1, dp);
        }
        int third = 0;
        if (isValid(grid, i + 1, j + 1) && grid[i + 1][j + 1] > grid[i][j]) {
            third = 1 + dfs(grid, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.max(first, Math.max(second, third));
    }

    private static boolean isValid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        return true;
    }

    public boolean doesValidArrayExist(int[] derived) {
        return false;
    }

    public static int[] circularGameLosers(int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        int cur = 1;
        int num = 1;
        while (true) {
            int cal = cur * k;
            num = (num + cal);
            if (num > n) {
                num %= n;
            }
            cur++;
            System.out.println(num + "<<>>");
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) >= 2) {
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                result.add(i);
            }
        }
        int size = result.size();
        int[] finalResult = new int[size];
        for (int i = 0; i < size; i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}
