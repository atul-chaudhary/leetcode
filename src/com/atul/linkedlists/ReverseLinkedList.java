package com.atul.linkedlists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ReverseLinkedList  {
    public static void main(String[] args) {
/*        ListNode listNode1 = new ListNode(1);
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

        ListNode temp = reverseList(listNode1);
        if (temp == null) {
            System.out.println("node data is present");
        } else {
            ListNode list = temp;
            while (list != null) {
                System.out.println(list.val);
                list = list.next;
            }
            //System.out.println(list.value);
        }*/

    }

    public static ListNode reverseList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        int index =-1;
        ListNode realHead = head;
        while(head != null){
            arr.add(head.val);
            index++;
            head = head.next;
        }
        //System.out.println(index);
        head = realHead;
        while(head!= null){
            System.out.println(">>"+arr.get(index));
            head.val = arr.get(index);
            index--;
            head= head.next;
        }

        HashMap<Integer, Integer> map = new HashMap();


        return realHead;

    }
}