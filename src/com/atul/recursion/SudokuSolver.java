package com.atul.recursion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SudokuSolver {
    public static void main(String[] args) {
        System.out.println((char) (1+48));
        char[][] sudoko = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(sudoko);
        for(char [] ch : sudoko){
            System.out.println(Arrays.toString(ch));
        }
    }

    public static void solveSudoku(char[][] arr) {
        solveBoard(arr);
    }

    private static boolean isNumberInRow(char[][] board, int number, int row) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(char[][] board, int number, int column) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(char[][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(char[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column) &&
                !isNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {

                if (board[row][column] == '.') {
                    for (int numberToTry = 1; numberToTry <= board.length; numberToTry++) {
                        if (isValidPlacement(board, numberToTry+48, row, column)) {
                            board[row][column] = (char)(numberToTry+48);

                            if (solveBoard(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = '.';
                            }
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }
}
