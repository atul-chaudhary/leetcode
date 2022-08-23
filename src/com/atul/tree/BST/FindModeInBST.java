package com.atul.tree.BST;

import com.atul.tree.AmountOfTimeBinaryTreeToBeInfected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindModeInBST {
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
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(findMode(root)));
    }

    public  static int[] findMode(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        solve(root, map);
        int last = map.lastEntry().getValue();
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(map);
        while(map.size() >= 1){
            if(map.lastEntry().getValue() == last){
                arrayList.add(map.pollLastEntry().getKey());
            }
            else break;
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    private static void solve(TreeNode root, TreeMap<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        solve(root.left, map);
        solve(root.right, map);
    }
}
