package com.atul.leetcodedaily;

import java.util.*;

class Solution {
    //set to store all the leaves
    Set<TreeNode> leaves = new HashSet<>();

    //map to store the backedge from a node to its parent
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public int countPairs(TreeNode root, int distance) {
        //fill the leaves
        fillLeaves(root);
        //set up the backedges to run BFS later
        fillMap(root, null);
        System.out.println(leaves);
        System.out.println(map);
        int ans = 0;
        for (TreeNode leaf : leaves) {
            ans += bfs(leaf, distance);
        }
        //to make the count right, we count each pair twice
        return ans / 2;
    }

    //fill the leaves set to use later
    void fillLeaves(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            leaves.add(root);
        fillLeaves(root.left);
        fillLeaves(root.right);
    }

    //add backedges
    void fillMap(TreeNode root, TreeNode parent) {
        if (root == null) return;
        map.put(root, parent);
        fillMap(root.left, root);
        fillMap(root.right, root);
    }

    //run BFS from the leaf node
    //take steps till we are within the given distance
    //add all the leaves that we come across in the process
    int bfs(TreeNode root, int distance) {
        System.out.println("<<>>" + root);
        if (root == null)
            return 0;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();
        q.offer(root);
        int d = 0, ans = 0;

        while (!q.isEmpty()) {
            if (d > distance) break;
            int s = q.size();
            while (s > 0) {
                TreeNode node = q.poll();
                TreeNode parent = map.get(node);
                TreeNode left = node.left;
                TreeNode right = node.right;
                seen.add(node);
                if (leaves.contains(node) && d > 0) {
                    ans += 1;
                    System.out.println(node + "><>");
                }

                if (parent != null && !seen.contains(parent)) {
                    q.offer(parent);
                }
                if (left != null && !seen.contains(left)) q.offer(left);
                if (right != null && !seen.contains(right)) q.offer(right);
                s--;
            }

            d++;

        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val + '}';
    }
}

public class Practise {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};//{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int dist = 4;
        System.out.println(findTheCity(4, edges, dist));
    }

    static class Pair4 {
        int vert;
        int wt;

        public Pair4(int vert, int wt) {
            this.vert = vert;
            this.wt = wt;
        }
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair4>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] it : edges) {
            int first = it[0];
            int sec = it[1];
            int wt = it[2];

            graph.get(first).add(new Pair4(sec, wt));
            graph.get(sec).add(new Pair4(first, wt));
        }
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int res = dij(graph, i, distanceThreshold, n);
            System.out.println("<<>>" + res);
            if (res <= min) {
                result = Math.max(result, i);
                min = res;
            }
        }
        return result;
    }

    private static int dij(List<List<Pair4>> list, int source, int thre, int n) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Pair4> pq = new LinkedList<>();
        pq.offer(new Pair4(source, 0));
        dis[source] = 0;
        Set<Integer> result = new HashSet<>();
        while (!pq.isEmpty()) {
            Pair4 p = pq.poll();
            if (p.wt > thre) continue;
            for (Pair4 it : list.get(p.vert)) {
                int ver = it.vert;
                int wt = it.wt;
                if (p.wt + wt < dis[ver] && p.wt + wt <= thre) {
                    pq.offer(new Pair4(ver, p.wt + wt));
                    dis[ver] = p.wt + wt;
                    result.add(ver);
                }
            }
        }
        return result.size();
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] seen = new boolean[n][m];
        solve(image, sr, sc, color, seen, image[sr][sc]);
        return image;
    }

    static int[] xdir = {1, -1, 0, 0};
    static int[] ydir = {0, 0, -1, 1};

    private static void solve(int[][] grid, int i, int j, int color, boolean[][] seen, int prevColor) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] || grid[i][j] != prevColor) {
            return;
        }

        seen[i][j] = true;
        grid[i][j] = color;
        for (int k = 0; k < 4; k++) {
            int newI = xdir[k] + i;
            int newJ = ydir[k] + j;
            solve(grid, newI, newJ, color, seen, prevColor);
        }
    }

    static class Pair3 {
        int x;
        int y;
        int val;

        public Pair3(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair3(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair3{" +
                    "x=" + x +
                    ", y=" + y +
                    ", val=" + val +
                    '}';
        }
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair3> pq = new LinkedList<>();
        boolean[][] seen = new boolean[n][m];
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    pq.offer(new Pair3(i, j, 0));
                    seen[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int[] xdir = {1, -1, 0, 0};
        int[] ydir = {0, 0, 1, -1};
        int result = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair3 temp = pq.poll();
                System.out.println(temp);
                int dis = temp.val;
                result = Math.max(result, dis);
                for (int j = 0; j < 4; j++) {
                    int oldx = temp.x;
                    int oldy = temp.y;
                    int newX = xdir[j] + oldx;
                    int newY = ydir[j] + oldy;

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && seen[newX][newY] == false && grid[newX][newY] != 0) {
                        pq.offer(new Pair3(newX, newY, dis + 1));
                        seen[newX][newY] = true;
                        grid[newX][newY] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return result;
    }

    static class Pair2 {
        int realVal;
        int formedVal;
        int index;

        public Pair2(int realVal, int formedVal, int index) {
            this.realVal = realVal;
            this.formedVal = formedVal;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair2{" +
                    "realVal=" + realVal +
                    ", formedVal=" + formedVal +
                    ", index=" + index +
                    '}';
        }
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int m = mapping.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(i, mapping[i]);
        }
        System.out.println(map);
        List<Pair2> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            int it = nums[j];
            String num = new String(String.valueOf(it));
            String res = "";
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                res += map.get(Integer.parseInt(String.valueOf(ch)));
            }
            result.add(new Pair2(it, Integer.parseInt(res), j));
        }
        Collections.sort(result, (a, b) -> a.formedVal == b.formedVal ? a.index - b.index : a.formedVal - b.formedVal);
        for (int i = 0; i < n; i++) {
            nums[i] = result.get(i).realVal;
        }
        System.out.println(result);
        return nums;
    }

    public static int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        //frequency, nums
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int fre = entry.getValue();
            map.putIfAbsent(fre, new TreeSet<>(Comparator.reverseOrder()));
            map.get(fre).add(num);
        }
        int index = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
            int fre = entry.getKey();
            TreeSet<Integer> set = entry.getValue();
            for (int it : set) {
                for (int i = 0; i < fre; i++) {
                    nums[index++] = it;
                }
            }
        }
        return nums;
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            set.add(min);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            if (set.contains(max)) {
                result.add(max);
            }
        }
        return result;
    }


    private static void trav(TreeNode root, Map<TreeNode, TreeNode> map, TreeNode parent, Set<TreeNode> leaves) {
        if (root == null) {
            return;
        }
        map.put(root, parent);
        if (root.left == null && root.right == null) {
            leaves.add(root);
        }
        trav(root.left, map, root, leaves);
        trav(root.right, map, root, leaves);
    }


    public static int countPairs(TreeNode root, int distance) {
        Set<TreeNode> list = new HashSet<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        trav(root, parent, null, list);
        System.out.println(parent);
        int[] result = new int[1];
        //BFS
        for (TreeNode it : list) {
            //System.out.println(it.val + "<<>>");
            solve(it, parent, result, distance, list);
        }
        return result[0] / 2;
    }


    static class Pair {
        TreeNode node;
        int dist;

        public Pair(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public Pair(int it, int dist, int j) {
        }
    }

    private static void solve(TreeNode root, Map<TreeNode, TreeNode> parent, int[] result, int distance, Set<TreeNode> leaves) {
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(root, 0));
        Set<TreeNode> set = new HashSet<>();
        set.add(root);

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            TreeNode temp = pair.node;
            int dist = pair.dist;

            if (leaves.contains(temp) && dist > 0 && dist <= distance) {
                result[0]++;
            }
            if (parent.containsKey(temp) && parent.get(temp) != null && !set.contains(parent.get(temp))) {
                pq.offer(new Pair(parent.get(temp), dist + 1));
                set.add(parent.get(temp));
            }
            if (temp.left != null && !set.contains(temp.left)) {
                pq.offer(new Pair(temp.left, dist + 1));
                set.add(temp.left);
            }
            if (temp.right != null && !set.contains(temp.right)) {
                pq.offer(new Pair(temp.right, dist + 1));
                set.add(temp.right);
            }
        }
    }
}
