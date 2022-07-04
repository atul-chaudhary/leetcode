package com.atul.contest;

import java.util.Arrays;

public class SpiralMatrixIV {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        double d = ( 10 * 1.0) / 3;
        int re = (int) Math.ceil(d);
        System.out.println(re);
        System.out.println();
        int[] arr = {8,24,5,21,10,11,11,12,6,17};//{0,1,2};//{3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        for (int it: arr){
            temp.next = new ListNode(it);
            temp = temp.next;
        }
        trav(head.next);
        int[][] res = spiralMatrix(10, 1 , head.next);
        System.out.println();
        for (int[] it : res){
            System.out.println(Arrays.toString(it));
        }
    }

    public static void trav(ListNode node){
        ListNode cur = node;
        while(cur != null){
            System.out.print(cur.val+ " ");
            cur = cur.next;
        }
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode cur = head;
        int[][] arr = new int[m][n];
        int rowTop = 0;
        int rowEnd = m-1;
        int colStart = 0;
        int colEnd = n-1;
        while(rowTop <= rowEnd && colStart <= colEnd){
            for (int i = colStart; i <=colEnd ; i++) {
                if(cur != null){
                    arr[rowTop][i] = cur.val;
                    System.out.println("--->"+cur.val);
                    cur = cur.next;
                }else{
                    System.out.println("--->"+-1);
                    if(arr[rowTop][i] != -1)
                        arr[rowTop][i] = -1;
                }
            }
            rowTop++;
            for (int i = rowTop; i <= rowEnd ; i++) {
                if(cur != null){
                    arr[i][colEnd] = cur.val;
                    System.out.println(" /"+cur.val);
                    cur = cur.next;
                }else{
                    System.out.println(" /"+-1);
                    if(arr[i][colEnd] != -1)
                    arr[i][colEnd] = -1;
                }
            }
            colEnd--;
            if(rowTop <= rowEnd){
                for (int i = colEnd; i >= colStart ; i--) {
                    if (cur != null) {
                        arr[rowEnd][i] = cur.val;
                        System.out.println("<---"+cur.val);
                        cur =cur.next;
                    }else{
                        System.out.println("<---"+-1);
                        if(arr[rowEnd][i] != -1)
                         arr[rowEnd][i] = -1;
                    }
                }
            }
            rowEnd--;
            if(colStart <= colEnd){
                for (int i = rowEnd; i >= rowTop; i--) {
                    if(cur != null){
                        arr[i][colStart] = cur.val;
                        System.out.println("^"+cur.val);
                        cur = cur.next;
                    }else{
                        System.out.println("^"+-1);
                        if(arr[i][colStart] != -1)
                            arr[i][colStart] = -1;
                    }
                }
            }
            colStart++;
        }
        return arr;
    }
}
