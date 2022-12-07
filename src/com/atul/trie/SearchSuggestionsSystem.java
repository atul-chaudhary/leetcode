package com.atul.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
    }

    public static void main(String[] args) {

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        Arrays.sort(products);
        for (String it : products) {
            insert(it, root);
        }
        return new ArrayList<>();
    }

    private List<String> startsWith(String s, Node root) {
        Node node = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (node.containsKey(s.charAt(i))) {
                node = node.get(s.charAt(i));
            } else {
                return new ArrayList<>();
            }
        }
        List<String> temp = new ArrayList<>();
        returnThree(node, temp, 3, 0, "");
        System.out.println(temp);
        return temp;
    }

    private void returnThree(Node root, List<String> list, int count, int curCount, String s) {
        if (count == curCount) return;
        if (root.flag) {
            list.add(s);
            curCount++;
        }

        for (int i = 0; i < 26; i++) {
            if (root.links[i] != null) {
                int num = i + 65;
                s += String.valueOf(num);
                returnThree(root.links[i], list, count, curCount, s);
            }
        }
    }

    private void insert(String s, Node root) {
        Node node = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!node.containsKey(s.charAt(i))) {
                node.put(s.charAt(i), new Node());
            }
            node = node.get(s.charAt(i));
        }
        node.flag = true;
    }
}
