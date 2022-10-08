package com.atul.heap;

import java.util.Locale;

public class LargestNumberAfterDigitSwapsByParity {
    public static void main(String[] args) {
        int num = 247;
        System.out.println(largestInteger(num));
    }

    public static int largestInteger(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        int n = s.length();
        if(n <= 2) return n;
        for(int i=n-1;i>=2;i--){
            if(i %2==0){
                for(int j=0;j<i;j=j+2){
                    if(Integer.parseInt(String.valueOf(s.charAt(j))) < Integer.parseInt(String.valueOf(s.charAt(i)))){
                        char temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        break;
                    }
                }
            }else{
                for(int j=1;j<i;j=j+2){
                    if(Integer.parseInt(String.valueOf(s.charAt(j))) < Integer.parseInt(String.valueOf(s.charAt(i)))){
                        char temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        break;
                    }
                }
            }
        }
        String result = new String(arr);
        return Integer.parseInt(result);
    }
}
