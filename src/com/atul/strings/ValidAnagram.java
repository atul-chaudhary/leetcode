package com.atul.strings;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] tFrequency = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            tFrequency[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(--tFrequency[s.charAt(i)-'a'] < 0){
                return false;
            }
        }

        return true;
    }
}
