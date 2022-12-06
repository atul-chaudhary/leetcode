package com.atul.trie;

public class NumberOfDistinctSubstringsInASString {
    public static void main(String[] args) {
        String  s = "sds";
        //System.out.println(countDistinctSubstrings(s));
        int n = 8;
        System.out.println(Integer.toBinaryString(n));
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
    }

    public static int countDistinctSubstrings(String s) {
        Node root = new Node();
        Node node = root;
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                for (int k = 0; k < sb.length(); k++) {
                    if(!node.containsKey(sb.charAt(k))){
                        node.put(sb.charAt(k), new Node());
                        count++;
                    }
                    node = node.get(sb.charAt(k));
                }
                node.flag = true;
                node = root;
            }
        }
        return count;
    }
}
