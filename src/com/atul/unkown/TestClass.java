package com.atul.unkown;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class TestClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] vertexNumber = new int[n];
        for (int i = 0; i < n; i++)
            vertexNumber[i] = Integer.parseInt(br.readLine());

        int e = Integer.parseInt(br.readLine());
        int[][] edges = new int[e][];
        for (int i = 0; i < e; i++) {
            edges[i] = Arrays.stream(br.readLine().split("\\s+")).mapToInt
                    (Integer::parseInt).toArray();
        }

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        Map<Integer, Integer> mapYo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapYo.putIfAbsent(vertexNumber[i], i);
        }

        Map<Integer, Integer> mapRev = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapRev.putIfAbsent(i, vertexNumber[i]);
        }

        int a = mapYo.get(A);
        int b = mapYo.get(B);

        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            int u = mapYo.get(edge[0]);
            int v = mapYo.get(edge[1]);
            graph.edges(u, v);
        }
        TreeSet<Integer> nodes = graph.dfs(a, b);
        if (nodes.isEmpty()) {
            bw.write("-1\n");
        } else {
            bw.write(nodes.stream().map(elem -> mapRev.get(elem)).collect(Collectors.toList()).toString().replaceAll("\\[|]|, ", " ") + "\n");
        }
        bw.flush();
    }
}

class Graph {
    private int V;
    private List<Integer>[] adj;

    Graph(int n) {
        this.V = n;
        this.adj = new List[n];
        for (int i = 0; i < n; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void edges(int a, int b) {
        this.adj[a].add(b);
    }

    public TreeSet<Integer> dfs(int a, int b) {
        TreeSet<Integer> map = new TreeSet<>();
        if (a == b) {
            map.add(a);
        }
        boolean[] vis = new boolean[V];
        vis[a] = true;

        for (int it : this.adj[a]) {
            if (it == b) {
                map.add(a);
            } else if (!vis[it]) {
                if (dfsUtil(it, b, vis))
                    map.add(it);
            }
        }
        return map;
    }

    private boolean dfsUtil(int a, int b, boolean[] vis) {
        vis[a] = true;
        if (a == b)
            return true;

        for (int neigh : this.adj[a]) {
            if (!vis[neigh])
                if (dfsUtil(neigh, b, vis)) {
                    return true;
                }
        }
        return false;
    }
}