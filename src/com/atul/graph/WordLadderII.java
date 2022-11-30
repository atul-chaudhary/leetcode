package com.atul.graph;

import sun.usagetracker.UsageTrackerClient;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] wor = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> fuckers = Arrays.asList(wor);
        System.out.println(fuckers);
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders(begin, end, words));
    }

        public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Set<String> set = new HashSet<>();
        for (String it : wordList) {
            set.add(it);
        }

        Queue<List<String>> pq = new LinkedList<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);

        //ans array
        List<List<String>> result = new ArrayList<>();
        //used functionality
        int level = 0;
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        pq.offer(temp);
        while (!pq.isEmpty()) {
            List<String> node = pq.poll();
            System.out.println("nodes "+node.toString());
            //for erasing the words
            if (node.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    set.remove(it);
                }
                usedOnLevel.clear();
            }

            //for creating the ans
            String word = node.get(node.size() - 1);
            if (word.equals(endWord)) {
                result.add(new ArrayList<>(node));
            }

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String formedWord = new String(arr);
                    if (set.contains(formedWord)) {
                        node.add(formedWord);
                        pq.offer(new ArrayList<>(node));

                        usedOnLevel.add(formedWord);
                        node.remove(node.size() - 1);
                    }
                }
            }
        }
        return result;
    }
}
