package com.atul.contest;

import java.util.*;

public class Contest_19_11_2023 {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(str, t));
    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        System.out.println(tmap);
        int result = Integer.MAX_VALUE;
        int first = 0;
        int last = 0;
        while (last < n - 1) {
            char ch = s.charAt(last);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            while (compare(sMap, tmap)) {
                char temp = s.charAt(first);
                if (sMap.containsKey(temp)) {
                    sMap.put(temp, sMap.get(temp) - 1);
                    if (sMap.get(temp) == 0) {
                        sMap.remove(temp);
                    }
                }
            }
            result = Math.min(last - first + 1, result);
            last++;
        }

        String resultv = "";
        for (int i = first; i < last; i++) {
            resultv += s.charAt(i);
        }
        return resultv;
    }

    private static boolean compare(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        boolean result = false;
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (smap.containsKey(key) && smap.get(key) != val) {
                return false;
            }
        }
        return true;
    }

    public static long minimumSteps(String s) {
        int n = s.length();
        char[] nums = s.toCharArray();
        int result = 0;
        int zero = n - 1;
        int one = n - 1;
        while (zero >= 0 && one >= 0) {
            while (zero >= 0 && nums[zero] != '0') {
                zero--;
            }
            System.out.println("<<>>" + zero);
            one = zero - 1;
            while (one >= 0 && nums[one] != '1') {
                one--;
            }

            if (zero >= 0)
                nums[zero] = '1';
            if (one >= 0)
                nums[one] = '0';
            if (one >= 0 && zero >= 0)
                result += (zero - one);
            //System.out.println(zero+"<<>>"+one);
            zero--;
        }
        return result;
    }
}
