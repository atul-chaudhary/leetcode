package com.atul.dfs;

public class WordSearch {
    public static void main(String[] args) {
        char[][] ch = {{'a'}};//{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s = "a";//"ABCCED";
        System.out.println(exist(ch, s));
    }

    public static boolean exist(char[][] arr, String word) {
        if(word == null) return true;
        int n = arr.length;
        int m = arr[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == arr[i][j]){
                    boolean[][] vis = new boolean[n][m];
                    if(solve(arr, i, j, word, vis, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean solve(char[][] arr, int i, int j, String word, boolean[][] vis, int len){

        if(len == word.length()){
            return true;
        }

        if(i<0 || i >= arr.length || j < 0 || j >= arr[0].length || vis[i][j] || arr[i][j] != word.charAt(len)){
            return false;
        }


        len++;
        vis[i][j] = true;

        int[] xcor = {1,-1,0,0};
        int[] ycor = {0,0,-1,1};
        for(int k=0;k<4;k++){
            int xnew = xcor[k]+i;
            int ynew = ycor[k]+j;
            if(solve(arr, xnew, ynew, word, vis, len)){
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
}
