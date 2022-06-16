package com.atul.tree.BST;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(kthSmallest(root,2));
    }

    public  static int kthSmallest(TreeNode root, int k) {
        List<Integer> result = inorder(new ArrayList<>(), root);
        System.out.println(result);
        return result.get(k-1);
    }

    private int kthElement(TreeNode root, int k){
        if(k==0){
            return root.val;
        }

        return 0;
    }

    private static List<Integer> inorder(List<Integer> arr,TreeNode root){
        if(root == null){
            return arr;
        }

        inorder(arr, root.left);
        arr.add(root.val);
        inorder(arr, root.right);

        return arr;
    }
}
