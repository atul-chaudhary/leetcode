package com.atul.unkown;

import java.util.HashMap;
import java.util.Map;

public class LFU {
    public static void main(String[] args) {

    }

    static class Node{
        int prev;
        int next;
        int val;
    }
    class LFUCache {
        int capacity;
        int curSize;
        int minFrequency;
        Map<Integer, Node> cache;
        //Map<Integer, DLL> frequencyMap;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            curSize = 0;
            minFrequency = 0;
            this.cache = new HashMap<>();
            //this.frequencyMap = new HashMap<>();
        }

        public int get(int key) {
            Node node = cache.get(key);
            if(node == null){
                return -1;
            }

            //updateNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            if(capacity == 0){
                return;
            }

            if(cache.containsKey(key)){
                Node node = cache.get(key);
                node.val = value;
                //updateNode(node);
            }else {
                curSize++;

            }
        }
    }
}
