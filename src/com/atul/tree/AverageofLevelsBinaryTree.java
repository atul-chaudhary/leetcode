package com.atul.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(15);
        System.out.println(solve(root));
    }

    private  static List<Double> solve(TreeNode root){
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        ArrayList<Double> result = new ArrayList<>();
        result.add((double)root.val);
        while(!pq.isEmpty()){
            int size = pq.size();
            TreeNode node = pq.poll();
            //result.add(node.val);
            int sum = 0;
            int count = 0;
            for(int i=0;i<size;i++){
                if(node.left != null){
                    sum+=node.left.val;
                    count++;
                    pq.add(node.left);
                }
                if(node.right != null){
                    sum+=node.right.val;
                    count++;
                    pq.add(node.right);
                }
            }
            if(count != 0)
                //System.out.println(String.format("%.5f", sum*1.0/count));
                result.add(Double.parseDouble(String.format("%.5f", sum*1.00000/count)));
        }
        System.out.println(result);
        return new ArrayList<>();
    }
}
