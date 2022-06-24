package com.atul.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPairs {
    public static void main(String[] args) throws IOException {
        int[] a = {2,4,9,7,101,100,66,58};
        int[] b = {1,2,6,3,96,94,59,50};
        System.out.println(solve(8, a, b));
    }

    static int solve(int N, int[] A, int[] B){
        // write your code here
        int result = 0;
        for(int i=0;i<N-1;i++){
            for(int j = i+1;j<N;j++){
                int temp = (A[i] - B[j]) + (A[j] - B[i]);
                result = Math.max(result, temp);
            }
        }

        return result;

    }
}
