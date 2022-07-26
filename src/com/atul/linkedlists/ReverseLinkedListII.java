package com.atul.linkedlists;

public class ReverseLinkedListII {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        //trav(head);
        ListNode result = reverseBetween(head, 1, 1);
        trav(result);
    }

    public static ListNode reverseBetweenOtp(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = fakeHead.next;
        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode node = prev;
        System.out.println(" bb " + node.val);
        while (i <= n) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }
        node.next.next = curr;
        node.next = prev;
        return fakeHead.next;
    }

    public static void trav(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        left--;
        right--;
        ListNode l = null;
        ListNode r = null;
        ListNode lprev = new ListNode(-1);
        ListNode rnext = null;
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            if (i + 1 == left) {
                lprev = cur;
            }
            if (i == left) {
                l = cur;
            }
            if (i == right) {
                r = cur;
                rnext = cur.next;
            }
            i++;
            cur = cur.next;
        }
        ListNode prev = null;
        cur = l;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // System.out.println(cur.val);
        lprev.next = r;
        l.next = rnext;
        rnext.next = null;
        return head;
    }
}
