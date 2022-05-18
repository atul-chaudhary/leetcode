package com.atul.stacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(10);
        myQueue.push(20);
        myQueue.push(30);
        myQueue.push(40);
        myQueue.push(50);

        System.out.println(myQueue.peek());
    }

    static class MyQueue {

        Stack<Integer> stack = new Stack<>();
        int size = 0;
        public MyQueue() {

        }

        public void push(int x) {
            //size++;
            //stack.push(x);

            //anotther approch
            Stack<Integer> temp = new Stack<>();
            if(size==0){
                stack.push(x);
                size++;
            }else {
                for (int i = 0; i < size; i++) {
                    temp.push(stack.pop());
                }
                stack.push(x);
                size++;
                for (int i = 0; i < size - 1; i++) {
                    stack.push(temp.pop());
                }
            }
        }

        public int pop() {
//            Stack<Integer> temp = new Stack<>();
//            int tempSize  = 0;
//            for(int i=0;i<size;i++){
//                temp.push(stack.pop());
//                tempSize++;
//            }
//            int result = temp.pop();
//            for (int i = 0; i < tempSize; i++) {
//                stack.push(temp.pop());
//            }
            return stack.pop();
        }

        public int peek() {
//            Stack<Integer> temp = new Stack<>();
//            int tempSize = 0;
//            int result = -1;
//            for (int i = 0; i < size; i++) {
//                temp.push(stack.pop());
//                tempSize++;
//            }
//            result = temp.peek();
//            for (int i = 0; i < tempSize; i++) {
//                stack.push(temp.pop());
//            }
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }


}

