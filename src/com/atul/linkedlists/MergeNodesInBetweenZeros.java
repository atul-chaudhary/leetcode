package com.atul.linkedlists;

public class MergeNodesInBetweenZeros {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next.next = new ListNode(0);

        //System.out.println();
        ListNode temp = mergeNodes(node);
        traverse(temp);
    }

    public static void traverse(ListNode listNode){
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeNodes(ListNode head) {

        int count = 0;
        int sum = 0;
        ListNode neww = new ListNode();
        ListNode cur = neww;

        while(head != null){
            if(head.val==0){
                count++;
            }

            sum+=head.val;

            if(count==2){
                neww.next = new ListNode(sum);
                neww  = neww.next;
                count--;
                sum=0;
            }

            head = head.next;
        }
        return cur.next;
    }
}
