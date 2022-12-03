package com.atul.trie;

public class ImplementTriell {
    public static void main(String[] args) {

    }

    class Trie {
        class Node {
            Node[] links = new Node[26];
            int endWith = 0;
            int countPrefix = 0;

            Node get(char ch) {
                return links[ch - 'a'];
            }

            void put(char ch, Node node) {
                links[ch - 'a'] = node;
            }

            boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

        }
        Node root = null;
        public Trie() {
            // Write your code here.
            root = new Node();
        }

        public void insert(String word) {
            // Write your code here.
            int n =  word.length();
            Node node = root;
            for (int i = 0; i < n; i++) {
                if(!node.containsKey(word.charAt(i))){
                    node.put(word.charAt(i), new Node());
                }
                node  = node.get(word.charAt(i));
                node.countPrefix++;
            }
            node.endWith++;
        }

        public int countWordsEqualTo(String word) {
            // Write your code here.
            int n = word.length();
            Node node  = root;
            for (int i = 0; i < n; i++) {
                node = node.get(word.charAt(i));
            }

            return node.endWith;
        }

        public int countWordsStartingWith(String word) {
            // Write your code here.
            int n = word.length();
            Node node  = root;
            for (int i = 0; i < n; i++) {
                node = node.get(word.charAt(i));
            }

            return node.countPrefix;
        }

        public void erase(String word) {
            // Write your code here.
        }
    }

}
