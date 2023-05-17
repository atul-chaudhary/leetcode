package com.atul.linkedlists;

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = swapNodes(head, 2);
        trav(result);
    }

    private static void trav(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int cur = 0;
        int first = k;
        int last = size - k + 1;
        ListNode firstNode = null;
        ListNode lastNode = null;

        temp = head;
        while (temp != null) {
            cur++;
            if (cur == first) {
                firstNode = temp;
            }
            if (cur == last) {
                lastNode = temp;
            }
            temp = temp.next;
        }
        int num = lastNode.val;
        lastNode.val = firstNode.val;
        firstNode.val = num;
        return head;
    }
}
