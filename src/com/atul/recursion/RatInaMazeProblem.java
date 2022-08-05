package com.atul.recursion;

import java.util.ArrayList;

public class RatInaMazeProblem {
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        boolean[][] vis = new boolean[n][n];
        ArrayList<String> result = new ArrayList<>();
        solve(0, 0, n, arr, result, "", vis);
        System.out.println(result);
    }

    private static void solve(int i, int j, int n, int[][] arr, ArrayList<String> result, String cur, boolean[][] vis) {
        if (i == n - 1 && j == n - 1) {
            result.add(cur);
            return;
        }

        if (i + 1 < n && !vis[i+1][j] && arr[i+1][j] == 1) {
            vis[i][j] = true;
            solve(i + 1, j, n, arr, result, cur + "D", vis);
            vis[i][i] = false;
        }
        if (i - 1 >= 0 && !vis[i-1][j] && arr[i-1][j] == 1) {
            vis[i][j] = true;
            solve(i - 1, j, n, arr, result, cur + "U", vis);
            vis[i][j] = false;
        }
        if (j < n && !vis[i][j+1] && arr[i][j+1] == 1) {
            vis[i][j] = true;
            solve(i, j + 1, n, arr, result, cur + "R", vis);
            vis[i][j] = false;
        }
        if (j-1>=0 && !vis[i][j-1] && arr[i][j-1] == 1) {
            vis[i][j] = true;
            solve(i, j - 1, n, arr, result, cur + "L", vis);
            vis[i][j] = false;
        }
    }
}
