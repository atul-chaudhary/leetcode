package com.atul.linkedlists;

public class DriverClass {

    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//        linkedList.insertAtEnd(10);
//        linkedList.insertAtEnd(20);
//        linkedList.insertAtEnd(30);
//        linkedList.insertAtEnd(40);
//        linkedList.insertAtStart(100);
//        linkedList.traverse();
//        System.out.println(linkedList.getSize());

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(10);
        //myLinkedList.addAtIndex(1, 15);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.traverse();
    }
}
