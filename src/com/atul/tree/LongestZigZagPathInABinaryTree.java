package com.atul.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LongestZigZagPathInABinaryTree {
    public static void main(String[] args) {

    }

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (!pq.isEmpty()) {
            TreeNode node = pq.poll();
            max = Math.max(max, Math.max(solve(node.left, false), solve(node.right, true)));
            if (node.left != null) {
                pq.offer(node.left);
            }
            if (node.right != null) {
                pq.offer(node.right);
            }
        }

        return max;
    }

    //prev - true -  left, false-> right
    static class Pair {
        TreeNode node;
        boolean prev;

        public Pair(TreeNode node, boolean prev) {
            this.node = node;
            this.prev = prev;
        }
    }

    private static int solve(TreeNode root, boolean prev) {
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(root, prev));
        int count = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            TreeNode node = pair.node;
            boolean prevTemp = pair.prev;
            count++;
            if (prev) {
                if (node.right != null) {
                    pq.offer(new Pair(node.right, !prevTemp));
                }
            } else {
                if (node.left != null) {
                    pq.offer(new Pair(node.left, !prevTemp));
                }
            }
        }
        return count;
    }
}
