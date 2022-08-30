package com.atul.contest;

import java.util.*;

public class MinimumAmountOfTimeCollectGarbage {
    public static void main(String[] args) {
        String[] arr = {"G", "M", "P" };
        int[] time = {1, 3};

        int mcount = 0, pcount = 0, gcount = 0;
        int mlast = -1, plast = -1, glast = -1;

        int[] prefix = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + time[i-1];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j);
                if(c == 'M'){
                    mcount++;
                    mlast = i;
                }

                if(c == 'G'){
                    gcount++;
                    glast = i;
                }

                if(c == 'P'){
                    pcount++;
                    plast = i;
                }
            }
        }

        int ans = 0;
        if(mcount != 0) {
            ans += mcount;
            ans += prefix[mlast];
        }

        if(pcount != 0) {
            ans += pcount;
            ans += prefix[plast];
        }

        if(gcount != 0) {
            ans += gcount;
            ans += prefix[glast];
        }
        System.out.println(ans);
    }

    private static void solve() {
        String[] arr = {"G", "M", "P" };
        int[] time = {1, 3};
        List<HashMap<Character, Integer>> res = solve(arr);
        System.out.println(res);

        int n = arr.length;
        int gcount = 0;
        boolean gpre = false;
        //starting with garbage truck
        for (int i = 0; i < arr.length; i++) {
            HashMap<Character, Integer> map = res.get(i);
            if (map.get('G') != null) {
                gcount += map.get('G');
                gpre = true;
            }
            if (i + 1 == n - 1 && res.get(i + 1).get('G') == null) continue;
            else if (i != n - 1) gcount += time[i];
        }
        if (gpre == false) gcount = 0;
        System.out.println("gcount = " + gcount);

        int mcount = 0;
        boolean mpre = false;
        for (int i = 0; i < arr.length; i++) {
            HashMap<Character, Integer> map = res.get(i);
            if (map.get('M') != null) {
                mcount += map.get('M');
                mpre = true;
            }
            if (i + 1 == n - 1 && res.get(i + 1).get('M') == null) continue;
            else if (i != n - 1) mcount += time[i];
        }
        if (!mpre) mcount = 0;
        System.out.println("mcount " + mcount);

        int pcount = 0;
        boolean ppre = false;
        for (int i = 0; i < arr.length; i++) {
            HashMap<Character, Integer> map = res.get(i);
            if (map.get('P') != null) {
                pcount += map.get('P');
                ppre = true;
            }
            if (i + 1 == n - 1 && res.get(i + 1).get('P') == null) continue;
            else if (i != n - 1) pcount += time[i];
        }
        if (ppre == false) pcount = 0;
        System.out.println("pcount " + pcount);
    }

    private static List<HashMap<Character, Integer>> solve(String[] s) {
        ArrayList<HashMap<Character, Integer>> result = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s[i].length(); j++) {
                map.put(s[i].charAt(j), map.getOrDefault(s[i].charAt(j), 0) + 1);
            }
            result.add(map);
        }
        return result;
    }
}
