package com.atul.recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node l1 = new Node(1);
        Node head = l1;
        Node cur = head;

        for (int i = 2; i <= 5; i++) {
            Node temp = new Node(i);
            cur.next = temp;
            cur = cur.next;
        }
        int k = 2;
        cur = head;
        int i=0;
        while (cur != null){

        }

            cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

