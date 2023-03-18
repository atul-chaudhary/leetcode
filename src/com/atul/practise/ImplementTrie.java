package com.atul.practise;


public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("app"));
    }

    static class Trie {
        Node node;

        public Trie() {
            node = new Node();
        }

        public void insert(String word) {
            int n = word.length();
            Node temp = node;
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!temp.isPresent(ch)) {
                    temp.put(ch, new Node());
                }

                temp = temp.get(ch);
            }
            temp.isEnd = true;
        }

        public boolean search(String word) {
            int n = word.length();
            Node temp = node;
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!temp.isPresent(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }

            if (temp.isEnd) {
                return true;
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            Node temp = node;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char ch = prefix.charAt(i);
                if (!temp.isPresent(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }
            return true;
        }
    }

    static class Node {
        Node[] list = new Node[26];
        boolean isEnd = false;

        Node get(char ch) {
            return list[ch - 'a'];
        }

        boolean isPresent(char ch) {
            return list[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            list[ch - 'a'] = node;
        }
    }
}
