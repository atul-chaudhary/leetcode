package com.atul.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(minDeletions(s));
    }

    public static int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println(map);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (Character c : map.keySet()) {
            System.out.print(c+ " ");
            if (set.contains(map.get(c))) {
                int val = map.get(c);
                while (val > 0) {
                    val--;
                    count++;
                    if (set.contains(val)){
                        continue;
                    }else{
                        set.add(val);
                        break;
                    }
                }
            }else{
                set.add(map.get(c));
            }
            System.out.println(set);
        }
        return count;
    }
}
