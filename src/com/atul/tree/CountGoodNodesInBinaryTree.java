package com.atul.tree;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {

    }

    private int solve(TreeNode root, int max, int count){
        if(root == null) return count;

        if(root.val >= max) {
            max = root.val;
            count++;
        }
        solve(root.left, max, count);
        solve(root.right, max, count);
        return count;
    }
}
