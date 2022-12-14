package com.atul.trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {
        String[] arr = {"cat","bat","rat"};
        String sen = "the cattle was rattled by the battery";
        System.out.println(replaceWords(Arrays.asList(arr), sen));
    }
    //"a aa a aaaa aaa aaa aaa aaaa bbb baba a" min
    //"a a a a a a a a bbb baba a"  correct
    //a a a a a a a a bbb baba a

    static class Node{
        Node[] links = new Node[26];
        boolean isEnd;
        String word;

        boolean containsKey(char ch){
            return links[ch-'a']!= null;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
    }
    static class Pair{
        boolean isEnd;
        String word;

        public Pair(boolean isEnd, String word) {
            this.isEnd = isEnd;
            this.word = word;
        }
    }
    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] arr = sentence.split(" ");
        Node root = new Node();

        for (String it : dictionary){
            insert(it, root);
        }

        for (int i = 0; i < arr.length; i++) {
            Pair pair = search(arr[i], root);
            if(pair.isEnd && pair.word.length() < arr[i].length()){
                arr[i] = pair.word;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length-1){
                sb.append(arr[i]).append(" ");
            }else sb.append(arr[i]);
        }
        return sb.toString();
    }


    public static Pair search(String s, Node root){

        Node node = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(!node.containsKey(s.charAt(i))){
                if(node.isEnd) return new Pair(true, node.word);
                return new Pair(false, null);
            }
            node = node.get(s.charAt(i));
            if(node.isEnd) return new Pair(true, node.word);
        }
        return new Pair(false, null);
    }

    private static void insert(String s, Node root){
        Node node = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(!node.containsKey(s.charAt(i))){
                node.put(s.charAt(i), new Node());
            }

            node = node.get(s.charAt(i));
        }
        node.isEnd = true;
        node.word = s;
    }
}

