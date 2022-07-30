package com.atul.arrays;

import java.util.*;

public class WordSubsets {
    public static void main(String[] args) {

        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"l", "e"};
        System.out.println(wordSubsetsNew(words1, words2));

    }
    public static List<String> wordSubsetsNew(String[] words1, String[] words2) {
        int[] target = new int[26];
        for(String s : words2){
            int[] temp = new int[26];
            for(int i=0;i<s.length();i++){
                temp[s.charAt(i)-'a']++;
                target[s.charAt(i)-'a'] = Math.max(temp[s.charAt(i)-'a'], target[s.charAt(i)-'a']);
            }
        }
        List<String> result = new ArrayList<>();
        for(String s : words1){
            if(isMatched(s, target)){
                result.add(s);
            }
        }

        return result;
    }

    private static boolean isMatched(String s, int[] target) {
        int[] temp = new int[26];
        for (char c : s.toCharArray()){
            temp[c-'a']++;
        }

        for(int i=0;i<26;i++){
            if(temp[i] < target[i]){
                return false;
            }
        }
        return true;
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words1.length; i++) {
            String s = words1[i];
            boolean flag = true;
            for (int j = 0; j < words2.length; j++) {
                if (!isWordMatched(words1[i], words2[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(s);
        }
        return result;
    }

    private static boolean isWordMatched(String word1, String word2) {
        int[] a = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            a[word1.charAt(i) - 'a']++;
        }
        int[] b = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            b[word2.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (b[i] != 0 && a[i] < b[i]) {
                flag = false;
            }
        }
        return flag;
    }
}
