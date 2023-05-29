package com.atul.graph;

import java.util.*;


public class ShortestBridge {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int it : nums){
            map.put(it, map.getOrDefault(it, 0)+1);
        }
        int num = n/2;
        System.out.println(map);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(val > num){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int solution(int[] blocks) {
        // Implement your solution here
        //[1,5,5,2,6]
        //create two array
        //1. first array  will store how far to right we can
        //[3,2, 2, 1]

        //actual - copy - [1,5,5,2,6] using stack approach
        //[2,2,2,4,4]
        //1. seocod array  will store how far to right we can
        //[0,1,1,1,4]

        //(n) + (n) +(n) = (3n)


        int n = blocks.length;
        Stack<Integer> right = new Stack<>();
        int[] rightIndex = new int[n];
        //[3,2, 2, 1]
        for (int i = 0; i < n; i++) {
            right.push(i);
            int index = i + 1;
            while (index < n && blocks[right.peek()] <= blocks[index]) {
                right.push(index);
                index++;
            }
            rightIndex[i] = right.peek();
        }
        System.out.println(Arrays.toString(rightIndex));
        Stack<Integer> left = new Stack<>();
        int[] leftIndex = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            left.push(i);
            int index = i - 1;
            while (index >= 0 && blocks[left.peek()] <= blocks[index]) {
                left.push(index);
                index--;
            }
            leftIndex[i] = left.peek();
        }
        System.out.println(Arrays.toString(leftIndex));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tempCal = rightIndex[i] - leftIndex[i] + 1;
            max = Math.max(max, tempCal);
        }
        return max;
    }

    public static int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j] && count == 1) {
                    solve(grid, i, j, vis);
                    count++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    //bfs try
                    int temp = bfs(grid, vis, new boolean[n][n], i, j);
                    min = Math.min(min, temp);
                }
            }
        }
        return min - 1;
    }

    static class Pair {
        int i;
        int j;
        int val;

        public Pair(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    private static int bfs(int[][] grid, boolean[][] vis, boolean[][] newVis, int i, int j) {
        int n = grid.length;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(i, j, 0));
        newVis[i][j] = true;
        int min = Integer.MAX_VALUE;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        while (!pq.isEmpty()) {
            int size = pq.size();
            System.out.println(pq + "<<>>");
            for (int k = 0; k < size; k++) {
                Pair pair = pq.poll();
                int x = pair.i;
                int y = pair.j;
                int cur = pair.val;
                if (grid[x][y] == 1 && !vis[x][y]) {
                    //min = Math.min(min, cur);
                    return cur;
                }
                for (int l = 0; l < 4; l++) {
                    int xtemp = x + xcor[l];
                    int ytemp = y + ycor[l];
                    if (xtemp >= 0 && xtemp < n && ytemp >= 0 && ytemp < n && newVis[xtemp][ytemp] == false) {
                        newVis[xtemp][ytemp] = true;
                        pq.offer(new Pair(xtemp, ytemp, cur + 1));
                    }
                }
            }
        }
        return min;
    }

    private static void solve(int[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int xtemp = i + xcor[k];
            int ytemp = j + ycor[k];
            if (isValid(grid, xtemp, ytemp, vis)) {
                solve(grid, xtemp, ytemp, vis);
            }
        }
    }

    private static boolean isValid(int[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || vis[i][j]) {
            return false;
        }
        return true;
    }
}
