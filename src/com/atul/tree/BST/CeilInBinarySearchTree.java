package com.atul.tree.BST;

public class CeilInBinarySearchTree {
    static int ceil = -1;

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(13);
        node.right.left = new TreeNode(11);
        node.right.right = new TreeNode(14);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(6);
        node.left.right.right = new TreeNode(9);

        node.left.left.left = new TreeNode(2);
        node.left.left.right = new TreeNode(4);

        TreeNode temp = helper(node, 12);
        System.out.println(temp);

        System.out.println(ceil);
    }

    private static TreeNode helper(TreeNode root, int val ){
        int cur = -1;
        while(root != null && val != root.val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
