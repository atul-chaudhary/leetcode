package com.atul.arrays;

public class Arrays4 {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(mat));
    }

    public static int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for(int i=0;i< accounts.length; i++){
            int count = 0;
            for(int j=0; j< accounts[0].length;j++){
                count += accounts[i][j];
            }

            if(count > maxSum){
                maxSum = count;
            }
        }
        return maxSum;
    }
}
