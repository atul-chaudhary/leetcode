package com.atul.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = swapPairs(head);
        trav(result);
    }

    private static void trav(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int size = list.size();
        for (int i = 1; i < size; i = i + 2) {
            int cur = list.get(i - 1);
            list.set(i - 1, list.get(i));
            list.set(i, cur);
        }
        ListNode result = new ListNode(list.get(0));
        temp = result;
        for (int i = 1; i < size; i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return result;
    }
}
