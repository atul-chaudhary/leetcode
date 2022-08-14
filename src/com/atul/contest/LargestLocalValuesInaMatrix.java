package com.atul.contest;

import java.util.Arrays;

public class LargestLocalValuesInaMatrix {
    public static void main(String[] args) {
        int[][] arr =  {
                {20,8,20,6,16,16,7,16,8,10},
                {12,15,13,10,20,9,6,18,17,6},
                {12,4,10,13,20,11,15,5,17,1},
                {7,10,14,14,16,5,1,7,3,11},
                {16,2,9,15,9,8,6,1,7,15},
                {18,15,18,8,12,17,19,7,7,8},
                {19,11,15,16,1,3,7,4,7,11},
                {11,6,5,14,12,18,3,20,14,6},
                {4,4,19,6,17,12,8,8,18,8},
                {19,15,14,11,11,13,12,6,16,19}};
        int[][] result = largestLocal(arr);
        for(int [] row : result){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int newN = n-2;
        int[][] result = new int[newN][newN];
        for (int i = 0; i < newN; i++) {
            for (int j = 0; j < newN; j++) {
                result[i][j] = solve(grid, i, j);
            }
        }
        return result;
    }

    private  static int solve(int[][] arr, int i, int j){
        System.out.println(i+ "  "+j);
        int max = 0;
        for (int k = i; k < i+3; k++) {
            for (int l = j; l < j+3; l++) {
                max = Math.max(max, arr[k][l]);
            }
        }
        return max;
    }
}
