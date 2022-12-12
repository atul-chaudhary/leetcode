package com.atul.contest;

import javax.print.attribute.standard.PresentationDirection;
import java.util.*;

public class contest_10_12_2022 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}};
        int[] que = {5, 6, 2};
        System.out.println(Arrays.toString(maxPointsOpt(grid, que)));
    }

    static class Node {
        int val;
        int x;
        int y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static int[] maxPointsOpt(int[][] grid, int[] queries) {
        int len = queries.length;
        //0 is val, and 1 is index
        int[][] temp = new int[len][2];
        for (int i = 0; i < len; i++) {
            temp[i][0] = queries[i];
            temp[i][1] = i;
        }
        int[] result = new int[len];
        int n = grid.length;
        int m = grid[0].length;
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        boolean[][] vis = new boolean[n][m];
        pq.offer(new Node(grid[0][0], 0, 0));
        vis[0][0] = true;
        int[] xcor = {1,-1,0,0};
        int[] ycor = {0,0,-1,1};
        int point = 0;
        for (int i = 0; i < len; i++) {
            int max_value = temp[i][0];
            int ind = temp[i][1];
            while (!pq.isEmpty() && pq.peek().val < max_value) {
                Node node = pq.poll();
                point++;
                for (int j = 0; j < 4; j++) {
                    int xtemp = xcor[j] + node.x;
                    int ytemp = ycor[j] + node.y;
                    boolean isValid = (xtemp >=0 && xtemp < n) && (ytemp >=0 && ytemp < m);
                    if(!isValid || vis[xtemp][ytemp]) continue;
                    vis[xtemp][ytemp] = true;
                    pq.offer(new Node(grid[xtemp][ytemp], xtemp, ytemp));
                }
            }
            result[ind] = point;
        }
        return result;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] result = new int[queries.length];
        Queue<Pair> pq = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            int num = queries[i];
            pq.offer(new Pair(0, 0));
            vis[0][0] = true;
            int count = 0;
            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                int x = pair.x;
                int y = pair.y;
                if (grid[x][y] < num) {
                    count++;
                    int[] xcor = {1, -1, 0, 0};
                    int[] ycor = {0, 0, 1, -1};
                    for (int j = 0; j < 4; j++) {
                        int xtemp = xcor[j] + x;
                        int ytemp = ycor[j] + y;
                        if (xtemp >= 0 && xtemp < n && ytemp >= 0 && ytemp < m && grid[xtemp][ytemp] < num && !vis[xtemp][ytemp]) {
                            pq.offer(new Pair(xtemp, ytemp));
                            vis[xtemp][ytemp] = true;
                        }
                    }
                }

            }
            result[index++] = count;
            vis = new boolean[n][m];
        }
        return result;
    }

    class Allocator {
        int[] nums = null;
        int n = 0;

        public Allocator(int n) {
            this.n = n;
            nums = new int[n];
        }

        public int allocate(int size, int mID) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    count++;
                    if (count == size) {
                        for (int j = i; j >= i - size + 1; j--) {
                            nums[j] = mID;
                        }
                        return i - size + 1;
                    }
                } else count = 0;
            }
            return -1;
        }

        public int free(int mID) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == mID) {
                    count++;
                    nums[i] = 0;
                }
            }
            return count;
        }
    }

   /* static class PairM {
        int val;
        int wt;

        public PairM(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", wt=" + wt +
                    '}';
        }
    }

    public static int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<PriorityQueue<PairM>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new PriorityQueue<>((a, b) -> b.wt - a.wt));
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).offer(new PairM(edges[i][1], vals[edges[i][1]]));
            adj.get(edges[i][1]).offer(new PairM(edges[i][0], vals[edges[i][0]]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int size = adj.get(i).size();
            int temp = k;
            Queue<PairM> pq = adj.get(i);
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (!pq.isEmpty() && temp > 0) {
                    int num = pq.poll().wt;
                    if (num < 0) break;
                    count += num;
                    temp--;
                }
            }
            max = Math.max(max, count + vals[i]);
        }
        return max;
    }
*/

    public static int maxJump(int[] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
        return 0;
    }


    public static int maximumValue(String[] strs) {
        int max = Integer.MIN_VALUE;
        for (String s : strs) {
            Integer num = null;
            try {
                num = Integer.parseInt(s);
            } catch (Exception e) {

            }
            if (num != null) {
                max = Math.max(max, num);
            } else {
                max = Math.max(max, s.length());
            }
        }
        return max;
    }

}
