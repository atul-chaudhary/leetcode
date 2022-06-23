package com.atul.graph;

public class NumberOfIslands {
    public static void main(String[] args) {
        String[][] grid = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(String[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j].equals("1") && !vis[i][j]){
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(String[][] graph, boolean[][] vis, int i, int j){
        if(i < 0 || j < 0 || i >= graph.length || j >= graph[0].length || vis[i][j] || graph[i][j].equals("0")
        ){
            return;
        }

        vis[i][j] = true;

        dfs(graph, vis, i-1, j);
        dfs(graph, vis, i+1, j);
        dfs(graph, vis, i, j-1);
        dfs(graph, vis, i, j+1);
    }
}
