package com.atul.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);

        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(-1);
        root.right.left.left = new TreeNode(-1);

        FindElements findElements = new FindElements(root);
        System.out.println(findElements.find(2));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(4));
        System.out.println(findElements.find(5));

    }

    static class FindElements {
        static HashSet<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            solve(root);
        }

        private static void solve(TreeNode root) {
            Queue<TreeNode> pq = new LinkedList<>();
            pq.offer(root);
            while (!pq.isEmpty()){
                TreeNode node = pq.poll();
                set.add(node.val);
                if(node.left != null){
                    node.left.val = 2 * node.val + 1;
                    pq.offer(node.left);
                }
                if(node.right != null){
                    node.right.val = 2 * node.val + 2;
                    pq.offer(node.right);
                }
            }
        }

        public boolean find(int target) {
            if(set.contains(target)) return true;
            return false;
        }
    }
}
