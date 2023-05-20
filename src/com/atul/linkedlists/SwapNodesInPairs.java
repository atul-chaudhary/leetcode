package com.atul.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(pairSumOpt(head));
        //ListNode result = swapPairs(head);
        //trav(result);
    }

    public static int pairSumOpt(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            nums.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int size = nums.size();
        int index = size - 1;
        int max = Integer.MIN_VALUE;
        while (slow != null) {
            int first = slow.val;
            int last = nums.get(index--);
            max = Math.max(max, first + last);
            slow = slow.next;
        }
        return max;
    }

    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        int size = arr.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size / 2; i++) {
            int first = arr.get(i);
            int last = arr.get(size - 1 - i);
            max = Math.max(max, first + last);
        }
        return max;
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
