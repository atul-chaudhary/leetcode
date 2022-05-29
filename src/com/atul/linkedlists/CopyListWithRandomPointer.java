package com.atul.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        DoublyList d1 = new DoublyList(7);
        DoublyList d2 = new DoublyList(13);
        DoublyList d3 = new DoublyList(11);
        DoublyList d4 = new DoublyList(10);
        DoublyList d5 = new DoublyList(1);

        d1.next = d2;
        d2.next = d3;
        d3.next = d4;
        d4.next = d5;

        d1.random = null;
        d2.random = d1;
        d3.random = d5;
        d4.random = d3;
        d5.random = d1;
        DoublyList result = copyRandomList(d1);
        //traverse(result);
    }

    public static DoublyList copyRandomList(DoublyList head) {
        DoublyList cur = head;
        HashMap<DoublyList, DoublyList> map = new HashMap<>();
        while(cur != null){
            DoublyList node = new DoublyList(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        //System.out.println(map);
        cur = head;
        DoublyList myHead = map.get(cur);
        DoublyList prev = myHead;
        while(cur != null){
            prev.next = map.get(cur.next);
            prev.random = map.get(cur.random);
            prev =prev.next;
            cur = cur.next;
        }
        traverse(myHead);
        return myHead;
    }

    public static void traverse(DoublyList d){
        HashMap<Character, Integer> map = new HashMap<>();
        while(d != null){
            System.out.println(d.val);
            d= d.next;
        }
    }
}

class DoublyList{
    int val;
    DoublyList next;
    DoublyList random;

    public DoublyList(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "DoublyList{" +
                "val=" + val +
                '}';
    }
}
