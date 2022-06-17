package com.atul.tree.BST;

import sun.reflect.generics.tree.Tree;

public class MaximumSumBSTInBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        System.out.println(maxSumBST(root));
    }

    public static int maxSumBST(TreeNode root) {
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return sum(root, new int[1])[0];
        }

        return Math.max(maxSumBST(root.left), maxSumBST(root.right));
    }

    public static int[] sum(TreeNode node, int[] arr){
        if(node == null) return null;
        sum(node.left, arr);
        arr[0]+=node.val;
        sum(node.right, arr);
        return arr;
    }

    public static boolean isBST(TreeNode root, int min, int max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return isBST(root.left, min, root.val) && isBST(root.right, root.val ,max);
    }

}
