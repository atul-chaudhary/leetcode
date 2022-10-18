package com.atul.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ExecutorService;

public class LargestPositiveIntegerThatExistsWithNegative {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);



//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(0);
//        root.left.left = new TreeNode(0);
//
//        root.right = new TreeNode(0);
//        root.right.right = new TreeNode(0);
//        root.right.right.right = new TreeNode(0);
        System.out.println(InorderTrav(root));
        System.out.println(checker(root));

    }
    public final static List<TreeNode> checker(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                String str = InorderTrav(node);
                if (map.get(str) != null && map.get(str) == 1) {
                    result.add(node);
                }

                map.put(str, map.getOrDefault(str, 0)+1);

                if (node.left != null) {
                    pq.offer(node.left);
                }

                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
        }
        return result;
    }



    private static String InorderTrav(TreeNode node) {
        if (node == null) {
            return null;
        }

        String inorder = "";
        String left = InorderTrav(node.left);
        if(left == null){
            inorder+="Lnull";
        } else{
            inorder+=left;
        }
        inorder += node.val+"-";
        String right = InorderTrav(node.right);
        if(right == null){
            inorder+="Rnull";
        } else{
            inorder+=right;
        }
        return inorder;
    }

}
