package com.atul.contest;

public class NumberofCommonFactors {
    public static void main(String[] args) {
        int a = 885;
        int b = 885;
        System.out.println(commonFactors(a, b));
    }

    public static int commonFactors(int a, int b) {
        int max = Math.max(a, b);
        int count = 0;
        for(int i=1;i<= max;i++){
            if(a%i==0 && b %i ==0){
                count++;
            }
        }
        return count;
    }
}
