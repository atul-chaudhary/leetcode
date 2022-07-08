package com.atul.dynamic_programming;

public class TargetSum {
    public static void main(String[] args) {
//        int[] arr = {100};
//        int target = -200;
//        System.out.println(findTargetSumWays(arr, target));
        int[] arr = {1,4,2,3};
        int sum = 4;
        System.out.println(countSubsetSumRecursive(arr, 4, arr.length));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sumOfArray = 0;
        for (int i = 0; i < n; i++)
            sumOfArray += nums[i];

        if ((sumOfArray + target) % 2 != 0)
            return 0;
        return countSubsetSum(nums, (sumOfArray + target) / 2);
    }

    public static int countSubsetSumRecursive(int[] arr, int sum, int n){
        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }


        if(arr[n-1] <= sum){
            return countSubsetSumRecursive(arr, sum - arr[n-1], n-1) + countSubsetSumRecursive(arr, sum, n-1);
        }else{
            return countSubsetSumRecursive(arr, sum, n-1);
        }
    }


    public static int countSubsetSum(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j]+ dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
