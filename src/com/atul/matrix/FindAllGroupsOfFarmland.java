package com.atul.matrix;

import java.util.*;

public class FindAllGroupsOfFarmland {
    public static void main(String[] args) {
        int[][] nums =  {{1,1},{1,1}};
        int[][] result = findFarmland(nums);
        for(int[] row : result){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] findFarmland(int[][] land) {
        List<int[]> finalResult = new ArrayList<>();
        int n = land.length;
        int m = land[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && vis[i][j] == false) {
                    finalResult.add(solve(land, i, j, vis));
                }
            }
        }
        int size = finalResult.size();
        int[][] returnedResult = new int[size][4];
        for (int i = 0; i < size; i++) {
            returnedResult[i] = finalResult.get(i);
        }
        return returnedResult;
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int[] solve(int[][] nums, int i, int j, boolean[][] vis) {
        int[] result = new int[4];
        result[0] = i;
        result[1] = j;
        result[2] = i;
        result[3] = j;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(i, j));
        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.i;
            int y = pair.j;
            for (int k = 0; k < 4; k++) {
                int xtemp = xcor[k] + x;
                int ytemp = ycor[k] + y;

                if (isValid(xtemp, ytemp, nums, vis)) {
                    pq.offer(new Pair(xtemp, ytemp));
                    vis[xtemp][ytemp] = true;
                    addCorrectValues(result, xtemp,ytemp);
                }
            }
        }
        return result;
    }

    private static void addCorrectValues(int[] result, int i, int j){
        if(i > result[2]){
            result[2] = i;
            result[3] = j;
        }else if(i == result[2] && j > result[3]){
            result[3] = j;
        }
        System.out.println("inside correct "+Arrays.toString(result));
    }

    private static boolean isValid(int i, int j, int[][] nums, boolean[][] vis) {
        int n = nums.length;
        int m = nums[0].length;
        if (i >= 0 && i < n && j >= 0 && j < m && nums[i][j] == 1 && vis[i][j] == false) {
            return true;
        }
        return false;
    }

}
