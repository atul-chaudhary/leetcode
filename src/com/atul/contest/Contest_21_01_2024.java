package com.atul.contest;

import java.util.*;

public class Contest_21_01_2024 {

    public static void main(String[] args) {

    }

    static class Pair {
        int val;
        char chl;

        public Pair(int val, char chl) {
            this.val = val;
            this.chl = chl;
        }
    }

    public int minimumPushes(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int lst = entry.getValue();
            pairs.add(new Pair(lst, ch));
        }
        Collections.sort(pairs, (a, b) -> b.val - a.val);
        Map<Integer, List<Character>> formed = new HashMap<>();

        return 0;
    }


}
