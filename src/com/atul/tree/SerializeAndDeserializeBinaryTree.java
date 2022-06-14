package com.atul.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }




    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);

        System.out.println(serializePreorder(node));
    }

    public static String serializePreorder(TreeNode root) {
        if(root == null) return "x";

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val+ ","+left+right;
    }

    public  static String serialize(TreeNode root) {

        Queue<TreeNode> process = new LinkedList<>();
        process.offer(root);
        StringBuilder result = new StringBuilder();
        result.append(root.val+ " ");
        while(!process.isEmpty()){
            int size = process.size();
            //System.out.println(size+ " >>");
            for(int i=0; i< size;i++) {
                TreeNode node = process.poll();
                if (node.left == null) {
                    result.append("# ");
                } else {
                    result.append(node.left.val).append(" ");
                    process.offer(node.left);
                }

                if (node.right == null) {
                    result.append("# ");
                } else {
                    result.append(node.right.val).append(" ");
                    process.offer(node.right);
                }
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
