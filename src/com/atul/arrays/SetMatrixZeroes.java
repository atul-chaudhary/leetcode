package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroesWithoutExtraSpace(arr);
    }

    public static void setZeroes(int[][] matrix) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 0){
                    arrayList.add(new int[]{i,j});
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i)[0]+ " "+arrayList.get(i)[1]);
            for (int j = 0; j < col; j++) {
                matrix[arrayList.get(i)[0]][j] = 0;
            }
            for (int j = 0; j < row; j++) {
                matrix[j][arrayList.get(i)[1]] = 0;
            }
        }
        for (int[] i: matrix){
            System.out.println(Arrays.toString(i));
        }
    }

    ///without using extra space
    public static void setZeroesWithoutExtraSpace(int[][] matrix) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 0){
                    //arrayList.add(new int[]{i,j});
                    System.out.println(i+" "+ j);
//                    for (int k = 0; k < col; k++) {
//                        matrix[i][k] = 0;
//                    }
//                    for (int k = 0; k < row; k++) {
//                        matrix[k][j] = 0;
//                    }
                }
            }
        }

        for (int[] i: matrix){
            System.out.println(Arrays.toString(i));
        }
    }
}
