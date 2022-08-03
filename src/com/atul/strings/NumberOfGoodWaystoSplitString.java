package com.atul.strings;

import java.util.Arrays;

public class NumberOfGoodWaystoSplitString {
    public static void main(String[] args) {
        String s  = "a";
        System.out.println(numSplits(s));
    }

    public static int numSplits(String s) {
        int n = s.length();
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        int[] fre1 = new int[n];
        int[] fre2 = new int[n];
        int count = 0;
        for(int i=0;i<s.length();i++){
            int i1 = s.charAt(i) - 'a';
            if(s1[i1] == 0){
                s1[i1]++;
                count++;
                fre1[i] = count;
            }else{
                s1[i1]++;
                fre1[i] = count;
            }
        }
        count = 0;
        for(int i=n-1;i>=0;i--){
            int i1 = s.charAt(i)-'a';
            if(s2[i1] == 0){
                s2[i1]++;
                count++;
                fre2[i] = count;
            }else{
                s2[i1]++;
                fre2[i] = count;
            }
        }
        count = 0;
        for(int i=0;i<n-1;i++){
            if(fre1[i] == fre2[i+1])count++;
        }

        return count;
    }
}
