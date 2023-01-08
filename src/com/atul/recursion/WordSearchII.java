package com.atul.recursion;

import java.util.*;

public class WordSearchII {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        System.out.println(maxIceCream(costs, 7));
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int index = 0;
        while(coins >= 0){
            if(coins < costs[index]) break;
            coins-=costs[index];
            count++;
            index++;
        }
        return count;
    }

    static class Node{
        Node[] links = new Node[26];
        String word;

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }

        boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }

        Node get(char ch){
            return links[ch-'a'];
        }
    }

    public static List<String> findWords(char[][] grid, String[] words) {
        int n = grid.length;
        int m = grid[0].length;
        Node node = new Node();
        for (String s : words){
            put(s, node);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(grid, i, j, node, result);
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int i, int j, Node node, List<String> res){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }

        char ch = grid[i][j];
        if(ch == '#' || node.get(ch) == null) return;
        node = node.get(ch);
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }

        grid[i][j] = '#';
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int xtemp = xcor[k] + i;
            int ytemp = ycor[k] + j;
            dfs(grid, xtemp, ytemp, node, res);
        }

        grid[i][j] = ch;

    }

    private static void put(String word, Node node){
        Node temp = node;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if(!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
        }
        temp.word = word;
    }

    private static boolean solve(char[][] grid, int i, int j, boolean[][] vis, String word, int len) {
        if (len == word.length()) {
            return true;
        }

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || word.charAt(len) != grid[i][j]) {
            return false;
        }
        len++;
        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int xtemp = xcor[k] + i;
            int ytemp = ycor[k] + j;
            if(solve(grid, xtemp, ytemp, vis, word, len)){
                return true;
            }
        }
        return false;
    }

    public static List<String> findWordsopt(char[][] grid, String[] words) {
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
                solveOpt(grid, i, j, vis, set, "", result);
            }
        }
        return result;
    }

    private static void solveOpt(char[][] grid, int i, int j, boolean[][] vis, HashSet<String> words, String cur, List<String> result) {
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
                solveOpt(grid, xtemp, xtemp, vis, words, cur + grid[xtemp][ytemp], result);
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
