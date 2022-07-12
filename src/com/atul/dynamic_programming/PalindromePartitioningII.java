package com.atul.dynamic_programming;

import java.util.Arrays;

public class PalindromePartitioningII {
    public static void main(String[] args) {

    }

    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(s, 0, n-1, dp);
    }

    private boolean isPalindrome(String str, int i, int j){
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private int solve(String s, int i, int j, int[][] dp){
        if(i >= j || isPalindrome(s, i, j)){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            if(isPalindrome(s, i, k)){
                int partitions = 1+solve(s, k+1, j, dp);
                ans = Math.min(ans, partitions);
            }
        }
        return dp[i][j] = ans;
    }
}
