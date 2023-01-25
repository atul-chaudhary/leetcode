package com.atul.matrix;

import java.util.*;

public class SnakesAndLadders {
    public static void main(String[] args) {
        int[][] nums = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};
        System.out.println(snakesAndLadders(nums));
    }



    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> pq = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        vis[n-1][0] = true;
        pq.offer(1);
        int result = 0;
        while (!pq.isEmpty()){
            int size = pq.size();;

            for (int i = 0; i < size; i++) {
                int cur = pq.poll();
                if(cur == n*n) return result;

                for (int j = 1; j <= 6; j++) {
                    if(cur+j > n*n) break;
                    int[] pos = createIJ(cur+j, n);
                    int x = pos[0];
                    int y = pos[1];

                    if(vis[x][y] == true) continue;
                    vis[x][y] = true;
                    if(board[x][y] == -1){
                        pq.offer(j+cur);
                    }else {
                        pq.offer(board[x][y]);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private static int[] createIJ(int num, int n) {
        int r = n- (num-1)/n -1;
        int c = (num -1) %n;
        if(r%2==n%2){
           return new int[]{r, n-1-c};
        }else {
            return new int[]{r, c};
        }
    }


}
