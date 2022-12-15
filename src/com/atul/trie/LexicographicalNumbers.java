package com.atul.trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }

    static class Node {
        Node[] links = new Node[10];
        boolean isEnd;
        int num;

        boolean containsKey(int it) {
            return links[it] != null;
        }

        void put(int it, Node node) {
            links[it] = node;
        }

        Node get(int it) {
            return links[it];
        }
    }

    public static List<Integer> lexicalOrder(int n) {
        Node root = new Node();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            insert(i, root);
        }
        dfs(result, root);
        return result;
    }

    private static void dfs(List<Integer> result, Node root) {
        if (root.isEnd) {
            result.add(root.num);
        }
        for (Node it : root.links) {
            if (it != null) {
                dfs(result, it);
            }
        }
    }

    private static void insert(int it, Node root) {
        String s = String.valueOf(it);
        int n = s.length();
        Node node = root;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (!node.containsKey(num)) {
                node.put(num, new Node());
            }
            node = node.get(num);
        }
        node.isEnd = true;
        node.num = it;
    }
}
