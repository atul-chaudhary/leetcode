package com.atul.tree.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestBSTInBT {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);

        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(85);

        //System.out.println(count(root, new int[1])[0]);
        System.out.println(solve(root));
    }
    static int max = 0;
    public static int solve(TreeNode root) {
        if(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return count(root, new int[1])[0];
        }

        return Math.max(solve(root.left), solve(root.right));
    }
    public static int[] count(TreeNode root, int[] arr){
        if (root== null) return null;
        count(root.left, arr);
        arr[0]++;
        count(root.right, arr);
        return arr;
    }

    public static boolean checkBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

    public static List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) return null;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

        return list;
    }
}
