package com.atul.contest;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeProductQueriesPowers {
    static int mod = (int)1e9 +7;
    public static void main(String[] args) {
        int num = 15;
        System.out.println(mod);
        int[][] queries = {{0,1},{2,2},{0,3}};

        System.out.println(Arrays.toString(productQueries(num, queries)));
    }

    public static int[] productQueries(int n, int[][] queries) {
        String s = Integer.toBinaryString(n);
        ArrayList<Long> arr = new ArrayList<>();
        int cur = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) != '0') {
                arr.add((long) Math.pow(2, cur));
            }
            cur++;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long temp = 1;
            for (int j = queries[i][0]; j <= queries[i][1] ; j++) {
                temp*=arr.get(j);
            }
            result[i] = (int) temp%mod;
        }
        System.out.println(arr);
        return result;
    }
}
