package com.atul.strings;

import java.util.HashMap;
import java.util.Map;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {

        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minDistance(s1, s2));
    }


    public static int minDistance(String word1, String word2) {
        Map<Character, Integer> map1= new HashMap<>();
        Map<Character, Integer> map2= new HashMap<>();
        int len1 = word1.length();
        int len2 = word2.length();
        for(int i=0;i<len1;i++){
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i),0)+1);
        }
        for(int i=0;i<len2;i++){
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i),0)+1);
        }

       int count = 0;
        for(Character c: map1.keySet()){

        }



        return count;
    }
}
