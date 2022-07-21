package com.atul.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        String[] words = {"a","bb","acd","ace"};
        String s = "abcde";
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
//        int result = 0;
//        for(int i=0;i<words.length;i++){
//            if(check(words[i], s)){
//                result++;
//            }
//        }
//        return result;

        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ArrayList<Integer> arr = map.get(s.charAt(i));
                arr.add(i);
                map.put(s.charAt(i), arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(s.charAt(i), arr);
            }
        }
        System.out.println(map);
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            int index = 0;
            int count = 0;
            String w = words[i];
            System.out.println(">"+w);
            for (int j = 0; j < w.length(); j++) {
                if (map.containsKey(w.charAt(j))) {
                    ArrayList<Integer> arr = map.get(w.charAt(j));
                    for (int k = 0; k < arr.size(); k++) {
                        if (arr.get(k) >=  index) {
                            index = arr.get(k);
                            System.out.println("index "+ index);
                            count++;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (count == words[i].length()) {
                result++;
            }
        }
        return result;
    }

    private static boolean check(String a, String b) {
        int i = 0, j = 0;
        int count = 0;
        while (j < b.length() && i < a.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (count == a.length()) {
            //System.out.println("yes");
            return true;
        } else {
            //System.out.println("no");
            return false;
        }
    }
}
