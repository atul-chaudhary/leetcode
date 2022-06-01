package com.atul.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
//        int[] arr1 = {4,1,2};
//        int[] arr2 = {1,3,4,2};
//        System.out.println(nextGreaterElement(arr1, arr2));

        int[] arr = {89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }

    public static int[] dailyTemperatures(int[] arr) {
        class Node{
            int val;
            int index;

            @Override
            public String toString() {
                return "Node{" +
                        "val=" + val +
                        ", index=" + index +
                        '}';
            }
        }
        int[] result = new int[arr.length];
        Stack<Node> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                result[i] = 0;
            }else if(!stack.isEmpty() && stack.peek().val > arr[i]){
                result[i] = stack.peek().index - i;
            }else if(!stack.isEmpty() && stack.peek().val <= arr[i]){
                System.out.println(stack);
                while(stack.size() > 0 && stack.peek().val <= arr[i]) stack.pop();
                System.out.println(">>"+stack);
                if(stack.isEmpty()){
                    result[i] = 0;
                }else {
                    result[i] = stack.peek().index - i;
                }
            }
            Node node = new Node();
            node.val = arr[i];
            node.index = i;
            stack.push(node);
        }
        return result;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            int re = -1;
            for(int j=map.get(nums1[i])+1;j< nums2.length;j++){
                if(nums2[j] > nums1[i]) {
                    re = nums2[j];
                    break;
                }
            }
            result[i] = re;
        }
        return result;
    }


    public static void NGR(){
        int[] arr = {4, 5, 2, 25};
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                stack.push(arr[i]);
                result[i] = -1;
            } else {
                if (stack.peek() > arr[i]) {
                    result[i] = stack.peek();
                    stack.push(arr[i]);
                } else if (stack.peek() < arr[i]) {
                    while (stack.size() > 0 && stack.peek() <= arr[i]) stack.pop();
                    if (stack.size() == 0) {
                        result[i] = -1;
                    } else {
                        result[i] = stack.peek();
                    }
                    stack.push(arr[i]);
                }
            }
        }
        System.out.println(Arrays.toString(result));

    }
}
