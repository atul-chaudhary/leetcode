package com.atul.tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructStringfromBinaryTree {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        StringBuilder sb = new StringBuilder();
        tree2str(root, sb);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    public static void tree2str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append("(");
        sb.append(root.val);
        tree2str(root.left,sb);
        if (root.right != null)
            tree2str(root.right, sb);
        sb.append(")");
    }
}
