package com.atul.arrays;

import java.util.Arrays;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        int[][] tem = matrixReshape(arr, 1, 4);
        for (int[] i : tem) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println(tem.length);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] arr = new int[r][c];
        int row = 0, col = 0;
        int rowLen = mat.length;
        int colLen = mat[0].length;
        if (r * c == rowLen * colLen) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = mat[row][col];
                    col++;
                    if (col >= colLen) {
                        col = 0;
                        row++;
                    }
                }
            }
            return arr;
        }
        return mat;
    }
}
