package com.atul.graph.DisJointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        int[][] edges=  {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};//{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(edges));
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = -1;
        int maxcol = -1;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxcol = Math.max(maxcol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxcol + maxRow + 1);
        Map<Integer, Integer> colsRows = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int u = stones[i][0];
            int v = stones[i][1] + maxRow + 1;
            ds.unionBySize(u, v);
            colsRows.put(u, 1);
            colsRows.put(v, 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : colsRows.entrySet()){
            if(entry.getKey() == ds.findUP(entry.getKey())){
                count++;
            }
        }
        return n-count;
    }

    static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
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
