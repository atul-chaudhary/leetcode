package com.atul.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class ConcatenatedWords {
    public static void main(String[] args) {
        String word = "catsanddog";
        List<String> words = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(word, words));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        Set<String> set = new HashSet<>();
        for (String it : wordDict) {
            set.add(it);
        }
        List<String> result = new ArrayList<>();
        solve(set, s, 0, result);
        return result;
    }

    private static String solve(Set<String> set, String s, int index, List<String> result) {
        if (index >= s.length()) {
            return "";
        }
        for (int i = index; i < s.length(); i++) {
            String pref = s.substring(0, i + 1);
            String suff = s.substring(i + 1);
            if (set.contains(pref)) {
                result.add(pref + " " + solve(set, suff, i + 1, result));
            }
        }
        return "";
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(s);
        }
        List<String> result = new ArrayList<>();
        for (String s : words) {
            if (solve(s, set)) {
                result.add(s);
            }
        }
        return result;
    }

    private static boolean solve(String word, Set<String> set) {
        int size = word.length();

        for (int i = 0; i < size; i++) {
            String pref = word.substring(0, i + 1);
            String suff = word.substring(i + 1);
            if (set.contains(pref) && solve(suff, set) || set.contains(pref) && set.contains(suff)) {
                return true;
            }
        }
        return false;
    }


}
