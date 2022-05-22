package com.atul.arrays;

public class PlusOne {
    public static void main(String[] args) {

    }

    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0) return new int[0];

        int m = mat.length;
        int n= mat[0].length;
        int row = 0;
        int col = 0;
        int [] arr = new int[m*n];
        boolean up = true;
        int i=0;
        while(row <m && col < n){
            if(up){
                while(row >0 && col <n-1){
                    arr[i++] = mat[row][col];
                    row--;
                    col++;
                }
                arr[i++] = mat[row][col];
                if(col == n-1){
                    row++;
                }else{
                    col++;
                }
                up = !up;
            }else{
                while(col>0 && row <m-1){
                    arr[i++] = mat[row][col];
                    col--;
                    row++;
                }
                arr[i++] = mat[row][col];
                if(row == m-1){
                    col++;
                }else{
                    row++;
                }
                up = !up;

            }
        }
        return arr;
    }
}
