package com.atul.linkedlists;

import javax.swing.text.SimpleAttributeSet;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = null;
        root.child = new Node(2);
        root.child.next = null;
        root.child.child = new Node(3);
        root.child.child.next = null;
        Stack<Integer> stack = new Stack<>();
        System.out.println(flatten(root));
    }

    public static Node flatten(Node head) {
        Node node = head;
        Stack<Node> stack = new Stack<>();
        while(true){
            Node last = solve(node, stack);
            System.out.println(stack);
            if(!stack.isEmpty()){
                Node temp = stack.pop();
                last.next = temp;
                temp.prev = last;
                solve(last, stack);
            }else{
                break;
            }
        }
        return head;
    }

    private static Node solve(Node cur, Stack<Node> stack) {
        Node node = cur;
        Node last = null;
        while (node != null) {
            if (node.child != null) {
                if(node.next != null)
                    stack.add(node.next);
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
            }
            if (node.next == null) {
                last = node;
            }
            node = node.next;
        }
        return last;
    }

    public Node flattenIte(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node curr, prev = pseudoHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
}
