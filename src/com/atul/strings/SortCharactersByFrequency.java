package com.atul.strings;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
        String sb = "foobar";
        char ch = 'o';
        //System.out.println(percentageLetter(sb, ch));
    }

    public static int percentageLetter(String s, char letter) {
        int n = s.length();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == letter) count++;
        }
        System.out.println(count);
        return (count *100) /n;
    }

    static class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String frequencySort(String s) {
        //PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

//        map.forEach((k, v) -> {
//            pq.offer(new Pair(k, v));
//        });
        Pair[] nums = new Pair[map.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            nums[i++] = new Pair(entry.getKey(), entry.getValue());
        }
        Arrays.sort(nums, (a, b)-> b.freq-a.freq);
        StringBuilder sb = new StringBuilder();
//        while(!pq.isEmpty()){
//            Pair pair = pq.poll();
//            solve(sb, pair.ch, pair.freq);
//        }

        for (int j = 0; j < nums.length; j++) {
            solve(sb, nums[j].ch, nums[j].freq);
        }
        return sb.toString();
    }

    private static void solve(StringBuilder sb, char ch, int fre){
        for (int i = 0; i < fre; i++) {
            sb.append(ch);
        }
    }
}
