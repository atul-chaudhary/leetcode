package com.atul.dynamic_programming;

public class CherryPickup  {

    private String name;
    public static void main(String[] args) {
        int[][] arr = {{1,1,-1},{1,-1,1},{-1,1,1}};
        topbottom(arr, 0, 0, arr.length, 0);
        System.out.println(bottomResult);

    }

    private static void topbottom(int[][] arr, int i , int j, int n, int csf){
        if(i == n-1 && j == n-1){
            bottomTop(arr, n-1, n-1, n, csf);
            return;
        }

        if(i>=n || j>=n || arr[i][j] == -1){
            return;
        }
        int cherries = arr[i][j];
        arr[i][j] = 0;
        topbottom(arr, i+1, j, n, csf+cherries);
        topbottom(arr, i, j+1, n, csf+cherries);
        arr[i][j] = cherries;
    }

    static int bottomResult = Integer.MIN_VALUE;
    private static void bottomTop(int[][] arr, int i, int j, int n, int csf){
        if(i==0 && j==0){
            bottomResult = Math.max(bottomResult, csf);
        }

        if(i < 0 || j < 0 || arr[i][j] == -1){
            return;
        }
        int cherries = arr[i][j];
        arr[i][j] = 0;
        bottomTop(arr, i-1, j, n, csf+cherries);
        bottomTop(arr, i, j-1, n, csf+cherries);
        arr[i][j] = cherries;
    }
}
