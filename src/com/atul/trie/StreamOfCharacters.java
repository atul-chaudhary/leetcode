package com.atul.trie;

import java.util.ArrayList;
import java.util.List;

public class StreamOfCharacters {
    public static void main(String[] args) {

    }

    static class Node {
        Node[] links = new Node[26];
        boolean isEnd;

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }
    }

    class StreamChecker {
        Node root = new Node();
        List<Character> list = new ArrayList<>();
        public StreamChecker(String[] words) {
            int n = words.length;
            for (int i = 0; i < n; i++) {
                String word = words[i];
                insert(root, word);
            }
        }

        public void insert(Node root, String s) {
            Node node = root;
            int n = s.length();
            for (int i = n-1; i >= 0; i--) {
                if (!node.containsKey(s.charAt(i))) {
                    node.put(s.charAt(i), new Node());
                }
                node = node.get(s.charAt(i));
            }
            node.isEnd = true;
        }

        public boolean query(char letter) {
            list.add(letter);
            return search(root, list);
        }

        private boolean search(Node root, List<Character> list){
            Node node = root;
            int n = list.size();
            for (int i = n-1; i >= 0; i--) {
                if(!node.containsKey(list.get(i))){
                    return false;
                }
                node = node.get(list.get(i));
            }
            return true;
        }
    }
}
