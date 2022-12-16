package com.atul.trie;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public static void main(String[] args) {
        String[] arr = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        //System.out.println(camelMatch(arr, pattern));
    }

//    public List<Boolean> camelMatch(String[] queries, String pattern) {
//
//    }
//
//    private static boolean solve(String a, String b, int i, int j){
//        if()
//
//    }


    public static List<Boolean> camelMatchOpt(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        List<String> pat = split(pattern);
        for (String it : queries) {
            List<String> que = split(it);
            if (que.size() != pat.size()) {
                result.add(false);
            } else {
                result.add(check(que, pat));
            }
        }
        return result;
    }

    private static boolean check(List<String> que, List<String> pat) {
        int n = que.size();
        int index = 0;
        while (index < n){
            String patWord = pat.get(index);
            String queWord = que.get(index);
            int len = patWord.length();
            for (int i = 0; i < len; i++) {
                if(patWord.charAt(i) != queWord.charAt(i)){
                    return false;
                }
            }
            index++;
        }
        return true;
    }

    private static List<String> split(String word) {
        List<String> result = new ArrayList<>();
        int index = 0;
        int n = word.length();
        while (index < n) {
            char ch = word.charAt(index);
            StringBuilder stringBuilder = new StringBuilder();
            if (ch >= 'A' && ch <= 'Z') {
                stringBuilder.append(word.charAt(index));
                index++;
                while (index < n && word.charAt(index) >= 'a' && word.charAt(index) <= 'z') {
                    stringBuilder.append(word.charAt(index));
                    index++;
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }
}
