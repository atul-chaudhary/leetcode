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
        String[] words = {"havana"};
        String s = "tatiana";
        System.out.println(suggestedProducts(words, s));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        Arrays.sort(products);
        for (String it : products) {
            insert(it, root);
        }
        return solve(searchWord, root);
    }

    private static List<List<String>> solve(String word, Node root) {
        int n = word.length();
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String currentWord = word.substring(0, i);
            List<String> temp = new ArrayList<>();
            Node node = root;
            boolean flag = true;
            for (int j = 0; j < currentWord.length(); j++) {
                if (!node.containsKey(currentWord.charAt(j))) {
                    flag = false;
                    result.add(temp);
                    break;
                } else {
                    node = node.get(currentWord.charAt(j));
                }
            }
            if (flag) {
                int[] count = new int[1];
                count[0] = 3;
                //call dfs for getting the temp
                dfs(currentWord, node, count, temp);
                result.add(temp);
            }
        }
        return result;
    }

    private static void dfs(String word, Node root, int[] count, List<String> arr) {
        if (count[0] == 0) return;
        if (root.flag) {
            count[0]--;
            arr.add(word);
        }
        for (int i = 0; i < 26; i++) {
            if (root.links[i] != null) {
                char ch = (char) (i + 97);
                dfs(word + ch, root.links[i], count, arr);
            }
        }
    }

    private static void insert(String s, Node root) {
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
