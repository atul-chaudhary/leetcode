package com.atul.leetcodedaily;

public class Practise07_07_2025 {
    public static void main(String[] args) {

    }

    class Node {
        Node[] nodes = new Node[26];
        int countPref = 0;
        int countEnds = 0;

        Node() {
        }

        public boolean containskey(char ch) {
            return nodes[ch - 'a'] != null;
        }

        public void insert(char ch, Node node) {
            nodes[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return nodes[ch - 'a'];
        }
    }

    public String longestValidWord(String[] words) {
        // code here
        Node root = new Node();
        for (String it : words) {
            Node node = root;
            int n = it.length();
            for (int i = 0; i < n; i++) {
                char ch = it.charAt(i);
                if (!node.containskey(ch)) {
                    node.insert(ch, new Node());
                }
                node = node.get(ch);
                node.countPref++;
            }
            node.countEnds++;
        }

        return "";
    }

    public class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            // Write your code here.
            Node node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!node.containskey(ch)) {
                    node.insert(ch, new Node());
                }
                node = node.get(ch);
                node.countPref++;
            }
            node.countEnds++;
        }

        public int countWordsEqualTo(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.get(ch);
            }
            return node.countEnds;
        }

        public int countWordsStartingWith(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.get(ch);
            }
            return node.countPref;
        }

        public void erase(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.get(ch);
                node.countPref--;
            }
            node.countEnds--;
        }
    }
}
