package com.atul.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {

    static class TreeNode {
        TreeNode left, right;
        int val;

    }

    public TreeNode invertTree(TreeNode root) {
        List<List<Integer>> bfs = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (!pq.isEmpty()) {
            int size = pq.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                temp.add(node.val);
                if (node.left != null) {
                    pq.offer(root.left);
                }

                if (node.right != null) {
                    pq.offer(root.right);
                }
            }
            bfs.add(temp);
        }
        return null;
    }


    public static void main(String[] args) {

    }

    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
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
            result.add(temp);
        }

        int size = result.size();
        for (int i = 1; i < size; i++) {
            if (i % 2 == 0) {
                List<Integer> list = result.get(i);
                int num = list.get(0);
                if (num % 2 == 0) return false;
                for (int j = 1; j < list.size(); j++) {
                    if (list.get(j) % 2 == 0) return false;
                    if (list.get(j) <= list.get(j - 1)) return false;
                }
            } else {
                List<Integer> list = result.get(i);
                int num = list.get(0);
                if (num % 2 != 0) return false;
                for (int j = 1; j < list.size(); j++) {
                    if (list.get(j) % 2 != 0) return false;
                    if (list.get(j) >= list.get(j - 1)) return false;
                }
            }
        }
        return true;
    }


}
