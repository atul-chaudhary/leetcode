package com.atul.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumOfDistancesInTree {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int n = 6;
        System.out.println(Arrays.toString(sumOfDistancesInTree(6, edges)));
    }

    private static int[] res;
    private static int[] count;
    private static List<HashSet<Integer>> tree;
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postOrder(0, -1);
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(res));
        preOrder(0, -1);
        return res;
    }

    public static void postOrder(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            postOrder(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }


    public static void preOrder(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            preOrder(i, root);
        }
    }
}
