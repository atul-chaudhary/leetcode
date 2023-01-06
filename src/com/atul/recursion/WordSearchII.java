package com.atul.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        char[][] grid = {{'a', 'b'}, {'c', 'd'}};//{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"ab"};//{"oath","pea","eat","rain"};
        System.out.println(findWords(grid, words));
    }

    public static List<String> findWords(char[][] grid, String[] words) {
        int n = grid.length;
        int m = grid[0].length;
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String it : words) {
            set.add(it);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] vis = new boolean[n][m];
                solve(grid, i, j, vis, set, "", result);
            }
        }
        return result;
    }

    private static void solve(char[][] grid, int i, int j, boolean[][] vis, HashSet<String> words, String cur, List<String> result) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j]) {
            return;
        }
        if (words.contains(cur)) {
            result.add(cur);
        }
        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int xtemp = xcor[k] + i;
            int ytemp = ycor[k] + j;
            if (isValid(grid, xtemp, ytemp) && vis[xtemp][ytemp] == false) {
                solve(grid, xtemp, xtemp, vis, words, cur + grid[xtemp][ytemp], result);
            }
        }
    }

    private static boolean isValid(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= 0 && i < n && j >= 0 && j < m) {
            return true;
        }
        return false;
    }

}
