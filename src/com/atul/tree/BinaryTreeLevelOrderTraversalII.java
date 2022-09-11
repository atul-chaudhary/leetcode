package com.atul.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(levelOrderBottom(node));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()){
            int n = pq.size();
            List<Integer> temp = new ArrayList<>();
//            for(TreeNode node: pq){
//                temp.add(node.val);
//            }
            for(int i=0;i<n;i++){
                TreeNode node = pq.poll();
                temp.add(node.val);
                if(node.left != null){
                    pq.add(node.left);
                }
                if(node.right!= null){
                    pq.add(node.right);
                }
            }
            result.add(temp);
        }
        List<List<Integer>> finalResult = new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--){
            finalResult.add(result.get(i));
        }
        return finalResult;
     }
}
