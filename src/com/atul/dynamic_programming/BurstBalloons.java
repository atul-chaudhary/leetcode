package com.atul.dynamic_programming;

public class BurstBalloons {
    public static void main(String[] args) {
        int[] bal = {3,1,5,8};
        System.out.println(solve(bal, 0, bal.length-1, bal.length));
    }

    private static int solve(int[] arr, int i, int j, int n){
        if(i > j) return 0;

        int ans = Integer.MIN_VALUE;
        for (int k=i;k<=j;k++){
            int temp = solve(arr, i, k, n) + solve(arr, k+1, j, n) + k-1 < 0 ? 1 : arr[k-1] * arr[k] * k+1 > n-1 ? 1 : arr[k+1];
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
