package com.atul.contest;

import java.util.*;

public class SortthePeople {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] he = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(names, he)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        int n = names.length;
        String[] result = new String[n];
        int i =0;
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            result[i++] = entry.getValue();
        }
        return result;
    }

}
