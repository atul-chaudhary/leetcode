package com.atul.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddOneRowToTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        TreeNode result = addOneRow(root, 1, 2);
    }


    static class TreeNode {
        TreeNode left, right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val);
        int cur = 1;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (!pq.isEmpty()) {
            int size = pq.size();
            cur++;
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if (cur == depth) {
                    TreeNode tempLeft = node.left;
                    TreeNode tempRight = node.right;
                    TreeNode newNodeLeft = new TreeNode(val);
                    TreeNode newNodeRight = new TreeNode(val);
                    node.left = newNodeLeft;
                    node.right = newNodeRight;
                    newNodeLeft.left = tempLeft;
                    newNodeRight.right = tempRight;
                }

                if (node.left != null) {
                    pq.offer(node.left);
                }

                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
        }
        return root;
    }
}
