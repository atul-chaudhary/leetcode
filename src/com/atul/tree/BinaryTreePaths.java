package com.atul.tree;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static List<LinkedList<Integer>> list = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);
        trav(root);
        System.out.println(list);
    }

    public static void trav(Node node){
        if(node == null){
            return;
        }
        linkedList.add(node.data);
        //System.out.println(linkedList);
        trav(node.left);
        if(node.left == null && node.right == null){
            System.out.println(linkedList);
            list.add(linkedList);
            System.out.println(">>"+list);
        }
        trav(node.right);
        linkedList.removeLast();
    }
}
