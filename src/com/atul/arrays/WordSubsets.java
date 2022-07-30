package com.atul.arrays;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"l", "e"};
        System.out.println(wordSubsets(words1, words2));
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        for(int i=0;i<words1.length;i++){
            String s = words1[i];
            boolean flag = true;
            for(int j=0;j<=words2.length;j++){
                if(!s.contains(words2[j])){
                    flag = false;
                    break;
                }
            }

            if(flag) result.add(s);
        }
        return result;
    }
}
