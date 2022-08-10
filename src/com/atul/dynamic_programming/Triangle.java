package com.atul.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        System.out.println(solve(arr, 0, 0, arr.length));
        List<List<Integer>> res = new ArrayList<>();
        for(int []  row : arr){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int it : row){
                temp.add(it);
            }
            res.add(temp);
        }
        System.out.println(res);
        System.out.println(solveTab(res));
    }

    static int minimumPathSum(List<List<Integer>> triangle, int n){

        int front[] = new int[n];
        int cur[] = new int[n];

        for(int j=0;j<n;j++){
            front[j] = triangle.get(n-1).get(j);//triangle[n-1][j];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){

                int down = triangle.get(i).get(j)/*triangle[i][j]*/+front[j];
                int diagonal = triangle.get(i).get(j)/*triangle[i][j]*/+front[j+1];

                cur[j] = Math.min(down, diagonal);
            }
            front=cur;
        }

        return front[0];

    }

    private static int solveTab(List<List<Integer>> arr){
        int n = arr.size();
        //int[][] dp = new int[n][n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = arr.get(n-1).get(i);
        }
//        for(int [] row : dp){
//            System.out.println(Arrays.toString(row));
//        }

        for (int i = n-2; i >=0 ; i--) {
            for (int j = i; j >=0 ; j--) {
                int first = arr.get(i).get(j) + dp[i];
                int second = arr.get(i).get(j) + dp[i+1];
                dp[i] = Math.min(first, second);
            }
        }
        System.out.println(Arrays.toString(dp)) ;
        return dp[0];
    }

    private static int solve(int[][] arr, int i, int j, int n){
        if(i == n-1){
            return arr[i][j];
        }

        int first = arr[i][j] + solve(arr, i +1, j, n);
        int second = arr[i][j] + solve(arr, i+1, j+1,n);
        return Math.min(first, second);
    }
}
