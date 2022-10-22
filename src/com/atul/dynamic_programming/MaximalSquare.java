package com.atul.dynamic_programming;

//its complete dp questions
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] arr ={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        //System.out.println(maximalSquare(ch));
        solve(arr, 0, 0);
        System.out.println(maxi);

        int[][] arrte = new int[1][1];
        arrte[0][0] = -1;
        System.out.println(arrte[0][0]);

    }

    static int maxi = 0;
    private static int solve(char[][] arr, int i, int j) {
        if (i >= arr.length || j >= arr[0].length) {
            return 0;
        }
        int right = solve(arr, i, j + 1);
        int dia = solve(arr, i + 1, j + 1);
        int bottom = solve(arr, i + 1, j);

        if (arr[i][j] == '1') {
            int ans = 1 + Math.min(right, Math.min(dia, bottom));
            maxi = Math.max(maxi, ans);
            return ans;
        } else {
            return 0;
        }
    }

    public static int maximalSquare(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '1') {
                    int k = 2;
                    while (true) {
                        if (solve(arr, i, j, k)) {
                            max = Math.max(max, k);
                            k++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }

    private static boolean solve(char[][] arr, int i, int j, int k) {
        if (i + k < arr.length && j + k < arr[0].length) {
            for (int l = i; l < i + k; l++) {
                for (int m = j; m < j + k; m++) {
                    if (arr[l][m] != '1') {
                        return false;
                    }
                }
            }
            return true;
        } else return false;
    }
}
