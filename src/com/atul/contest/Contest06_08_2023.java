package com.atul.contest;

import java.util.*;

public class Contest06_08_2023 {


    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}};

        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int it : nums[i]) {
                list.get(i).add(it);
            }
        }

        System.out.println(maximumSafenessFactor(list));
    }


    static class Pair {
        int i;
        int j;
        int dis;

        public Pair(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] arr = new int[n][m];
        for (int[] it : arr) {
            Arrays.fill(it, Integer.MAX_VALUE);
        }

        Queue<Pair> pq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    pq.offer(new Pair(i, j, 0));
                    arr[i][j] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            Pair pa = pq.poll();
            int i = pa.i;
            int j = pa.j;
            int dis = pa.dis;
            int[] xcor = {1, -1, 0, 0};
            int[] ycor = {0, 0, -1, 1};

            for (int k = 0; k < 4; k++) {
                int x = xcor[k] + i;
                int y = ycor[k] + j;
                if (check(arr, x, y) && 1 + dis < arr[x][y]) {
                    pq.offer(new Pair(x, y, 1 + dis));
                    arr[x][y] = 1 + dis;
                    max = Math.max(max, arr[x][y]);
                }
            }
        }

        //System.out.println(Arrays.deepToString(arr));
        for (int[] it : arr) {
            System.out.println(Arrays.toString(it));
        }
        //System.out.println(max + "max");
        int first = 0;
        int last = max;
        int result = 0;
        while (first <= last) {
            int mid = (first + last) / 2;
            int res = possible(arr, mid);
            if (res == mid) {
                result = mid;
                first = mid + 1;
            } else if (res < mid) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return result;
    }

    private static int possible(int[][] arr, int cur) {
        int n = arr.length;
        int m = arr[0].length;

        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};

        int finalresult = Integer.MAX_VALUE;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0, 0, arr[0][0]));
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int i = pair.i;
            int j = pair.j;
            int min = pair.dis;
            if (i == n - 1 && j == m - 1) {
                finalresult = Math.min(finalresult, min);
            }
            for (int k = 0; k < 4; k++) {
                int x = xcor[k] + i;
                int y = ycor[k] + j;
                if (isValidYo(arr, x, y, vis) && arr[x][y] >= cur) {
                    pq.offer(new Pair(x, y, Math.min(min, arr[x][y])));
                    vis[x][y] = true;
                }
            }
        }
        System.out.println(finalresult + "<<>>");
        return finalresult;
    }

    private static boolean isValidYo(int[][] grid, int i, int j, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j]) {
            return false;
        }
        return true;
    }

    private static boolean check(int[][] arr, int i, int j) {
        int n = arr.length;
        int m = arr[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    private static int solve(List<List<Integer>> grid, int i, int j, boolean[][] vis, List<Pair> check, int cur) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).size() || vis[i][j]) return Integer.MAX_VALUE;
        if (i == grid.size() - 1 && j == grid.get(0).size() - 1) {
            return cur;
        }
        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < 4; k++) {
            int x = xcor[k] + i;
            int y = ycor[k] + j;
            if (isValid(grid, x, y, vis)) {
                int min = check(check, x, y);
                int temp = solve(grid, x, y, vis, check, Math.min(cur, min));
                max = Math.max(temp, max);
            }
        }

        vis[i][j] = false;
        return max;
    }

    private static int check(List<Pair> check, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (Pair pair : check) {
            int x = Math.abs(pair.i - i);
            int y = Math.abs(pair.j - j);
            min = Math.min(min, x + y);
        }
        return min;
    }

    private static boolean isValid(List<List<Integer>> grid, int i, int j, boolean[][] vis) {
        int n = grid.size();
        int m = grid.get(0).size();
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j]) {
            return false;
        }
        return true;
    }
}
