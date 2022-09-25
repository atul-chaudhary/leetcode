package com.atul.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }

    //DFS wont work in this case we have to use the BFS
    public static int orangesRotting(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;
        int fresh = 0;
        Queue<int[]> pq = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 2){
                    pq.offer(new int[]{i,j,0});
                }else if(arr[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int max = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0;i<size;i++){
                int[] temp = pq.poll();
                int x1 = temp[0];
                int y1 = temp[1];
                int time = temp[2];

                int[] xcor = {-1,1,0,0};
                int[] ycor = {0,0,1,-1};
                for(int j=0;j<4;j++){
                    int xtemp = xcor[j];
                    int ytemp = ycor[j];
                    int x = xtemp+x1;
                    int y = ytemp+y1;

                    if(isValid(x, y, n, m, arr)){
                        pq.offer(new int[] {x, y, time+1});
                        arr[x][y] = 2;
                        max = Math.max(max, time+1);
                    }
                }
            }

        }

        boolean isFreshFound = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 1){
                    isFreshFound = true;
                    break;
                }
            }
        }
        if(isFreshFound) return -1;
        else return max;

    }

    private static boolean isValid(int i, int j, int n, int m, int[][] arr){
        if(i < 0 || i >=n || j <0 || j>=m || arr[i][j] == 2 || arr[i][j] == 0){
            return false;
        }else {
            return true;
        }
    }
}
