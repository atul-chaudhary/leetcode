package com.atul.arrays;

public class Arrays6 {
    public static void main(String[] args) {
        String[] arr = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFoundBruteForce(arr));
    }

    public static int mostWordsFound(String[] sentences) {
        int maxCount = 0;
        for(String s : sentences){
            maxCount = Math.max(maxCount, s.split(" ").length);
        }
        return maxCount;
    }

    public static int mostWordsFoundBruteForce(String[] sentences) {
        int maxCount = 0;
        for(String s : sentences){
            int tempCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == ' '){
                    tempCount++;
                }
            }
            maxCount = Math.max(maxCount, tempCount+1);
        }
        return maxCount;
    }
}
