package com.atul.contest;

import java.util.*;


public class Contest15_01_2023 {
    public static void main(String[] args) {
        int[] prices = {9,8,7,6,10,5};
        int[][] edges = {{0,1},{1,2},{1,3},{3,4},{3,5}};
        System.out.println(maxOutput(6, edges, prices));
    }

    public static long maxOutput(int n, int[][] edges, int[] price) {
        Map<String, Long> map = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            String str1 = u+"|"+v;
            String str2 = v+"|"+u;
            map.put(str1, 0L);
            map.put(str2, 0L);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long cur = dfs(adj, map, price, i, -1);
            ans = Math.max(ans, cur - price[i]);
        }
        return ans;
    }

    private static long dfs(List<List<Integer>> adj, Map<String, Long> map, int[] price, int node, int parent) {
        long max = 0;
        for (int it : adj.get(node)) {
            if (it != parent) {
                String str = node + "|" + it;
                long temp = map.get(str);
                if (temp == 0) {
                    temp = dfs(adj, map, price,it, node);
                    map.put(str, temp);
                }
                max = Math.max(max, temp);
            }
        }
        return max + price[node];
    }

    public static long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Long> map = new HashMap<>();
        int left = 0;
        int right = 0;
        long cur = 0;
        long ans = 0;
        while (right < n) {
            if (map.containsKey(nums[right])) {
                cur -= calc(map.get(nums[right]));
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0L) + 1);
            cur += calc(map.get(nums[right]));

            while (left < right && cur >= k) {
                ans += n - right;
                cur -= calc(map.get(nums[left]));
                map.put(nums[left], map.get(nums[left]) - 1);
                cur += calc(map.get(nums[left]));
                left++;
            }
            right++;
        }
        return ans;
    }

    private static long calc(long num) {
        long ans = num * (num - 1);
        ans /= 2;
        return ans;
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int m = queries.length;
        int[][] arr = new int[n][n];
        for (int i = 0; i < m; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            mat(arr, r1, c1, r2, c2);
        }
        return arr;
    }

    private static void mat(int[][] grid, int r1, int c1, int r2, int c2) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                grid[i][j]++;
            }
        }
    }

    public static int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digit = 0;
        for (int it : nums) {
            elementSum += it;
            digit += solve(it);
        }
        return Math.abs(elementSum - digit);
    }

    private static int solve(int it) {
        int sum = 0;
        String s = String.valueOf(it);
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            sum += num;
        }
        return sum;
    }
}
