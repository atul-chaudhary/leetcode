package com.atul.unkown;

import java.util.*;

public class NamingACompany {
    public static void main(String[] args) {
        String[] nums = {"coffee", "donuts", "time", "toffee"};
        System.out.println(distinctNames(nums));
    }

    public static long distinctNames(String[] ideas) {
        int n = ideas.length;
        Set<String> set = new HashSet<>();
        Map<Character, List<String>> dis = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.add(ideas[i]);
            dis.putIfAbsent(ideas[i].charAt(0), new ArrayList<>());
            List<String> list = dis.get(ideas[i].charAt(0));
            list.add(ideas[i]);
            dis.put(ideas[i].charAt(0), list);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = ideas[i];
            char first = str.charAt(0);
            for (Map.Entry<Character, List<String>> entry : dis.entrySet()) {
                //List<String> list =
            }
        }


        return count;
    }
}
