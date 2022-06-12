package com.atul.linkedlists;

class MyLinkedList {
    Node head;
    int len;
    public MyLinkedList() {

    }
    public int get(int index) {
        Node cur = head;
        int cur_index = 0;
        int result = -1;
        while(cur!=null){
            if(cur_index == index){
                result =  cur.val;
                break;
            }
            cur = cur.next;
            cur_index++;
        }
        return result;
    }

    public void addAtHead(int val) {
        if(head == null){
            Node node = new Node();
            node.val = val;
            head = node;
        }else{
            Node node = new Node();
            node.val = val;
            node.next = head;
            head = node;
        }
        len++;
    }

    public void addAtTail(int val) {
        if(head == null){
            Node node = new Node();
            node.val = val;
            head = node;
        }else{
            Node cur = head;
            while(cur.next !=null){
                cur = cur.next;
            }
            Node node = new Node();
            node.val = val;
            cur.next = node;
        }
        len++;
    }

    public void addAtIndex(int index, int val) {
        if(index ==0){
            Node node = new Node();
            node.val = val;
            node.next = head;
            head = node;
        }else{
            Node base = null;
            Node cur = head;
            int cur_index = 0;
            while(cur_index < index){
                base = cur;
                cur = cur.next;
                cur_index++;
            }
            Node neww = new Node();
            neww.val = val;
            base.next = neww;
            neww.next = cur;
        }
        len++;
    }

    public void deleteAtIndex(int index) {
        if(index <0 || index >= this.len) return;
        if(head == null){
            return;
        }
        if(index == 0){
            head.val = 0;
            head = head.next;
        }else{
            Node cur = head;
            Node base = null;
            int cur_index = 0;
            while(cur_index < index){
                base = cur;
                cur = cur.next;
                cur_index++;
            }
            base.next = cur.next;
            cur.val = 0;
            cur.next = null;
        }
    }

    public void traverse(){
        Node cur = head;
        while(cur !=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

class Node{
    int val;
    Node next;

    public Node() {
    }

    public Node(int sum) {
    }
}
/*
public class LinkedList {
    private Node head = null;
    private int size = 0;

    public void insertAtStart(int value) {
        if (head == null) {
            Node node = new Node();
            node.value = value;
            node.next = null;
            head = node;
            size++;
        } else {
            Node node = new Node();
            node.value = value;
            node.next = head;
            head = node;
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
            newNode.next= null;
            size++;
        }else {
            Node list = head;
            while (list.next != null){
                list = list.next;
            }
            list.next = newNode;
            newNode.next = null;
            size++;
        }
    }

    public void traverse(){
        if(head==null){
            System.out.println("node data is present");
        }else {
            Node list = head;
             while (list != null){
                System.out.println(list.value);
                list = list.next;
            }
            //System.out.println(list.value);
        }
    }

}

class Node {
    int value;
    Node next;
}
*/
