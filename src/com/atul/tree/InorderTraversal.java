package com.atul.tree;

import com.atul.strings.Interf;
import com.atul.strings.string1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

interface Interf11{
    public  static void main(String[] args){
        System.out.println("main method");
    }
}

public class InorderTraversal extends string1 implements Interf {

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.m1();
        //inorderTraversal.
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        inorderTraversal.reverseString(arr);
        //inorderTraversal.mymethod();
    }


    void meee(){
        System.out.println("mdwsd w");
    }

    @Override
    public void m2() {

    }
}

class SolutionInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                //list.add(stack.pop())
            }
        }
        return list;
    }
}
