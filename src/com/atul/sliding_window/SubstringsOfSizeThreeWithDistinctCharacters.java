package com.atul.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public static void main(String[] args) {
        HashSet<Integer> ah = new HashSet<>();
        ah.add(1);
        ah.add(1);
        ah.add(2);
        ah.add(3);
        System.out.println(ah);

//        String s = "aababcabc";
//        System.out.println(countGoodSubstringsOpt(s));
    }

    public static int countGoodSubstringsOpt(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.size();
        int ans = 0;
        int k = 3;
        for (int i = 0; i < s.length() - k; i++) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i) != s.charAt(i + 2) &&
                    s.charAt(i + 1) != s.charAt(i + 2)) {
                ans++;
            }
        }
        return ans;
    }

    public static int countGoodSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int k = 3;
        int ans = 0;
        boolean flg = false;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                flg = true;
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            count++;
            if (count == k) {
                System.out.println(map);
                count -= 1;
                if (flg == false) {
                    ans++;
                }
                flg = false;
                map.remove(s.charAt(i - k + 1));
            }
        }
        return ans;
    }
}
