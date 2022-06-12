package com.atul.tree;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        System.out.println(((int)Math.pow(2,3))-1);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        TreeNode startingNode = target;

        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();

        populateNodeToParent(nodeToParent, root, null);

        int levelCount = 0;
        HashSet<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> process = new LinkedList<>();

        process.offer(startingNode);
        seen.add(startingNode);

        while(!process.isEmpty()){
            int size = process.size();

            if(levelCount == k){
                return extractValues(process);
            }

            for(int i=0; i < size; i++){
                TreeNode curr = process.poll();

                if(curr.left != null && !seen.contains(curr.left)){
                    process.offer(curr.left);
                    seen.add(curr.left);
                }
                if(curr.right != null && !seen.contains(curr.right)){
                    process.offer(curr.right);
                    seen.add(curr.right);
                }
                TreeNode parent = nodeToParent.get(curr);
                if(parent != null && !seen.contains(parent)){
                    process.offer(parent);
                    seen.add(parent);
                }
            }
            levelCount++;
        }
        return new ArrayList<>();
    }

    private List<Integer> extractValues(Queue<TreeNode> process){
        List<Integer> result = new ArrayList<>();
        while(!process.isEmpty()){
            result.add(process.poll().val);
        }
        return result;
    }

    private void populateNodeToParent(Map<TreeNode, TreeNode> nodeToParent, TreeNode root, TreeNode parent){
        if(root == null){
            return;
        }

        nodeToParent.put(root, parent);

        populateNodeToParent(nodeToParent, root.left, root);
        populateNodeToParent(nodeToParent, root.right, root);

    }
}
