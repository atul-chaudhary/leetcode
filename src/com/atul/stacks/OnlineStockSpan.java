package com.atul.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(onlineStockSpan(arr)));
    }

    public static int[] onlineStockSpan(int[] arr){
        class Node{
            int val;
            int index;
        }
        Stack<Node> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()){
                result[i] = -1;
            }else if(stack.peek().val > arr[i]){
                result[i] = stack.peek().index;
            }else if(!stack.isEmpty() && stack.peek().val <= arr[i]){
                while (stack.size() >0 && stack.peek().val <= arr[i]) stack.pop();
                if(stack.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = stack.peek().index;
                }
            }
            Node node = new Node();
            node.val = arr[i];
            node.index = i;
            stack.push(node);
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = i-result[i];
        }
        result[0] = 1;
        return result;
    }



}

class StockSpanner {
    List<Integer> list;// = new ArrayList<>();
    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int count = 1;
        int len = list.size();
        for(int i=len-1;i>=0;i--){
            if(list.get(i) <= price){
                count++;
            }else{
                break;
            }
        }
        list.add(price);
        return count;
    }
}
