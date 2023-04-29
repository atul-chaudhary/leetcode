package com.atul.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {

    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        int level = 0;
        int max = Integer.MIN_VALUE;
        int ansLevel = -1;
        while (!pq.isEmpty()) {
            int size = pq.size();
            level++;
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
            if (cur > max) {
                max = cur;
                ansLevel = level;
            }
        }
        return ansLevel;
    }
}
