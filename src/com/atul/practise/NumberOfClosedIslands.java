package com.atul.practise;

import java.util.*;

public class NumberOfClosedIslands {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.add(two);
        one.neighbors.add(four);
        two.neighbors.add(three);
        two.neighbors.add(one);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(one);
        four.neighbors.add(three);

        System.out.println(cloneGraph(one));
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }

    public static Node cloneGraph(Node node) {
        Node head = new Node(node.val);
        Queue<Node> pq = new LinkedList<>();
        pq.offer(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, head);
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            for (Node it : temp.neighbors) {
                if (!map.containsKey(it)) {
                    Node newNode = new Node(it.val);
                    map.put(it, newNode);
                    pq.offer(it);
                }

                map.get(temp).neighbors.add(map.get(it));
            }
        }
        return null;
    }

    static long binaryToBase10(String binaryString) {
        long val = 0;
        for (char c : binaryString.toCharArray()) {
            val <<= 1;
            val += c - '0';
        }
        return val;
    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int finalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int[] count = new int[1];
                    if (solveEnclave(grid, i, j, vis, count)) {
                        finalCount += count[0];
                    }
                }
            }
        }
        return finalCount;
    }

    private static boolean solveEnclave(int[][] grid, int i, int j, boolean[][] vis, int[] count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;

        if (grid[i][j] == 0) return true;
        if (vis[i][j]) return true;

        vis[i][j] = true;
        count[0]++;
        boolean top = solveEnclave(grid, i - 1, j, vis, count);
        boolean right = solveEnclave(grid, i, j + 1, vis, count);
        boolean bottom = solveEnclave(grid, i + 1, j, vis, count);
        boolean left = solveEnclave(grid, i, j - 1, vis, count);

        if (top && right && bottom && left) return true;
        return false;
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    if (solve(grid, i, j, vis))
                        count++;
                }
            }
        }
        return count;
    }

    private static boolean solve(int[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        if (grid[i][j] == 1) return true;
        if (vis[i][j]) return true;
        vis[i][j] = true;
        boolean top = solve(grid, i - 1, j, vis);
        boolean left = solve(grid, i, j + 1, vis);
        boolean bottom = solve(grid, i + 1, j, vis);
        boolean right = solve(grid, i, j - 1, vis);

        if (top && left && bottom && right) return true;
        return false;
    }
}
