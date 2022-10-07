package com.atul.graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solve(s, b)));
    }

    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        ArrayList<int[]> input = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            int[] temp = solve(dict[i], dict[i + 1]);
            input.add(temp);
        }
        //creating graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] row : input) {
            adj.get(row[0]).add(row[1]);
        }
        //graph creation finished

        int[] indgree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indgree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indgree[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            sb.append((char) (node + 'a'));
            for (int temp : adj.get(node)) {
                indgree[temp]--;
                if (indgree[temp] == 0) {
                    pq.offer(temp);
                }
            }
        }
        return sb.toString();
    }

    private static int[] solve(String a, String b) {
        if (a.charAt(0) != b.charAt(0)) {
            int a1 = a.charAt(0) - 'a';
            int b1 = b.charAt(0) - 'a';
            return new int[]{a1, b1};
        } else {
            int n = a.length();
            int m = b.length();
            int min = Math.min(n, m);
            for (int i = 0; i < min; i++) {
                if (a.charAt(i) == b.charAt(i)) continue;
                else {
                    int a1 = a.charAt(i) - 'a';
                    int b1 = b.charAt(i) - 'a';
                    return new int[]{a1, b1};
                }
            }
        }
        return new int[2];
    }
}
