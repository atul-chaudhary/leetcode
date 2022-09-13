package com.atul.tree;

public class SumOfRootToLeafBinaryNumbers {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        //solve(root, 0);
        //System.out.println(num);
        solve(root.left, root.right);
        trav(root);
    }

    private static void trav(TreeNode root){
        if(root == null) return;

        System.out.println(root.val);
        trav(root.left);
        trav(root.right);
    }

    private static void solve(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null) return;

        int temp = root1.val;
        root1.val = root2.val;
        root2.val = temp;
        solve(root1.left, root2.right);
        solve(root1.right, root2.left);
    }

    static int num = 0;
    private static void solve(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum = (2 * sum) + root.val;
            num += sum;
            return;
        }
        sum = (2 * sum) + root.val;
        solve(root.left, sum);
        solve(root.right, sum);
    }
}
