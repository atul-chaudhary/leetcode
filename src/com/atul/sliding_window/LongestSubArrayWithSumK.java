package com.atul.sliding_window;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr ={10, 5, 2, 7, 1, 9};
        int k = 15;
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int cur = 0;
            for(int j=i;j<arr.length;j++){
                cur += arr[j];
                if(cur == k){
                    max = Math.max(max, j-i+1);
                }
                System.out.println(cur);
            }
        }
        System.out.println(max);
        //return max;


    }
}
