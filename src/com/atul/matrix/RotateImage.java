package com.atul.matrix;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(arr);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        int[][] result = new int[n][n];
        int firstRow = 0;
        int lastRow = n-1;
        int firstCol = 0;
        int lastCol = n-1;
        while(firstCol <= lastCol  && firstRow <= lastRow){
            //for first row to last col
            for (int i = 0; i < n; i++) {
                result[i][lastCol] = matrix[firstRow][i];
            }
            //lastcol to last row
            for (int i = 0, j=n-1; i < n; i++, j--) {
                result[lastRow][j] = matrix[i][lastCol];
            }
            //for last row to first col
            for (int i = 0; i < n; i++) {
                result[i][firstCol] = matrix[lastCol][i];
            }
            //for first col to first row
            for (int i = 0, j=n-1; i < n; i++, j--) {
                result[firstRow][i] = matrix[j][firstCol];
            }
            firstCol++;
            lastCol--;
            firstRow++;
            lastRow--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }
        //return result;
    }
}
