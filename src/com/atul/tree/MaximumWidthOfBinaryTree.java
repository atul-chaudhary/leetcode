package com.atul.tree;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.isEmpty());
    }

    static class Node{
        TreeNode treeNode;
        int index;

        public Node(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> pq = new LinkedList<>();
        pq.offer(new Node(root, 0));
        int max = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            int lm = pq.peek().index;
            int rm = pq.peek().index;
            for (int i = 0; i < size; i++) {
                Node node = pq.poll();
                rm = node.index;

                if(node.treeNode.left != null) pq.offer(new Node(node.treeNode.left, 2* node.index+1));
                if(node.treeNode.right != null) pq.offer(new Node(node.treeNode.right, 2* node.index+2));
            }
            max = Math.max(max, rm-lm+1);
        }
        return max;
    }


}
