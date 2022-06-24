package com.atul.sliding_window;

public class MaxSubArraySumOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2,5,2,9,7,1};
        maxSubArraySumOfSizeKOptimal(arr, 3);
    }

    public static void maxSubArraySumOfSizeKOptimal(int[] arr, int k){
        int max = Integer.MIN_VALUE;
        int cur_sum =0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            cur_sum += arr[i];
            count++;
            if(count==k){
                max = Math.max(max, cur_sum);
                count -= 1;
                cur_sum -= arr[i-(k-1)];
            }
        }

        System.out.println(max);
    }

    public static void maxSubArraySumOfSizeKBruteForce(int[] arr, int k){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-k; i++) {
            int cur = 0;
            for (int j = i; j < i+k; j++) {
                cur+=arr[j];
            }
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }

}
