package com.atul.linkedlists;


public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode temp = removeElements(listNode1, 6);
        if (temp == null) {
            System.out.println("node data is present");
        } else {
            ListNode list = temp;
            while (list != null) {
                System.out.println(list.val);
                list = list.next;
            }
            //System.out.println(list.value);
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head != null) {
            //System.out.println("value"+ head.val);
            if (head.val != val) {
                System.out.println("inside"+head.val);
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;

        }
        return dummy.next;
    }
}
