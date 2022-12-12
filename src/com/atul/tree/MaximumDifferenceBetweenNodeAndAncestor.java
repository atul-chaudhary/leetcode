package com.atul.tree;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(3);
        head.right = new TreeNode(10);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(6);
        head.left.right.left = new TreeNode(4);
        head.left.right.right = new TreeNode(7);

        System.out.println(maxAncestorDiff(head));
        System.out.println(num);
    }

    static int num = Integer.MIN_VALUE;
    public static int maxAncestorDiff(TreeNode root) {
        trav(root);
        return num;
    }

    public static void trav(TreeNode root) {
        if (root == null) return;
        num = Math.max(num, solve(root));
        trav(root.left);
        trav(root.right);
    }

    private static int solve(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        Integer left = null;
        if (root.left != null)
            left = solve(root.left);
        Integer right = null;
        if (root.right != null)
            right = solve(root.right);

        if(left == null) return Math.abs(root.val-right);
        else if(right == null) return Math.abs(root.val-left);
        else return Math.max(Math.abs(root.val - left), Math.abs(root.val - right));
    }
}
