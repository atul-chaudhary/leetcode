package com.atul.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){
//            if(node !=null){
//                stack.push(node);
//                node = node.left;
//            }else{
//                if(stack.isEmpty()) break;
//                if(node !=null){
//                    stack.push(node);
//                    node = node.right;
//                }
//                node = stack.pop();
//                 list.add(node.val);
//
//            }

//            if(node!=null){
//                stack.push(node);
//                node = node.left;
//            }
//            if(node !=
        }
        //return 0;
    }

}
