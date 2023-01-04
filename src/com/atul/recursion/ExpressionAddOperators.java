package com.atul.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        int target = 8;
        System.out.println(solve(8, 1)+1);
    }
    private static int solve(int target, int num) {

        if (num > target) return (int)1e6;
        if (num == target) return 0;

        int add = 1+solve(target, num + 1);
        int mult = 1+solve(target, num * 2);
        return Math.min(add, mult);
    }

    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int count = 0;
        Map<Integer, Boolean> vis = new HashMap<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = strs[i].length();
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(j, new ArrayList<>());
                vis.putIfAbsent(j, false);
                char ch = strs[i].charAt(j);
                if (map.get(j).isEmpty() || map.get(j).get(map.get(j).size() - 1) <= ch) {
                    List<Character> adj = map.get(j);
                    adj.add(ch);
                    map.put(j, adj);
                } else {
                    if (vis.get(j) == false) {
                        count++;
                    }
                    vis.put(j, true);
                }
            }
        }
        return count;
    }

    public String capitalizeTitle(String title) {
        String[] str = title.split(" ");
        int n = str.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str[i].length() <= 2) {
                if (sb.length() == 0) {
                    sb.append(str[i].toLowerCase());
                } else
                    sb.append(" ").append(str[i].toLowerCase());
            } else {
                String s = str[i].toLowerCase();
                String last = s.substring(1);
                String first = String.valueOf(s.charAt(i)).toUpperCase();
                if (sb.length() == 0) {
                    sb.append(first).append(last);
                } else {
                    sb.append(" ").append(first).append(last);
                }
            }
        }
        return sb.toString();
    }

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        solve(num, target, 0, "", result, 0, 0);
        return result;
    }

    private static void solve(String nums, int target, int index, String cur, List<String> list, long eval, long mult) {
        if (index == nums.length()) {
            if (eval == target) {
                list.add(cur);
                return;
            }
            return;
        }
        for (int i = index; i < nums.length(); i++) {
            if (i != index && nums.charAt(index) == '0') break;
            long number = Long.parseLong(nums.substring(index, i + 1));
            if (index == 0) {
                solve(nums, target, i + 1, cur + number, list, eval + number, number);
            } else {
                solve(nums, target, i + 1, cur + "+" + number, list, eval + number, number);
                solve(nums, target, i + 1, cur + "-" + number, list, eval - number, -number);
                solve(nums, target, i + 1, cur + "*" + number, list, eval - mult + (mult * number), mult * number);
            }
        }
    }

}
