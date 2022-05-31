package com.atul.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        String[] arr = {"abcw","baz","foo","bar","xtfn","abcdef"};
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(String[] words) {
        //Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        int finalResult = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                boolean result = isHavingSameElement(words[i], words[j]);
                if(!result){
                    finalResult = Math.max(finalResult,(words[i].length()*words[j].length()));
                }
            }
        }
        return finalResult;
    }

    public static boolean isHavingSameElement(String s1, String s2){
        boolean result = false;
        int s1Len = s1.length();
        int s2Len = s2.length();
        for (int i = 0; i < s1Len; i++) {
            for (int j = 0; j < s2Len; j++) {
                if(s1.charAt(i) == s2.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
}
