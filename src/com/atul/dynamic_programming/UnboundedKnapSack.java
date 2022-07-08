package com.atul.dynamic_programming;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int val[] = {10, 40, 50, 70};
        int wt[]  = {1, 3, 4, 5};
        int w = 8;
        System.out.println(recursive(wt, val, w, wt.length));
    }


    public static int recursive(int[] wt, int[] val, int w, int n){
        if(n == 0 || w ==0){
            return 0;
        }

        if(wt[n-1] <= w){
            return Math.max(val[n-1] + recursive(wt, val, w- wt[n-1], n), recursive(wt, val, w, n -1));
        }else{
            return recursive(wt, val, w, n-1);
        }
    }

}
