package com.atul.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(isCompleteTree(root));
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int va) {
            this.val = va;
        }
    }

    static class TreeFuckNode {
        TreeNode treeNode;
        boolean leftOrRight;

        public TreeFuckNode(TreeNode treeNode, boolean leftOrRight) {
            this.treeNode = treeNode;
            this.leftOrRight = leftOrRight;
        }
    }


    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeFuckNode> pq = new LinkedList<>();
        pq.offer(new TreeFuckNode(root, false));

        boolean isLastRow = false;
        Boolean last = null;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                TreeFuckNode node = pq.poll();
                if (isLastRow) {
                    if(last == null && (node.leftOrRight || !node.leftOrRight)){
                        return false;
                    }
                    if (last == node.leftOrRight) {
                        return false;
                    } else {
                        last = node.leftOrRight;
                    }
                }
                if (node.treeNode.left != null) {
                    pq.offer(new TreeFuckNode(node.treeNode.left, false));
                } else {
                    isLastRow = true;
                }

                if (node.treeNode.right != null) {
                    pq.offer(new TreeFuckNode(node.treeNode.right, true));
                }
            }
        }
        return true;
    }
}
