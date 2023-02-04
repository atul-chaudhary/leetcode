package com.atul.unkown;

import java.util.*;

public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int num = 3;
        System.out.println(convert(str, num));
    }


    public static String convert(String s, int numRows) {
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, "");
        }
        int len = s.length();
        int curLen = 0;
        while (curLen < len) {
            int incr = 0;
            while (incr < numRows && curLen < len) {
                String str = map.get(incr);
                str += s.charAt(curLen);
                map.put(incr, str);
                curLen++;
                incr++;
            }
            int dec = numRows - 2;
            while (dec >= 1 && curLen < len) {
                String str = map.get(dec);
                str += s.charAt(curLen);
                map.put(dec, str);
                curLen++;
                dec--;
            }
        }

        String result = "";
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result += entry.getValue();
        }
        return result;
    }

    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int it : set) {
            map.put(it, count++);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }

    public static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        Arrays.sort(g);
        Queue<Integer> pq = new PriorityQueue<>();
        for (int it : s) {
            pq.offer(it);
        }
        int count = 0;
        int index = 0;
        while (index < n && !pq.isEmpty()) {
            while (!pq.isEmpty()) {
                int nun = pq.poll();
                if (g[index] <= nun) {
                    count++;
                    break;
                }
            }
            index++;
        }
        return count;
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }
        int n = words.length;
        String[] copy = new String[n];
        int i = 0;
        for (String s : words) {
            copy[i++] = s;
        }
        Arrays.sort(copy, (a, b) -> compareTo(a, b, map));
        for (int j = 0; j < n; j++) {
            if (!copy[j].equals(words[j])) {
                return false;
            }
        }
        return true;
    }

    private static int compareTo(String a, String b, Map<Character, Integer> map) {
        if (a.equals(b)) return 0;
        int len1 = a.length();
        int len2 = b.length();
        int min = Math.min(len1, len2);
        int k = 0;
        while (k < min) {
            char ch1 = a.charAt(k);
            char ch2 = b.charAt(k);
            int post1 = map.get(ch1);
            int post2 = map.get(ch2);
            if (ch1 != ch2) {
                return post1 - post2;
            }
            k++;
        }
        return len1 - len2;
    }
}
