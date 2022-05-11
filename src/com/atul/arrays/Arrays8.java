package com.atul.arrays;
import java.util.Arrays;

public class Arrays8 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(arr);
        subrectangleQueries.updateSubrectangle(0,0,3,2,5);
    }
}

class SubrectangleQueries {
    int[][] arr;

    public SubrectangleQueries(int[][] rectangle) {
        this.arr = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                arr[i][j] = newValue;
            }
        }
        for(int[] yo: arr){
            System.out.println(Arrays.toString(yo));
        }
    }

    public int getValue(int row, int col) {
        return arr[row][col];
    }
}

