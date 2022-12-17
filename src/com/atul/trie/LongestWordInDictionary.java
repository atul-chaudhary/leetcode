package com.atul.trie;


public class LongestWordInDictionary {
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println();
        System.out.println("ans " + longestWord(words));
    }

    static class Node {
        Node[] links = new Node[26];
        String word;

        Node get(char ch) {
            return links[ch - 'a'];
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
    }

    public static String longestWord(String[] words) {
        Node root = new Node();
        for (String it : words) {
            insert(root, it);
        }
        dfs(root);
        return result;
    }

    static String result = "";
    private static void dfs(Node root) {
        if(root == null) return;
        if(root.word != null) {
            if (root.word.length() > result.length()) {
                result = root.word;
            } else if (result.length() == root.word.length() && root.word.compareTo(result) < 0) {
                result = root.word;
            }
        }
        for (Node it : root.links){
            if(it != null && it.word != null){
                dfs(it);
            }
        }
    }

    private static void insert(Node root, String word) {
        Node node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.word = word;
    }
}
