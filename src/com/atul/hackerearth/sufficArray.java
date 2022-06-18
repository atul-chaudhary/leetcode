package com.atul.hackerearth;

import java.util.HashMap;
import java.util.Map;

public class sufficArray {

    public static void main(String[] args) {
        String[] larger = {"asdfc", "asfc", "vdsfc", "trgfds", "egregds" ,"tertdfc","rtyergds"};
        String[] queries   = {"dfc", "fc", "ds"};
        int[] result = suffixCount(7, larger, 3, queries);
        for (int i : result)
            System.out.println(i);
    }

    static int[] suffixCount(int N, String[] larger, int Q, String[] queries) {
        // Write your code here
        int[] result = new int[Q];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            int count = 0;
            int sLen= s.length();

            for (int j = 0; j < larger.length; j++) {
                int lLen = larger[j].length();
                if(larger[j].substring(lLen-sLen, lLen).equals(s)){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;

    }
}
