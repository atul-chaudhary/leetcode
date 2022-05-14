package com.atul.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class validSudoku {

    public static void main(String[] args) {
        int[][] board = {{7, 9, 2, 1, 5, 4, 3, 8, 6},
                {6, 4, 3, 8, 2, 7, 1, 5, 9},
                {8, 5, 1, 3, 9, 6, 7, 2, 4},
                {2, 6, 5, 9, 7, 3, 8, 4, 1},
                {4, 8, 9, 5, 6, 1, 2, 7, 3},
                {3, 1, 7, 4, 8, 2, 9, 6, 5},
                {1, 3, 6, 7, 4, 8, 5, 9, 2},
                {9, 7, 4, 2, 1, 5, 6, 3, 8},
                {5, 2, 8, 6, 3, 9, 4, 1, 7}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(int[][] board) {
        Map<String, Integer> isRowValid = new HashMap<>();
        Map<String, Integer> isColValid = new HashMap<>();
        HashMap<String, Integer> isGridValid = new HashMap<>();
        int counter = 0;
        int gridNumber = 0;
        for (int i = 0; i < board.length; i++) {
            gridNumber = 0;
            counter = 0;
            for (int j = 0; j < board[0].length; j++) {
                //this condition check for val;id row
                String rowValue = board[i][j] + "-"+  i;
                if (isRowValid.containsKey(rowValue)) {
                    System.out.println("first");
                    return false;
                } else {
                    isRowValid.put(rowValue, 1);
                }

                //this condition check for valid column
                if (i == j) {
                    System.out.println("col valid");
                    String colValue = board[i][j] + "-"+  j;
                    if (isColValid.containsKey(colValue)) {
                        System.out.println("second");
                        return false;
                    } else {
                        isColValid.put(colValue, 1);
                    }
                }

                String value = board[i][j] +"-"+ gridNumber;
                if(isGridValid.containsKey(value)){
                    System.out.println("third");
                    return false;
                }else {
                    isGridValid.put(value, 1);
                    counter++;

                    if(counter >=3 ){
                        counter = 0;
                        gridNumber++;
                    }
                }
                System.out.println(isRowValid);
                System.out.println(isColValid);
                System.out.println(isGridValid);
                System.out.println();
            }
        }
        return true;
    }
}
