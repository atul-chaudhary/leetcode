package com.atul.unkown;

import java.util.*;

public class WordBreak11 {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak("pineapplepenapple", arr));
    }

    public int countPoints(String rings) {
        HashMap<Integer, boolean[]> map = new HashMap<>();
        int n = rings.length();
        for (int i = 0; i < n; i = i + 2) {
            char ch = rings.charAt(i);
            int ring = Integer.parseInt(String.valueOf(rings.charAt(i + 1)));
            map.putIfAbsent(ring, new boolean[3]);
            boolean[] arr = map.get(ring);
            if (ch == 'R') {
                arr[0] = true;
            } else if (ch == 'G') {
                arr[1] = true;
            } else if (ch == 'B') {
                arr[2] = true;
            }
        }
        int count = 0;
        for (Map.Entry<Integer, boolean[]> entry : map.entrySet()) {
            boolean[] val = entry.getValue();
            if (val[0] && val[1] && val[2]) {
                count++;
            }
        }
        return count;
    }

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int last = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (last == -1) {
                last = entry.getValue();
            } else {
                if (entry.getValue() != last) {
                    return false;
                }
            }
        }
        return true;
    }

    //[pine apple pen apple, pine applepen apple, pineapple pen apple]
    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String it : wordDict) set.add(it);
        return solve(s, set, 0);
    }

    private static List<String> solve(String str, HashSet<String> set, int start) {
        List<String> validStr = new ArrayList<>();
        if (start == str.length()) {
            validStr.add("");
        }

        for (int end = start + 1; end <= str.length(); end++) {
            String pref = str.substring(start, end);
            if (set.contains(pref)) {
                List<String> suff = solve(str, set, end);
                for (String it : suff) {
                    validStr.add(pref + (it.equals("") ? "" : " ") + it);
                }
            }
        }
        return validStr;
    }
}
