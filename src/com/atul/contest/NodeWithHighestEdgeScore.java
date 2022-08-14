package com.atul.contest;

import java.util.*;

public class NodeWithHighestEdgeScore {
    public static void main(String[] args) {
        int[] edges = {1,2,0};
        System.out.println(edgeScore(edges));
        System.out.println(solve(edges));
    }

    private static int solve(int[] edges){
        int n = edges.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[edges[i]] = arr[edges[i]]+i;
        }
        //System.out.println(Arrays.toString(arr));
        long max = 0;
        int key = -1;
        for (int i = 0; i < n; i++) {
            if(max < arr[i]){
                max = arr[i];
                key = i;
            }
        }
        return key;
    }

    public static int edgeScore(int[] edges) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], (long) map.getOrDefault(edges[i], 0L)+i);
        }
        int key = -1;
        long val = Integer.MIN_VALUE;
        System.out.println(map);
        for (Map.Entry<Integer, Long> ent : map.entrySet()){
            if(val < ent.getValue()){
                val = ent.getValue();
                key = ent.getKey();
            }
        }
        return key;
    }

    
}
