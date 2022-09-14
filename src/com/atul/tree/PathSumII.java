package com.atul.tree;

import java.util.*;

public class PathSumII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        List<List<Integer>> result = new ArrayList<>();
        solve(root, 22, result, new LinkedList<>());
        System.out.println(result);
    }


    private static void solve(TreeNode root, int target, List<List<Integer>> result, LinkedList<Integer> cur) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(cur));
        }
        solve(root.left, target, result, cur);
        solve(root.right, target, result, cur);
        cur.removeLast();
    }

    /*public Node connect(Node root) {
        if (root == null) return null;
        solve(root, result);
        return root;
    }

    private void solve(Node root) {
        Queue<Node> pq = new LinkedList<>();
        pq.add(root);
        while (!pq.isEmpty()) {
            int n = pq.size();
            List<Node> temp = new ArrayList<>();
            Node prev = null;
            for (int i = 0; i < n; i++) {
                Node node = pq.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null) pq.add(node.left);
                if (node.right != null) pq.add(node.right);

            }
        }
    }*/

}
