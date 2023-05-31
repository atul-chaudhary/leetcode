package com.atul.contest;

public class Contest28_05_2023 {
    public static void main(String[] args) {
        //int[][] grid = {{3, 1}, {3, 4}};//{{1,1},{1,1}};//{{3, 1, 6}, {-9, 5, 7}};
        //System.out.println(maxIncreasingCells(grid));
        String str = "456000";
        System.out.println(removeTrailingZeros(str));
    }

    int one;
    int two;
    int three;
    public void ParkingSystem(int big, int medium, int small) {
        this.one= big;
        this.two = medium;
        this.three = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1){
            if(one > 0){
                one--;
                return true;
            }else return false;
        }else if(carType == 2){
            if(two > 0){
                two--;
                return true;
            }else return false;
        }else {
            if(three > 0){
                three--;
                return true;
            }else return false;

        }
    }

    public static String removeTrailingZeros(String num) {
        int n = num.length();
        StringBuilder sb = new StringBuilder(num);
        int index = n - 1;
        while (sb.charAt(index) == '0') {
            sb.deleteCharAt(index);
            index--;
        }
        return sb.toString();
    }

    public static int maxIncreasingCells(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int minRow = -1;
        int minCol = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (min > mat[i][j]) {
                    min = mat[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        boolean[][] vis = new boolean[n][m];
        int cot = solve(mat, minRow, minCol, vis);
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (vis[i][j] == true) {
//                    count++;
//                }
//            }
//        }
        return cot;
    }

    private static int solve(int[][] grid, int i, int j, boolean[][] vis) {
        int row = 0;
        int col = 0;
        for (int k = 0; k < grid[0].length; k++) {
            if (k == j) continue;
            if (grid[i][k] > grid[i][j]) {
                int temp = 1 + solve(grid, i, k, vis);
                row = Math.max(row, temp);
            }
        }

        for (int k = 0; k < grid.length; k++) {
            if (k == i) continue;
            if (grid[k][j] > grid[i][j]) {
                int temp = solve(grid, k, j, vis);
                col = Math.max(col, temp);
            }
        }
        return Math.max(row, col);
    }
}
