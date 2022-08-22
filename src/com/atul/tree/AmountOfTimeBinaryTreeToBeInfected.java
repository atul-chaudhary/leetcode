package com.atul.tree;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AmountOfTimeBinaryTreeToBeInfected {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int data) {
            this.val = data;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParent(root, parentMap, 3);


        Queue<TreeNode> pq = new LinkedList<>();
        HashSet<TreeNode> seen = new HashSet<>();
        pq.add(node);
        seen.add(node);
        int count = -1;
        while(!pq.isEmpty()){
            int size = pq.size();
            System.out.println(size);
            System.out.println(pq);
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if(node.left != null && !seen.contains(node.left)){
                    pq.offer(node.left);
                    seen.add(node.left);
                }

                if(node.right != null && !seen.contains(node.right)){
                    pq.offer(node.right);
                    seen.add(node.right);
                }

                TreeNode parent = parentMap.get(node);
                if(parent != null && !seen.contains(parent)){
                    pq.offer(parent);
                    seen.add(parent);
                }
            }
            count++;
        }
        System.out.println("final ansser "+count);
    }

    static TreeNode node = null;
    private static void findParent(TreeNode root, HashMap<TreeNode, TreeNode> map, int star){
        if(root == null) return;
        if(root.val == star) node = root;
        if(root.left != null) map.put(root.left, root);
        findParent(root.left, map, star);
        if(root.right != null) map.put(root.right, root);
        findParent(root.right, map, star);
    }

}
