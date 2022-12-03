package com.atul.trie;

import java.util.Arrays;

public class LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        String[] s = {"n", "l", "i", "um", "ar", "xcfyc"};//{"ab","abc", "a", "bp"};//{"n", "ni", "nin", "ninj", "ninja"};
        System.out.println(completeString(s.length, s));
        System.out.println("i".compareTo("n"));
    }

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        Node get(char ch) {
            return links[ch - 'a'];
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "links=" + Arrays.toString(links) +
                    ", flag=" + flag +
                    '}';
        }
    }

    public static String completeString(int n, String[] a) {
        // Write your code here.
        Node root = new Node();
        Node node = root;
        for (String s : a) {
            insert(node, s);
        }
        String result = null;
        for (String s : a) {
            Node main = root;
            if (check(main, s)) {
                if (result == null || result.length() < s.length()) {
                    result = s;
                } else if (result.length() == s.length()) {
                    result = compare(result, s);
                }
            }
        }

        return result == null ? "None" : result;
    }

    private static String compare(String s1, String s2) {
        String result = null;
        int retval = s1.compareTo(s2);
        if (retval < 0) {
            result = s1;
        } else if (retval == 0) {
            result = s1;
        } else {
            result = s2;
        }
        return result;
    }

    private static boolean check(Node root, String s) {
        int n = s.length();
        Node node = root;
        for (int i = 0; i < n; i++) {
            if (node.containsKey(s.charAt(i))) {
                node = node.get(s.charAt(i));
                if (!node.flag) {
                    return false;
                }
            } else return false;
        }
        return true;
    }

    public boolean search(String word, Node curr) {
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(c == '.'){
                for(Node ch: curr.links)
                    if(ch != null && search(word.substring(i+1), ch)) return true;
                return false;
            }
            if(!curr.containsKey(c)) return false;
            curr = curr.get(c);
        }
        return curr != null && curr.flag;
    }

    private static void insert(Node root, String s) {
        int n = s.length();
        Node node = root;
        for (int i = 0; i < n; i++) {
            if (!node.containsKey(s.charAt(i))) {
                node.put(s.charAt(i), new Node());
            }
            node = node.get(s.charAt(i));
        }
        node.flag = true;
    }
}
