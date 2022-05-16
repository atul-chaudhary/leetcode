package com.atul.linkedlists;

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
