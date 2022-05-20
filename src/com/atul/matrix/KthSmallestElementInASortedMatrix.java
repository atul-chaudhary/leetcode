package com.atul.matrix;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,5,9}, {10,11,13}, {12,13,15}};
        int[][] arr1 = {{1,2},{1,3}, {1,4}};
        int k=5;
        System.out.println(kthSmallest(arr1, k));

    }

    public static int kthSmallest(int[][] matrix, int k) {
        int p1= 0;
        int p2 = 0;
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            if(matrix[i][0] < matrix[i-1][n-1]){
                for (int j=0; j< n;j++){
                    if(matrix[i-1][p1] < matrix[i][p2]){
                        p1++;
                    }else {
                        int temp = matrix[i-1][p1];
                        matrix[i-1][p1] = matrix[i][p2];
                        matrix[i][p2] = temp;
                        p1++;
                        p2++;
                    }
                }
            }
        }

        for(int [] i : matrix){
            System.out.println(Arrays.toString(i));
        }
        return 0;
    }
}
