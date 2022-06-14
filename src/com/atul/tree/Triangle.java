package com.atul.tree;

public class Triangle {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
       TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(5);

        node.right.left = node.left.right;

        node.right.right = new TreeNode(7);

        System.out.println(sum(node));
    }

    private  static int sum(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return Math.min(leftSum, rightSum) + root.val;
    }
}
