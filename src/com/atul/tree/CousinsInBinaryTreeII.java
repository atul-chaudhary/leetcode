package com.atul.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsInBinaryTreeII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);

        root.right.right = new TreeNode(7);

        TreeNode result = replaceValueInTree(root);
        trav(result);
    }

    private static void trav(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);

        while (!pq.isEmpty()) {
            int size = pq.size();
            List<Integer> vals = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                vals.add(node.val);
                if (node.left != null) {
                    pq.offer(node.left);
                }
                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            System.out.println(vals);
        }
    }

    public static TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> vals = solve(root);
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        int level = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if (level == 0) {
                    if (node.left != null) {
                        pq.offer(node.left);
                    }
                    if (node.right != null) {
                        pq.offer(node.right);
                    }
                } else {
                    int cur = 0;
                    if (node.left != null) {
                        cur += node.left.val;
                        pq.offer(node.left);
                    }
                    if (node.right != null) {
                        cur += node.right.val;
                        pq.offer(node.right);
                    }

                    if (node.left != null) {
                        node.left.val = vals.get(level) - cur;
                    }
                    if (node.right != null) {
                        node.right.val = vals.get(level) - cur;
                    }
                }
            }
        }
        root.val = 0;
        return root;
    }

    private static List<Integer> solve(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (!pq.isEmpty()) {
            int size = pq.size();
            int cur = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                cur += node.val;

                if (node.left != null) {
                    pq.offer(node.left);
                }
                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            result.add(cur);
        }
        return result;
    }
}
