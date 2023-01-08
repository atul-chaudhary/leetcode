package com.atul.dynamic_programming;

import java.util.*;

public class HouseRobberIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] dfs(TreeNode node){
        if(node == null) return new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] res = new int[2];
        res[0] = left[1]+right[1]+node.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

        static class TreeNode {
        TreeNode left, right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int robOpt(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (!pq.isEmpty()) {
            int size = pq.size();
            int num = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                num += node.val;
                if (node.left != null) {
                    pq.offer(node.left);
                }
                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            nums.add(num);
        }
        int n = nums.size();
        Integer[] dp = new Integer[n];
        return solve(nums, 0, dp);
    }

    private static int solve(List<Integer> nums, int index, Integer[] dp){
        if(index >= nums.size()){
            return 0;
        }
        if(dp[index] != null) return dp[index];
        int ans = Integer.MIN_VALUE;
        for (int i = index; i < nums.size(); i++) {
            int temp = nums.get(i) + solve(nums, i + 2, dp);
            ans = Math.max(ans, temp);
        }

        return dp[index] = ans;
    }
}
