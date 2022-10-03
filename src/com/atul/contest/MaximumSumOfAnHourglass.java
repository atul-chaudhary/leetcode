package com.atul.contest;

public class MaximumSumOfAnHourglass {
    public static void main(String[] args) {
        int[][] arr = {{6,2,1,10},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int max = -1;
        for(int i=0;i<n-3+1;i++){
            for(int j=0;j<m-3+1;j++){
                int cur = 0;
                for(int k=j;k<j+3;k++){
                    cur+=arr[i][k]+arr[i+2][k];
                }
                cur +=arr[i+1][j+1];
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
