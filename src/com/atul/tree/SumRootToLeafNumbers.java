package com.atul.tree;

import java.util.stream.Stream;

public class SumRootToLeafNumbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        solve(root, 0);
        return curSum;
    }

    static int curSum = 0;

    private static void solve(TreeNode root, int sum) {
        if (root == null) return;

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            curSum += sum;
            return;
        }

        solve(root.left, sum);
        solve(root.right, sum);
    }

    int total;
    public int sumNumbersOPT(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }

    void helper(TreeNode root, int sum) {
        if (root == null) return;

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }

}
