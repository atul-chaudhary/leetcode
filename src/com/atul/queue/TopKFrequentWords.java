package com.atul.queue;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
       String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words, 4));
    }

    static class Pair{
        int freq;
        String word;

        public Pair(int freq, String word) {
            this.freq = freq;
            this.word = word;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "freq=" + freq +
                    ", word='" + word + '\'' +
                    '}';
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        Queue<Pair> pq = new PriorityQueue<>((a, b)-> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq-b.freq);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
            if(pq.size() > k){
                pq.poll();
            }
        }
        //System.out.println(pq);
        ArrayList<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().word);
        }
        Collections.reverse(result);
        return result;
    }

}
