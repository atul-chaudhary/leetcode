package com.atul.recursion;

import java.util.Stack;

public class SortAStackUsingRecusion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(reverseStack(stack));
        //System.out.println(deleteMiddle(stack,3));
        //sortStack(stack);
        //System.out.println(sortStack(stack));
    }

    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        if(stack.size()==1){
            return stack;
        }
        int top = stack.pop();
        reverseStack(stack);
        return insertEL(stack, top);
    }

    public static Stack<Integer> insertEL(Stack<Integer> stack, int item){
        if(stack.isEmpty()){
            stack.push(item);
            return stack;
        }
        int temp = stack.pop();
        insertEL(stack, item);
        stack.push(temp);
        return stack;
    }

    public static Stack<Integer> deleteMiddle(Stack<Integer> stack,int k){
        if (k==1){
            stack.pop();
            return stack;
        }
        int temp = stack.pop();
        deleteMiddle(stack, k-1);
        stack.push(temp);
        return stack;
    }

    public static Stack sortStack(Stack<Integer> stack) {
        // Write your code here.
        if(stack.size() == 1){
            return stack;
        }
        int temp = stack.pop();
        sortStack(stack);
        return insert(stack, temp);
    }

    public static Stack<Integer> insert(Stack<Integer> st, int el){
        //base condition
        if(st.size() == 0 || st.peek() <= el){
            st.push(el);
            return st;
        }
        int temp = st.pop();
        insert(st, el);
        st.push(temp);

        return st;
    }
}

class SortStackRecursive {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(9);
        st.push(3);
        st.push(5);
        st.push(10);

        System.out.println("Stack before sorting:");
        for (Integer s : st) {
            System.out.print(s + " ");
        }

        System.out.println("\nStack after sorting:");
        Stack<Integer> sorted = sortedStack(st);
        for (Integer i : sorted) {
            System.out.print(i + " ");
        }
    }

    private static Stack<Integer> sortedStack(Stack<Integer> st) {
        // Base condition
        if (st.size() == 1) {
            return st;
        }
        Integer topEl = st.pop();
        // Hypotheses
        sortedStack(st);

        // Induction
        return insertElementAt(st, topEl);
    }

    private static Stack<Integer> insertElementAt(Stack<Integer> st, Integer el) {
        // Base condition
        if (st.size() == 0 || st.peek() <= el) {
            st.push(el);
            return st;
        }

        Integer topEl = st.pop();
        // Hypotheses
        insertElementAt(st, el);

        // Induction
        st.push(topEl);
        return st;
    }
}
