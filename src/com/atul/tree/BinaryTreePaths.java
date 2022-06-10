package com.atul.tree;

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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    static List<LinkedList<Integer>> list = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(6);
//        root.left.right.right = new Node(7);
//        root.right = new Node(3);

        Node node = new Node(3);
        node.left = new Node(5);
        node.left.left = new Node(6);
        node.left.right = new Node(2);
        node.left.right.left = new Node(7);
        node.left.right.right = new Node(4);
        node.right = new Node(1);
        node.right.left = new Node(0);
        node.right.right = new Node(8);

        lowestCommonAncestor(node, node.left, node.left.right.right);
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        ArrayList<Node> first = new ArrayList<>();
        ArrayList<Node> second = new ArrayList<>();

        boolean firstResult = find(root, p, first);
        System.out.println(first);

        boolean secondResult = find(root, q, second);
        System.out.println(second);
        if(!firstResult || !secondResult){
            return null;
        }else{
            Node result = null;
            for(int i=0;i< first.size();i++){
                if(second.contains(first.get(i))){
                    result = first.get(i);
                    break;
                }
            }
            return result;
        }

    }

    public static boolean find(Node node, Node data, ArrayList<Node> arr){
        if(node == null){
            return false;
        }

        if(node == data){
            arr.add(node);
            return true;
        }

        boolean left = find(node.left, data, arr);
        if(left){
            arr.add(node);
            return true;
        }

        boolean right = find(node.right, data, arr);
        if(right){
            arr.add(node);
            return true;
        }
        return false;
    }

    public static boolean solve(Node root , int data, ArrayList<Integer> arrayList){
        if(root==null){
            return false;
        }

        if(root.data == data){
            arrayList.add(data);
            return true;
        }

        boolean left = solve(root.left, data, arrayList);
        if(left){
            arrayList.add(root.data);
            return true;
        }

        boolean right = solve(root.right, data, arrayList);
        if (right){
            arrayList.add(root.data);
            return true;
        }

        return false;
    }

    public static void miano(){
        int lastAn = 0;
        ArrayList<Integer> first = new ArrayList<>(list.get(0));
        ArrayList<Integer> second = new ArrayList<>(list.get(1));
        int i=0;
        int firSi = first.size();
        int secSi = second.size();
        while(i < firSi || i < secSi){
            if(i < firSi && i < secSi && first.get(i).equals(second.get(i))){
                lastAn = first.get(i);
            }else{
                break;
            }
            i++;
        }
        System.out.println(lastAn);

        ArrayList arrayList = new ArrayList();
    }

    static int val = 6;
    static int val1 = 7;
    public static void trav(Node node){
        if(node == null){
            return;
        }
        linkedList.add(node.data);
//        if(node.data==val){
//            System.out.println(linkedList);
//            return;
//        }

        //System.out.println(linkedList);
        trav(node.left);
        if(node.left == null && node.right == null && (node.data==val || node.data== val1)){
            LinkedList temp = (LinkedList) linkedList.clone();
            //System.out.println(linkedList);
            list.add(temp);
        }
        trav(node.right);
        linkedList.removeLast();
    }
}
