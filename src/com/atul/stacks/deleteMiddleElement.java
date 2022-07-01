package com.atul.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class deleteMiddleElement {
    public static void main(String[] args) {
        Stack<Integer> stack =new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//        stack.push(8);
//        stack.push(9);
        int mid = stack.size() / 2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<mid;i++){
            arrayList.add(stack.pop());
        }
        System.out.println("middle ele"+ stack.pop());
        for (int i = arrayList.size()-1; i >= 0; i--) {
            stack.push(arrayList.get(i));
        }

        System.out.println(stack);
    }
}
