package com.atul.tree;

public class HeightOfCompleteBinaryTree {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);

        System.out.println(countNodes(node));
    }

    static int count = 0;
    static int heightCal = 0;

    public static int countNodes(Node root) {
        //another better approach
        height(root.left);
        int left = heightCal;

        heightCal = 0;

        height(root.right);
        int right = heightCal;

        System.out.println(left + " " + right);
        if (left == right) {
            return ((int) Math.pow(2, left+1)) - 1;
        } else {
            return 1 + ((int) Math.pow(2, left)) - 1 + ((int) Math.pow(2, right)) - 1;
        }

    }

    private static void height(Node node) {
        if (node == null) {
            return;
        }
        heightCal++;
        height(node.left);
    }
}
