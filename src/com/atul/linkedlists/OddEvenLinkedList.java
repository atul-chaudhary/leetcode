package com.atul.linkedlists;

public class OddEvenLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = oddEvenList(head);
        trav(result);
    }

    private static void trav(ListNode head) {
        System.out.println("head value " + head.val);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode fast = head;
        ListNode yo = odd;
        ListNode no = even;
        while (fast != null && fast.next != null) {
            odd.next = fast;
            even.next = fast.next;
            odd = odd.next;
            even = even.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            odd.next = fast;
            odd = odd.next;
        }
        even.next = null;
        odd.next = no.next;
        return yo.next;
    }
}
