package com.atul.trie;

import java.util.Map;

public class MaximumXOROfTwoNumbersInAnArray {
    static class Node {
        Node[] links = new Node[2];

        boolean containKey(int ch) {
            return links[ch] != null;
        }

        Node get(int ch) {
            return links[ch];
        }

        void put(int ch, Node node){
            links[ch] = node;
        }
    }

    public static void main(String[] args) {

    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for (int it : nums){
            putNum(it, root);
        }
        int max = 0;
        for (int it : nums){
            max = Math.max(max, getXor(it, root));
        }
        return max;
    }

    private void putNum(int num, Node root){
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(!node.containKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    private int getXor(int num, Node root){
        Node node = root;
        int maxNumber = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(node.containKey(1-bit)){
                maxNumber = maxNumber | (1 << i);
                node = node.get(1-bit);
            }else {
                node = node.get(bit);
            }
        }
        return maxNumber;
    }
}
