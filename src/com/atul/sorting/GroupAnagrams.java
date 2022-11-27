package com.atul.sorting;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(Arrays.toString());
        System.out.println(groupAnagrams(words));
    }

    class Solution {
        class Pair {
            int startTime;
            int endTime;
            int profit;

            public Pair(int startTime, int endTime, int profit) {
                super();
                this.startTime = startTime;
                this.endTime = endTime;
                this.profit = profit;
            }
        }
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            ArrayList<Pair> arr = new ArrayList<Pair>();
            for (int i = 0; i < startTime.length; i++) {
                arr.add(new Pair(startTime[i], endTime[i], profit[i]));
            }
            Collections.sort(arr, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.startTime != o2.startTime)
                        return o1.startTime - o2.startTime;
                    return o1.endTime - o2.endTime;
                }
            });
            return maxProfit(0, arr, new Integer[startTime.length]);
        }

        public int maxProfit(int index, ArrayList<Pair> arr, Integer[] dp) {
            if (index >= arr.size())
                return 0;
            if (dp[index] != null)
                return dp[index];

            int i = index + 1;
            while (i < arr.size() && arr.get(i).startTime < arr.get(index).endTime)
                i++;
            return dp[index] = Math.max(maxProfit(i, arr, dp) + arr .get(index).profit, maxProfit(index + 1, arr, dp));
        }
    }

    public static List<List<String>> groupAnagrams(String[] arr) {
        HashMap<HashMap<Character, Integer>, List<String>> mainMap = new HashMap<>();
        for (String it : arr) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < it.length(); i++) {
                map.put(it.charAt(i), map.getOrDefault(it.charAt(i), 0) + 1);
            }
            if (mainMap.containsKey(map)) {
                mainMap.get(map).add(it);
            } else {
                List<String> list = new ArrayList<>();
                list.add(it);
                mainMap.put(map, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<HashMap<Character, Integer>, List<String>> entry : mainMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
