package com.atul.graph.DisJointSet;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public static void main(String[] args) {

        int[][] edges = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};//{{1,1,0},{1,1,0},{0,0,1}};
        //System.out.println(numProvinces(edges,edges));
    }

    static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                rank.add(0);
                size.add(1);
                parent.add(i);
            }
        }

        int findUp(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int up = findUp(parent.get(node));
            parent.set(node, up);
            return up;
        }

        void unionByRank(int u, int v) {
            int pu = parent.get(u);
            int pv = parent.get(v);
            if (pu == pv) return;
            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, pv);
            } else if (rank.get(pv) < rank.get(pu)) {
                parent.set(pv, pu);
            } else {
                parent.set(pv, pu);
                rank.set(pu, rank.get(pu) + 1);
            }
        }

        void unionBySize(int u, int v) {
            int pu = parent.get(u);
            int pv = parent.get(v);
            if (pu == pv) return;
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    ds.unionByRank(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                count++;
            }
        }
        return count;
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && adj.get(i).get(j) == 1) {
                    ds.unionByRank(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (ds.parent.get(i) == i) {
            }
            count++;
        }
        return count;
    }
}
