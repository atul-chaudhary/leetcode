package com.atul.dynamic_programming;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }

    public static int numTrees(int n) {
        if(n==0 || n==1) return 1;
        int ans = 0;
        int c1 = 1;
        int c2 = 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int num = 0;
            for(int j=0,k=i-1;j<i;j++, k--){
                num+=dp[j]*dp[k];
            }
            dp[i] = num;
        }
        return dp[n];
    }
}
