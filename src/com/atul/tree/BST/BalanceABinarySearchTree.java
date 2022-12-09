package com.atul.tree.BST;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalanceABinarySearchTree {
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(1);
//        head.right = new TreeNode(2);
//        head.right.right = new TreeNode(3);
//        head.right.right.right = new TreeNode(4);
//        TreeNode head = new TreeNode(2);
//        head.right = new TreeNode(3);
//        head.left = new TreeNode(1);
//        TreeNode result = balanceBST(head);
//        traversal(result);
        System.out.println((char) 97);
    }

    public static void traversal(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        List<List> trav = new ArrayList<>();
        while (!pq.isEmpty()) {
            int size = pq.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                temp.add(node.val);
                if (node.left != null) {
                    pq.offer(node.left);
                }

                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            trav.add(temp);
        }

        System.out.println(trav);
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> trav = new ArrayList<>();
        inorder(root, trav);
        System.out.println(trav);
        return solve(0, trav.size() - 1, trav);
    }

    private static TreeNode solve(int left, int right, List<Integer> list) {
        if (right < left || left > right) return null;
        if (left == right) return new TreeNode(list.get(left));
        int mid = (left + right) / 2;
        TreeNode head = new TreeNode(list.get(mid));
        head.left = solve(left, mid - 1, list);
        head.right = solve(mid + 1, right, list);
        return head;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
