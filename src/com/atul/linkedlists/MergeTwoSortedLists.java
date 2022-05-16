package com.atul.linkedlists;

import com.sun.org.apache.xerces.internal.xs.XSTerm;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (true){
            if(l1== null){
                tail.next = l2;
                break;
            }
            if(l2 == null){
                tail.next = l1;
                break;
            }

            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }
        return dummy;
    }

//    public static void withoutExtraSpace(ListNode l1, ListNode l2){
//        ListNode result = l1;
//        ListNode temp = null;
//        while(true){
//            if(l1== null){
//                tail.next = l2;
//                l2 = l2.next;
//            }
//            if(l2 == null){
//                tail.next = l1;
//                l1 = l1.next;
//            }
//
//            if(l1.val > l2.val){
//                tail.next
//            }
//        }
//    }

}





class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
