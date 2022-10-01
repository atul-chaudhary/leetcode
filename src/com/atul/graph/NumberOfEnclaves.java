package com.atul.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        System.out.println(numberOfEnclaves(arr));
    }

    static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static int numberOfEnclaves(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> pq = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(arr[i][0]== 1){
                //dfs(arr, i, 0, n, m, vis);
                pq.offer(new Pair(i, 0));
            }

            if(arr[i][m-1] == 1){
                //dfs(arr, i, m-1, n, m, vis);
                pq.offer(new Pair(i, m-1));
            }
        }

        for(int i=0;i<m;i++){
            if(arr[0][i] == 1){
                //dfs(arr, 0, i, n, m, vis);
                pq.offer(new Pair(0, i));
            }

            if(arr[n-1][i] == 1){
                //dfs(arr, n-1, i, n, m, vis);
                pq.offer(new Pair(n-1, i));
            }
        }

        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0;i<size;i++){
                Pair p = pq.poll();
                int x1 = p.i;
                int y1 = p.j;
                vis[x1][y1] = true;
                int[] xcor = {1,-1,0,0};
                int[] ycor = {0,0,1,-1};
                for(int j=0;j<4;j++){
                    int x = x1+xcor[j];
                    int y = y1+ycor[j];
                    if(x < 0 || x >= n || y < 0 || y >= m) continue;
                    if(vis[x][y] == false && arr[x][y]==1){
                        pq.offer(new Pair(x, y));
                    }
                }
            }
        }

        for(boolean[] row : vis) System.out.println(Arrays.toString(row));
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]== false && arr[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
