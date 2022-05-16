package com.atul.linkedlists;

import java.util.HashMap;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode list = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (list != null) {
            if (map.containsKey(list)) {
                return true;
            } else {
                map.put(list, 1);
            }

            list = list.next;
        }
        return false;
    }
}

