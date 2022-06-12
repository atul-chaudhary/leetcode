package com.atul.arrays;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int count = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < len; j++) {
                if(!map.containsKey(s.charAt(j))){
                    count++;
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                    max = Math.max(max, count);
                }else{
                    break;
                }
            }
        }
        System.out.println(max);
        return max;
    }
}
