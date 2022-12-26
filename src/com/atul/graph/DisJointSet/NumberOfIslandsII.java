package com.atul.graph.DisJointSet;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] edges = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(numOfIslands(n, m, edges));
    }

    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int[][] nums = new int[rows][cols];
        int n = operators.length;
        List<Integer> result = new ArrayList<>();
        int count = 0;
        DisjointSet ds = new DisjointSet(rows*cols);
        int[] xcor = {1,-1,0,0};
        int[] ycor = {0,0,-1,1};
        for (int i = 0; i < n; i++) {
            int x = operators[i][0];
            int y= operators[i][1];
            if(nums[x][y] == 1){
                result.add(count);
                continue;
            }
            nums[x][y] = 1;
            count++;
            for (int j = 0; j < 4; j++) {
                int r = xcor[j] + x;
                int c = ycor[j] + y;
                if(isValid(r, c, nums)){
                    if(nums[r][c] == 1){
                        int u = x * cols + y;
                        int v = r * cols + c;
                        if(ds.findUP(u) != ds.findUP(v)){
                            count--;
                            ds.unionBySize(u, v);
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private static boolean isValid(int row, int col, int[][] nums){
        int n = nums.length;
        int m = nums[0].length;
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        int findUP(int node) {
            if (node == parent.get(node)) return node;
            int up = findUP(parent.get(node));
            parent.set(node, up);
            return up;
        }

        void unionBySize(int u, int v) {
            int pu = findUP(u);
            int pv = findUP(v);
            if (pu == pv) {
                return;
            }
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pv) + size.get(pu));
            }
        }
    }
}
