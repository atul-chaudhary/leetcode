package com.atul.arrays;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean result = searchMatrix(arr, 10);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (target <= matrix[i][col - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return false;
    }
}
