package com.atul.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
        String txt = "aabaabaa";
        String pat = "aaba";
        System.out.println(searchMost(pat, txt));
    }

    public static int searchMost(String pat, String txt) {
        int result = 0;
        int count = 0;
        int[] p = new int[26];
        int[] t = new int[26];
        for (int i = 0; i < pat.length(); i++) {
            p[pat.charAt(i)-'a']++;
        }
        for (int i = 0; i < txt.length(); i++) {
            t[txt.charAt(i)-'a']++;
            count++;
            if(count==pat.length()){
                count-=1;
                if(Arrays.equals(t,p)){
                    result++;
                }
                char temp = txt.charAt(i- (pat.length()-1));
                t[temp-'a']--;
            }
        }
        return result;
    }

    public static int search(String pat, String txt) {
        int result = 0;
        int count = 0;
        Map<Character, Integer> p = new HashMap<>();
        for(int i=0;i<pat.length();i++){
            p.put(pat.charAt(i), p.getOrDefault(pat.charAt(i),0)+1);
        }
        Map<Character, Integer> t = new HashMap<>();
        for (int i = 0; i < txt.length(); i++) {
            t.put(txt.charAt(i), t.getOrDefault(txt.charAt(i),0)+1);
            count++;
            if(count==pat.length()){
                count-=1;
                 if(mapChecker(t, p, pat)){
                     result++;
                 }
                char temp = txt.charAt(i-(pat.length()-1));
                t.put(temp, t.get(temp)-1);
            }
        }
        return result;
    }

    private static boolean mapChecker(Map<Character, Integer> t, Map<Character, Integer> p, String pat){
        boolean result = true;
        for(int i=0;i<pat.length();i++){
            if(!t.containsKey(pat.charAt(i))){
                return false;
            }
            if(!(t.get(pat.charAt(i)).equals(p.get(pat.charAt(i))))){
                result = false;
            }
        }
        return result;
    }

    public static int searchBrute(String pat, String txt) {
        int count = 0;
        Map<Character, Integer> p = new HashMap<>();
        for(int i=0;i<pat.length();i++){
            p.put(pat.charAt(i), p.getOrDefault(pat.charAt(i),0)+1);
        }
        for (int i = 0; i < txt.length()-pat.length() + 1; i++) {
            Map<Character, Integer> t = new HashMap<>();
            for (int j = i; j < i+pat.length(); j++) {
                t.put(txt.charAt(j), t.getOrDefault(txt.charAt(j),0)+1);
            }
            boolean flg = true;
            for(int j=0;j<pat.length();j++){
                if(!(p.get(pat.charAt(j)).equals(t.get(pat.charAt(j))))){
                    flg = false;
                }
            }

            if(flg){
                count++;
            }
        }
        return count;
    }
}
