package com.atul.linkedlists;

public class PartitionList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);

        ListNode result = partition(head, 3);
        trav(result);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode sm = small;
        ListNode lm = large;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                small.next = cur;
                small = small.next;
            }else{
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        small.next = lm.next;
        large.next = null;
        return sm.next;
    }

    public static void trav(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


}
