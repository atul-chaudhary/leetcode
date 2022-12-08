package com.atul.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafSimilarTrees {
    static class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right  = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.right = new TreeNode(2);
        tree2.left  = new TreeNode(3);

        System.out.println(leafSimilar(tree1, tree2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        solve(root1, tree1);
        solve(root2, tree2);
        if(tree1.size() != tree2.size()) return false;
        for (int i = 0; i < tree1.size(); i++) {
            if(!tree1.get(i).equals(tree2.get(i))) return false;
        }
        return true;
    }

    private static void solve(TreeNode root, List<Integer> nums){
        if(root.left == null && root.right == null){
            nums.add(root.val);
            return;
        }
        if(root.left != null)
        solve(root.left, nums);
        if (root.right != null)
        solve(root.right, nums);
    }
}
