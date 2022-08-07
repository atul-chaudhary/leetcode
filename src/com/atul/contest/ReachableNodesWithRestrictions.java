package com.atul.contest;

import java.util.*;

public class ReachableNodesWithRestrictions {
    public static void main(String[] args) {
        int n=7;
        int[][] edges = {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] restricted = {4,5};
        System.out.println(reachableNodes(n, edges, restricted));
    }

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }

        for (int i = 0; i < edges.length; i++) {
            if(!set.contains(edges[i][0]) && !set.contains(edges[i][1])) {
                graph.get(edges[i][0]).add(edges[i][1]);
                graph.get(edges[i][1]).add(edges[i][0]);
            }
        }
        System.out.println(graph);
        ArrayList<Integer> storedfs = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(vis[i] == false && !set.contains(i)){
                dfs(i, vis, graph, storedfs, set);
            }
        }
        System.out.println(storedfs);
        return 0;
    }
    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storedfs, Set<Integer> res){
        storedfs.add(node);
        vis[node] = true;
        for (Integer it : adj.get(node)){
            if(vis[it] == false && !res.contains(it)){
                dfs(it, vis, adj, storedfs, res);
            }
        }
    }

    public int reachableNodesN(int n, int[][] edges, int[] restricted) {
        int count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<n;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<edges.length;i++)
        {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a:restricted)
            set.add(a);

        boolean[] visited= new boolean[n];
        visited[0]=true;

        for(int it:graph.get(0))
        {
            if(!visited[it])
            {
                dfs(it, graph, visited, set);
            }
        }
        for(int i = 0;i<visited.length;i++)
        {
            if(visited[i])
                count++;
        }
        return count;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> arr,boolean[] visited,HashSet<Integer> set)
    {
        if(set.contains(node))
            return;

        visited[node]= true;
        for(int key:arr.get(node))
        {
            if(!visited[key])
            {
                dfs(key, arr, visited, set);
            }
        }
    }
}
