package com.atul.tree;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.*;

public class MaximumProductofSplittedBinaryTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        //TreeNode result = solve(head);//sum(head);
        //level(result);
        //Integer.MAX_VALUE;
        System.out.println(mod);
        System.out.println(maxProduct(head));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        //solve(root, null, map);
        Integer x_parent = map.get(x);
        Integer y_parent = map.get(y);
        if (x_parent == null || y_parent == null) return false;
        if (x_parent == y_parent) return false;
        Integer x_gp = map.get(x_parent);
        Integer y_gp = map.get(y_parent);
        if (x_gp == null || y_gp == null) return false;
        return map.get(x_parent).equals(map.get(y_parent));
    }

    private static int  level(TreeNode root, int x, int y) {
        int sum = 0;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        int count = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if (node.left != null) {
                    pq.offer(node.left);
                    if(node.left.left == null && node.left.right == null) sum+=node.left.val;
                }
                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
        }
        return sum;
    }


    public static int maxProduct(TreeNode root) {
        int totalSum = sum(root);
        long[] max = new long[1];
        max[0] = Integer.MIN_VALUE;
        solve(root, max, totalSum);
        return (int) (max[0] % mod);
    }

    static int mod = (int) 1e9 + 7;

    private static int sum(TreeNode root) {
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.val;
    }

    private static int solve(TreeNode root, long[] max, int totalSum) {
        if (root == null) return 0;

        int left = solve(root.left, max, totalSum);
        int right = solve(root.right, max, totalSum);

        int sum = root.val + left + right;
        max[0] = Math.max(max[0], (long) (totalSum - sum) * sum);
        return sum;
    }

    //
/*
    public static int maxProduct(TreeNode root) {
        int totalSum = sum(root);
        TreeNode node = solve(root);
        long[] max = new long[1];
        max[0] = Integer.MIN_VALUE;
        trav(node, max, totalSum);
        return (int)(max[0]%mod);
    }
    static int mod = (int)1e9+7;
    private static void trav(TreeNode root, long[] max, int totalSum) {
        if (root == null) return;
        max[0] = Math.max(max[0], ((long) (totalSum - root.val) * root.val));
        trav(root.left, max, totalSum);
        trav(root.right, max, totalSum);
    }

    private static int sum(TreeNode root) {
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.val;
    }

    private static TreeNode solve(TreeNode root) {
        if (root == null) return null;

        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        int sum = root.val + (left != null ? left.val : 0) + (right != null ? right.val : 0);
        TreeNode node = new TreeNode(sum);
        node.left = left;
        node.right = right;
        return node;
    }

 */
}

