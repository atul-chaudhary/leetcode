package com.atul.trie;

import java.util.Arrays;

public class ShortEncodingOfWords {
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }

    static class Node{
        Node[] links = new Node[26];
        boolean isEnd;

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }

        boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }

        Node get(char ch){
            return links[ch-'a'];
        }
    }

    public static int minimumLengthEncoding(String[] words) {
        Node root = new Node();
        Arrays.sort(words, (a, b)->b.length()-a.length());
        int count = 0;
        for (String it : words){
            if(!insert(it, root)){
                count+=it.length()+1;
            }
        }
        return count;
    }

    private static boolean insert(String s, Node root){
        int n = s.length();
        Node node = root;
        boolean flag = true;
        for (int i = n-1; i>=0; i--) {
            if(!node.containsKey(s.charAt(i))){
                flag = false;
                node.put(s.charAt(i), new Node());
            }
            node = node.get(s.charAt(i));
        }
        return flag;
    }
}
