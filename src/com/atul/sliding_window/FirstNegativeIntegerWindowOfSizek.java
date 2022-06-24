package com.atul.sliding_window;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeIntegerWindowOfSizek {
    public static void main(String[] args) {
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(Arrays.toString(printFirstNegativeIntegerOp(arr, arr.length, k)));
    }

    public static long[] printFirstNegativeIntegerOp(long arr[], int N, int K)
    {
        long[] result = new long[N-K+1];
        Queue<Long> process = new LinkedList<>();
        int count = 0;
        int j=0;
        for(int i=0;i<N;i++){
            if(arr[i] < 0){
                process.offer(arr[i]);
            }
            count++;
            if(count==K){
                count -=1;
                if(!process.isEmpty()) {
                    result[j++] = process.peek();
                    if (process.peek() == arr[i - (K - 1)]) {
                        process.poll();
                    }
                }else{
                    result[j++] = 0;
                }
            }

        }
        return result;
    }

    public static long[] printFirstNegativeIntegerBrute(long arr[], int N, int K)
    {
        long[] result = new long[N-K+1];
        for (int i = 0; i < arr.length-K; i++) {
            long cur_neg = 0;
            for (int j = i; j < i+K; j++) {
                if(arr[j] < 0){
                    cur_neg = arr[j];
                    break;
                }
            }
            result[i] = cur_neg;
        }
        return result;
    }
}
