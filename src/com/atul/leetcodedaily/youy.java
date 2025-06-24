package com.atul.leetcodedaily;

import java.util.*;

public class youy {
    public static void main(String[] args) {

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return false;
        int height = bal(root);
        return flag;
    }

    static boolean flag = true;
    private static int bal(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = bal(root.left);
        int right = bal(root.right);
        if(Math.abs(left-right) > 1) flag = false;
        return 1+ Math.max(left, right);
    }
}

