package com.atul.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        System.out.println(kthDistinct(arr,2));
    }

    public static String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String it : arr){
            map.put(it, map.getOrDefault(it, 0)+1);
        }
        System.out.println(map);
        int count  =0;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                count++;
                if(count == k) {
                    return entry.getKey();
                }
            }
            //count++;
        }
        return null;
    }
}
