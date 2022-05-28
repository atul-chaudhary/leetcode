package com.atul.linkedlists;

import java.util.Stack;

public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = new ListNode(20);
        ListNode listNode3 = new ListNode(30);
        ListNode listNode4 = new ListNode(40);
        ListNode listNode5 = new ListNode(50);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        rotateRight(listNode1, 2);
    }

    public  static ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur= cur.next;
        }
        k = k%size;
        cur = head;
        Stack<ListNode> stack = new Stack<>();
        int index = size - k;
        int cur_index = 0;
        ListNode temp = null;
        while(cur !=null){
            if(cur_index<index){
                temp = cur;
            }
            if(cur_index >= index){
                stack.push(cur);
            }
            cur = cur.next;
            cur_index++;
        }
        System.out.println(">>> "+temp.val);
        temp.next = null;
        int stack_size = stack.size();
        System.out.println(stack_size);
        while(k  > 0){
            ListNode node = stack.pop();
            node.next = head;
            head = node;
            k--;
        }
        return head;
    }
}
