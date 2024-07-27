package com.atul.contest;

import com.atul.trie.StreamOfCharacters;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Contest09_07_2024 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(getDirections(root, 3, 6));
    }

    static class Tuple {
        TreeNode node;
        String val;

        public Tuple(TreeNode node, String val) {
            this.node = node;
            this.val = val;
        }
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        Map<Integer, TreeNode> map = new HashMap<>();
        trav(root, map, null, startValue, destValue);
        Set<Integer> set = new HashSet<>();
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(start, ""));
        set.add(start.val);
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Tuple temp = pq.poll();
                TreeNode node = temp.node;
                String cur = temp.val;
                if (node.val == destValue) {
                    return cur;
                }
                if (map.get(node.val) != null && !set.contains(map.get(node.val).val)) {
                    pq.offer(new Tuple(map.get(node.val), cur + "U"));
                }
                if (node.left != null && !set.contains(node.left.val)) {
                    pq.offer(new Tuple(node.left, cur + "L"));
                }
                if (node.right != null && !set.contains(node.right.val)) {
                    pq.offer(new Tuple(node.right, cur + "R"));
                }
            }
        }
        return "";
    }

    static TreeNode start = null;
    static TreeNode end = null;

    private static void trav(TreeNode root, Map<Integer, TreeNode> map, TreeNode parent, int startVal, int endVal) {
        if (root == null) {
            return;
        }

        if (root.val == startVal) {
            start = root;
        }
        if (root.val == endVal) {
            end = root;
        }
        map.put(root.val, parent);
        trav(root.left, map, root, startVal, endVal);
        trav(root.right, map, root, startVal, endVal);
    }

    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        trav(root, map, parentMap, -1);
        Set<Integer> set = new HashSet<>();
        set.add(root.val);
        for (int it : to_delete) {
            TreeNode node = map.get(it);
            if (parentMap.get(it) != -1) {
                TreeNode parent = map.get(parentMap.get(it));
                if (parent != null && parent.left != null && parent.left.val == it) {
                    parent.left = null;
                } else if (parent != null && parent.right != null && parent.right.val == it) {
                    parent.right = null;
                }
            }
            if (node.right != null)
                set.add(node.right.val);
            if (node.left != null)
                set.add(node.left.val);
            node.right = null;
            node.left = null;
            set.remove(it);
        }
        List<TreeNode> result = new ArrayList<>();
        for (int it : set) {
            result.add(map.get(it));
        }
        return result;
    }

    private static void trav(TreeNode root, Map<Integer, TreeNode> map, Map<Integer, Integer> parentMap, int par) {
        if (root == null) {
            return;
        }
        map.put(root.val, root);
        parentMap.put(root.val, par);
        trav(root.left, map, parentMap, root.val);
        trav(root.right, map, parentMap, root.val);
    }

    static class MyNode {
        int key;
        MyNode left;
        MyNode right;
        MyNode parent;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int[] it : descriptions) {
            int parent = it[0];
            int child = it[1];
            int dir = it[2];
            parentMap.put(child, parent);
            parentMap.putIfAbsent(parent, -1);
            TreeNode parentNode = null;
            TreeNode childNode = null;
            if (map.containsKey(parent)) {
                parentNode = map.get(parent);
            } else {
                parentNode = new TreeNode(parent);
                map.put(parent, parentNode);
            }

            if (map.containsKey(child)) {
                childNode = map.get(child);
            } else {
                childNode = new TreeNode(child);
                map.put(child, childNode);
            }
            if (dir == 1) parentNode.left = childNode;
            else parentNode.right = childNode;
        }

        for (Map.Entry<Integer, Integer> entry : parentMap.entrySet()) {
            int val = entry.getValue();
            int key = entry.getKey();
            if (val == -1) {
                return map.get(key);
            }
        }

        return null;
    }
}
