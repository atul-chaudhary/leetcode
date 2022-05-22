package com.atul.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] arr = { {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        int[][] arr1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] arr2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(spiralOrder(arr));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top_row = 0;
        int leFt_col = 0;
        int right_col = n-1;
        int bottom_row = m-1;
        //System.out.println(bottom_row);
        while (top_row <= bottom_row && leFt_col <= right_col){
            for (int i = leFt_col; i <= right_col; i++) {
                arr.add(matrix[top_row][i]);
                //System.out.println(arr);
            }
            top_row++;
            //System.out.println(">>"+top_row);
            //System.out.println(">>"+bottom_row);
            for (int i = top_row; i <=bottom_row ; i++) {
                arr.add(matrix[i][right_col]);
                //System.out.println(arr);
            }
            //System.out.println(arr);
            right_col--;
            for (int i = right_col; i >= leFt_col; i--) {
                arr.add(matrix[bottom_row][i]);
            }
            bottom_row--;
            for (int i = bottom_row; i >= top_row; i--) {
                arr.add(matrix[i][leFt_col]);
            }
            leFt_col++;
        }
        return arr;
    }
}
