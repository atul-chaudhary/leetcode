package com.atul.contest;

import java.util.Arrays;

public class Contest26_11_22 {
    public static void main(String[] args) {
      String s = "YYNY";
        System.out.println(bestClosingTime(s));
    }

    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int[] yes = new int[n];
        int[] nos = new int[n];
        for(int i=n-2;i>=0;i--){
            if(customers.charAt(i+1)=='Y'){
                yes[i]+=yes[i+1]+1;
            }
        }
        System.out.println(Arrays.toString(yes));
        System.out.println(Arrays.toString(nos));
        return 0;
    }

    public  static int[][] onesMinusZeros(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[] oneCols = new int[m];
        int[] zeroCols = new int[m];


        int [] oneRows = new int[n];
        int[] zeroRows = new int[n];
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1){
                    oneRows[i]++;
                    oneCols[j]++;
                }else{
                    zeroCols[j]++;
                    zeroRows[i]++;
                }
            }
        }
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = oneRows[i] + oneCols[j] - zeroRows[i] - zeroCols[j];
            }
        }
        return diff;
    }
}
