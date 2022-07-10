package com.atul.contest;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class EvaluateBooleanBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[12];
        PriorityQueue<Integer> process = new PriorityQueue<>();
        process.poll();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root) {
        if (root.val == 0 || root.val == 1) {
            return false;
        }

        return inorder(root);
    }

    private static boolean inorder(TreeNode node) {
        if (node.left == null || node.right == null) {
            return node.val != 0;
        }

        boolean left = inorder(node.left);
        boolean right = inorder(node.right);

        if(node.val == 2){
            return left || right;
        }else{
            return left && right;
        }
    }
}
