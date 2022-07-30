package com.atul.recursion;

public class SudokuSolver {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] arr) {
        solve(arr);
    }

    private boolean solve(char[][] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;i++){

                if(arr[i][j] == '.'){

                    for(int k=1; k <= 9;k++){
                        if(helper(arr, k, i, j)== true){
                            arr[i][j] = (char) (k+48);
                            solve(arr);
                            return true;
                        }else{
                            arr[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }

        return true;
    }

    private boolean helper(char[][] arr, int num, int row, int col){
        //col check
        for(int i=0;i<arr[0].length;i++){
            if(num == arr[row][i]) return false;
        }

        //row check
        for(int i=0;i<arr.length;i++){
            if(num== arr[i][col]) return false;
        }

        //small block check
        //block calculation
        int r = row/3;
        int c = col/3;
        for(int i=0;i<r+3;i++){
            for(int j=0;j<c+3;j++){
                if(num == arr[i][j]) return false;
            }
        }

        return true;
    }
}
