package com.atul.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n=4;
        char ch  = (char) (5);
        System.out.println(ch);
        System.out.println(solveNQueens(n));
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] re  = new char[n][n];
        for(char[] ch: re){
            Arrays.fill(ch, '.');
        }
        List<List<String>> ans = new ArrayList<>();
        solveChar(4,0, re, ans);
        System.out.println(ans);
        return null;
    }
    private static void solveChar(int n, int row, char[][] result, List<List<String>> ans){
        if(row==n){
            ans.add(constructq(result));
            return;
        }
        for(int col = 0; col < n; col++){
            boolean t = isQueenSafeChar(row, col, n, result);
            if(t) {
                result[row][col] = 'Q';
                solveChar(n, row + 1, result, ans);
                result[row][col] = '.';
            }
        }
    }

    private static List<String> constructq(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    private static boolean isQueenSafeChar(int row, int col, int n,char[][] result){
        //for vertical
        for(int i = row-1;i >=0;i--){
            if(result[i][col] == 'Q') return false;
        }
        //  \
        for(int i= row-1, j= col-1; i>=0 && j >=0; i--, j--){
            if (result[i][j] == 'Q') return false;
        }
        // /
        for(int i=row-1, j= col+1; i>=0 && j<n;i--, j++){
            if (result[i][j] == 'Q') return false;
        }
        return true;
    }
}
