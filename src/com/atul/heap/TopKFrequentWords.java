package com.atul.heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words,2));
    }

    static class Pair{
        String val;
        Integer freq;
        public Pair(String val, Integer freq){
            this.val = val;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val='" + val + '\'' +
                    ", freq=" + freq +
                    '}';
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        //System.out.println(map);
        Queue<Pair> pq = new PriorityQueue<>((a, b)-> a.freq.compareTo(b.freq));

        for(String i : map.keySet()){
            int freq = map.get(i);
            pq.offer(new Pair(i,freq));

            if(pq.size() > k){
                pq.poll();
            }
        }
        //System.out.println(pq);
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll().val);
        }
        Collections.sort(list);
        return list;
    }
}
