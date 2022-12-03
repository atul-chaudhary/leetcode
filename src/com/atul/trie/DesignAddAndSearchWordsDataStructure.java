package com.atul.trie;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure d = new DesignAddAndSearchWordsDataStructure();
        d.addWord("a");
        d.addWord("a");
        //d.addWord("mad");
        //System.out.println(d.search("."));
        System.out.println(d.search(".a"));
        //System.out.println(d.search("a."));
    }

    static class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean flag = false;

        Node get(char ch) {
            return map.get(ch);
        }

        boolean contains(char ch) {
            return map.containsKey(ch);
        }

        void put(char ch, Node node) {
            map.put(ch, node);
        }

    }

    Node root = null;

    public DesignAddAndSearchWordsDataStructure() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        insert(node, word);
    }

    public boolean search(String word) {
        System.out.println("wo " + word);
        int n = word.length();
        Node node = root;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == '.') {
                Map<Character, Node> temp = node.map;
                for (Map.Entry<Character, Node> entry : temp.entrySet()) {
                    String formed = word.substring(i + 1);
                    if (search(formed) == true) return true;
                    return false;
                }
            } else if (node.contains(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return node != null && node.flag;
    }

    private static void insert(Node root, String s) {
        int n = s.length();
        Node node = root;
        for (int i = 0; i < n; i++) {
            if (!node.contains(s.charAt(i))) {
                node.put(s.charAt(i), new Node());
            }
            node = node.get(s.charAt(i));
        }
        node.flag = true;
    }
}
