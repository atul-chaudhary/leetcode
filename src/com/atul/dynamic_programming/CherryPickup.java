package com.atul.dynamic_programming;

public class CherryPickup {


    public static void main(String[] args) {
        int[][] arr = {{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
        topbottom(arr, 0, 0, arr.length, 0);
        System.out.println(bottomResult);
    }

    int result = 0;

    private void solve(int[][] arr, int r1, int c1, int r2, int c2, int n, int csf) {

        int cherries = 0;
        if(r1== r2 && c1 == c2){
            cherries+= arr[r1][c1];
        }else{
            cherries+= arr[r1][c1]+arr[r2][c2];
        }

        //int f1 = solve(arr, r1, c1+1, r2, c2+1, n, csf+arr[][]);
    }

    private static void topbottom(int[][] arr, int i, int j, int n, int csf) {
        if (i == n - 1 && j == n - 1) {
            bottomTop(arr, n - 1, n - 1, n, csf);
            return;
        }
        if (i >= n || j >= n || arr[i][j] == -1) {
            return;
        }
        int cherries = arr[i][j];
        arr[i][j] = 0;
        topbottom(arr, i + 1, j, n, csf + cherries);
        topbottom(arr, i, j + 1, n, csf + cherries);
        arr[i][j] = cherries;
    }

    static int bottomResult = 0;

    private static void bottomTop(int[][] arr, int i, int j, int n, int csf) {
        if (i == 0 && j == 0) {
            bottomResult = Math.max(bottomResult, csf);
            return;
        }
        if (j < 0 || i < 0 || arr[i][j] == -1) {
            return;
        }
        int cherries = arr[i][j];
        arr[i][j] = 0;
        bottomTop(arr, i - 1, j, n, csf + cherries);
        bottomTop(arr, i, j - 1, n, csf + cherries);
        arr[i][j] = cherries;
    }
}
