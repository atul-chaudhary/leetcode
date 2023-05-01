package com.atul.contest;

import java.util.*;

public class Contest29_04_2023 {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1};
        System.out.println(countOperationsToEmptyArray(nums));
    }

    public static long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(nums[i]);
            pq.offer(nums[i]);
        }
        int count = 0;
        while (!queue.isEmpty() && !pq.isEmpty()) {
            int num = pq.peek();
            if (queue.peek() == num) {
                queue.poll();
                pq.poll();
            } else {
                queue.offer(queue.poll());
            }
            count++;
        }
        return count;
    }

    public static int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] vis = new boolean[n][m];
                    int num = solve(i, j, grid, vis);
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }

    public static int solve(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
            return 0;

        int count = grid[i][j];
        visited[i][j] = true;
        count += solve(i + 1, j, grid, visited);
        count += solve(i - 1, j, grid, visited);
        count += solve(i, j + 1, grid, visited);
        count += solve(i, j - 1, grid, visited);
        return count;
    }

    public static int findMaxFishOpt(int[][] grid) {
        int n = grid.length;
        int m = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    count++;
                }
            }
        }
        if (count == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    boolean[][] vis = new boolean[n][m];
                    int num = solveOpt(grid, vis, i, j);
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }

    private static int solveOpt(int[][] grid, boolean[][] vis, int i, int j) {
        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};
        int count = grid[i][j];
        for (int k = 0; k < 4; k++) {
            int xtemp = i + xcor[k];
            int ytemp = j + ycor[k];
            if (xtemp >= 0 && xtemp < grid.length && ytemp >= 0 && ytemp < grid[0].length && !vis[xtemp][ytemp] && grid[xtemp][ytemp] > 0) {
                count += solveOpt(grid, vis, xtemp, ytemp);
            }
        }
        return count;
    }

    public static int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int[] comm = new int[n];
        Set<Integer> lista = new HashSet<>();
        Set<Integer> listb = new HashSet<>();
        for (int i = 0; i < n; i++) {
            lista.add(a[i]);
            listb.add(b[i]);
            comm[i] = solve(lista, listb, a, b, i);
        }
        return comm;
    }

    private static int solve(Set<Integer> a, Set<Integer> b, int[] nums1, int[] nums2, int index) {
        int count = 0;
        for (int i = 0; i <= index; i++) {
            if (a.contains(nums2[i])) {
                count++;
            }
        }
        return count;
    }

    public static int maximizeSum(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }
        int sum = 0;
        while (k > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            sum += num;
            pq.offer(num + 1);
            k--;
        }
        return sum;
    }

    static class Pair {
        int x, y, val;

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private static int bfs(int[][] grid, boolean[][] vis, int i, int j) {
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(i, j, grid[i][j]));
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};
        int res = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int x = node.x;
            int y = node.y;
            int val = node.val;
            res = Math.max(res, val);
            for (int k = 0; k < 4; k++) {
                int xtemp = x + xcor[k];
                int ytemp = y + ycor[k];
                if (xtemp >= 0 && xtemp < grid.length && ytemp >= 0 && ytemp < grid[0].length && !vis[xtemp][ytemp] && grid[xtemp][ytemp] > 0) {
                    pq.offer(new Pair(xtemp, ytemp, val + grid[xtemp][ytemp]));
                }
            }
        }
        return res;
    }

}
