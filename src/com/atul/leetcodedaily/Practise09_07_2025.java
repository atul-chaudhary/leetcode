package com.atul.leetcodedaily;

import java.util.*;

public class Practise09_07_2025 {
    public static void main(String[] args) {

    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node root = node;
        Map<Node, Node> map = new HashMap<>();
        solve(node, new HashMap<>(), map);
        return map.get(root);
    }

    private static void solve(Node node, Map<Node, Boolean> map, Map<Node, Node> corr) {
        map.put(node, true);
        Node newN = new Node(node.val);
        corr.put(node, newN);
        for (Node it : node.neighbors) {
            if (!map.containsKey(it)) {
                solve(it, map, corr);
                newN.neighbors.add(corr.get(it));
            }
        }
    }
}
