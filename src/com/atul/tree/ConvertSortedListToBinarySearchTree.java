package com.atul.tree;

import java.util.ArrayList;

public class ConvertSortedListToBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-10);
        arrayList.add(-3);
        arrayList.add(-0);
        arrayList.add(-5);
        arrayList.add(9);

        TreeNode root = solve(arrayList, 0, arrayList.size()-1);
        traverse(root);
    }

    public static void traverse(TreeNode root){
        if(root== null) return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    private static TreeNode solve(ArrayList<Integer> arr, int low, int high){

        if(low > high) return null;

        int mid = (low + high)/2;

        TreeNode node = new TreeNode(arr.get(mid));
        TreeNode left = solve(arr, low, mid-1);
        TreeNode right = solve(arr, mid+1, high);

        node.left = left;
        node.right = right;
        return node;

    }
}
