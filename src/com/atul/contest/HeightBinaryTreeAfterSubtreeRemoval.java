package com.atul.contest;

import java.util.Arrays;
import java.util.PropertyResourceBundle;

public class HeightBinaryTreeAfterSubtreeRemoval {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);

        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int n = 125;
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        System.out.println(sum);
        //System.out.println(Arrays.toString(treeQueries(root, new int[]{4})));
    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];
        int i = 0;
        for(int it : queries){
            result[i++] = solve(root, it);
        }

        return result;
    }

    private static int solve(TreeNode node, int num){
        if(node == null)return 0;

        int left = 0;
        if(node.left != null && node.left.val != num){
            left = solve(node.left, num);
        }

        int right = 0;
        if(node.right !=null && node.right.val != num){
            right = solve(node.right, num);
        }

        return 1+Math.max(left, right);
    }
}
