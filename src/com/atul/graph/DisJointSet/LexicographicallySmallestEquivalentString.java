package com.atul.graph.DisJointSet;

import sun.util.resources.LocaleData;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {
        String s1 = "2019-06-29";
        String s2 = "2019-06-30";
        System.out.println(daysBetweenDates(s1, s2));
    }

    public static int daysBetweenDates(String date1, String date2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d1 = LocalDate.parse(date1, dtf);
        LocalDate d2 = LocalDate.parse(date2, dtf);
        return (int) Duration.between(d1, d2).toDays();
    }

    static class DisJointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisJointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        int findUP(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int up = findUP(parent.get(node));
            parent.set(node, up);
            return up;
        }

        void unionBySize(int u, int v) {
            int pu = findUP(u);
            int pv = findUP(v);
            if (pv == pu) return;
            if (pu < pv) parent.set(pv, pu);
            else parent.set(pu, pv);
        }
    }

    public static String smallestEquivalentStringOpt(String s1, String s2, String baseStr) {
        DisJointSet ds = new DisJointSet(26);
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            ds.unionBySize(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        int m = baseStr.length();
        for (int i = 0; i < m; i++) {
            sb.append((char) (ds.findUP(baseStr.charAt(i) - 'a') + 'a'));
        }
        return sb.toString();
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        Map<Character, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (map.containsKey(ch1)) {
                PriorityQueue<Character> pq = map.get(ch1);
                if (!pq.contains(ch1)) {
                    pq.offer(ch1);
                }
                if (!pq.contains(ch2)) {
                    pq.offer(ch2);
                }

                map.put(ch1, pq);
                map.put(ch2, pq);
            } else if (map.containsKey(ch2)) {
                PriorityQueue<Character> pq = map.get(ch2);
                if (!pq.contains(ch1)) {
                    pq.offer(ch1);
                }
                if (!pq.contains(ch2)) {
                    pq.offer(ch2);
                }

                map.put(ch1, pq);
                map.put(ch2, pq);

            } else {
                PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
                if (!pq.contains(ch1)) {
                    pq.offer(ch1);
                }
                if (!pq.contains(ch2)) {
                    pq.offer(ch2);
                }
                map.put(ch1, pq);
                map.put(ch2, pq);
            }
        }
        System.out.println(map);
        String result = "";
        for (int i = 0; i < baseStr.length(); i++) {
            char ch = baseStr.charAt(i);
            if (map.containsKey(ch)) {
                result += map.get(ch).peek();
            } else {
                result += ch;
            }
        }
        return result;
    }
}
