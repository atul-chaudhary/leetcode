package com.atul.contest;

import java.util.*;

public class MergeSimilarItems {
    public static void main(String[] args) {
        int[][] item1 = {{1,1},{4,5},{3,8}};
        int[][] item2 = {{3,1},{1,5}};
        System.out.println(mergeSimilarItems(item1, item2));
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int[] row : items1){
            map1.put(row[0], row[1]);
        }

        for(int[] row : items2){
            if(map1.containsKey(row[0])){
                map1.put(row[0], map1.get(row[0])+row[1]);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(row[0]);
                temp.add(row[1]+map1.get(row[0]));
                result.add(temp);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            result.add(temp);
        }

        result.sort((a, b) -> a.get(0).compareTo(b.get(0)));

        return result;
    }
}
