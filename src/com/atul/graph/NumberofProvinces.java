package com.atul.graph;

import java.util.ArrayList;

public class NumberofProvinces {
    public static void main(String[] args) {
        int[][] arr =  {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }

    public  static int findCircleNum(int[][] arr){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i !=j && arr[i][j] !=0 ){
                    adj.get(i).add(j);
                }
            }
        }
        //System.out.println(adj);
        boolean[] vis = new boolean[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(vis[i] == false){
                count++;
                dfs(i, adj, vis);
            }
        }

        return count;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for (int vert : adj.get(node)){
            if(vis[vert] == false) {
                dfs(vert, adj, vis);
            }
        }
    }
}
