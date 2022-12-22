package com.atul.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KeysAndRooms {
    //this solution is working perfectly with no issues
    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                count++;
                solve(adj, vis, i);
            }
        }
        return count == 1;
    }

    private static void solve(List<List<Integer>> adj, boolean[] vis, int node){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                solve(adj, vis, it);
            }
        }
    }

}
