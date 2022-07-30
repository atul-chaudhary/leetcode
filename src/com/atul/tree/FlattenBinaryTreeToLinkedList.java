package com.atul.tree;

import com.atul.tree.BST.CeilInBinarySearchTree;

import java.util.ArrayList;

public class FlattenBinaryTreeToLinkedList {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);

        ArrayList<TreeNode> result = new ArrayList<>();
        solve(head, result);
        System.out.println(result);

        TreeNode dummy = result.get(0);
        TreeNode temp = dummy;
        dummy.left = null;
        for(int i=1;i<result.size();i++){
            dummy.right = result.get(i);
            dummy.left =  null;
            dummy = dummy.right;
        }

        trav(temp);
    }

    public static void trav(TreeNode root){
        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }

    private static void solve(TreeNode root, ArrayList<TreeNode> result){
        if(root == null){
            return;
        }
        result.add(root);
        solve(root.left, result);
        solve(root.right, result);
    }
}
