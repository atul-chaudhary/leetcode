package com.atul.linkedlists;

import java.util.Stack;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        trav(head);
    }

    private static void trav(ListNode head){
        if(head == null) return;
        trav(head.next);
        System.out.println(head.val);
    }


    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = head;
        while(dummy != null){
            stack.push(dummy);
            dummy = dummy.next;
        }
        dummy = head;
       while (dummy.next != null){
           ListNode temp = dummy.next;
           dummy.next = stack.pop();
           if(!stack.isEmpty()) stack.peek().next = null;
           dummy.next.next = temp;
           dummy = dummy.next.next;
       }
    }
}
