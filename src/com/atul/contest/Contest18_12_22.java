package com.atul.contest;

import java.util.*;

public class Contest18_12_22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        solve(4, 0, 0, result, "");
        System.out.println(result);
    }

    private static void solve(int n, int start, int end, List<String> list, String cur){
        if(start > n || end > n) return;
        if(end > start) return;
        if(start == n && end == n) {
            list.add(cur);
            return;
        }

        if(start == 0){
            solve(n, start+1, end, list,cur+"(");
        }else {
           solve(n, start+1, end, list, cur+"(");
           solve(n, start, end+1, list, cur+")");
        }
    }

    public static int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            //result[i] = solve(first, second);
            List<Integer> path1 = path(first);
            List<Integer> path2 = path(second);
            int it1 = path1.size();
            int it2 = path2.size();
            for (int j = 0; j < it1; j++) {
                int cur = path1.get(j);
                for (int k = 0; k < it2; k++) {
                    if(cur == path2.get(k)){
                        result[i] =  j+k+1;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static int solve(int first, int second){
        List<Integer> path1 = path(first);
        List<Integer> path2 = path(second);
        int it1 = path1.size();
        int it2 = path2.size();
        for (int j = 0; j < it1; j++) {
            int cur = path1.get(j);
            for (int k = 0; k < it2; k++) {
                if(cur == path2.get(k)){
                    return j+k+1;
                }
            }
        }
        return -1;
    }

    private static List<Integer> path(int num){
        List<Integer> result = new ArrayList<>();
        while (num > 0){
            result.add(num);
            num/=2;
        }
        return result;
    }

    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[n + 1];
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        List<Integer> oddNodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                oddNodes.add(i);
            }
        }
        int count = oddNodes.size();
        if (count == 0) return true;
        else if (count > 4 || count == 1 || count == 3) return false;
        else if (count == 2) {
            int firstNode = oddNodes.get(0);//degree[0];
            int secondNode = oddNodes.get(1);//degree[1];
            if (legal(adj, firstNode, secondNode)) return true;
            for (int i = 1; i <= n; i++) {
                if (i == firstNode || i == secondNode) continue;
                if (legal(adj, i, firstNode) && legal(adj, i, secondNode)) return true;
            }
            return false;
        } else if (count == 4) {
            int firstNode = oddNodes.get(0);//degree[0];
            int secondNode = oddNodes.get(1);//degree[1];
            int thirdNode = oddNodes.get(2);//degree[2];
            int fourNode = oddNodes.get(3);//degree[4];

            if (legal(adj, firstNode, secondNode) && legal(adj, thirdNode, fourNode)) return true;
            if (legal(adj, firstNode, thirdNode) && legal(adj, secondNode, fourNode)) return true;
            if (legal(adj, firstNode, fourNode) && legal(adj, secondNode, thirdNode)) return true;
            return false;
        }
        return false;
    }

    private static boolean legal(List<List<Integer>> adj, int firstNode, int secondNode) {
        for (int node : adj.get(firstNode)) {
            if (node == secondNode) return false;
        }
        for (int node : adj.get(secondNode)) {
            if (node == firstNode) return false;
        }
        return true;
    }



    public static int smallestValue(int n) {
        int sum = primeFactors(n);
        if (sum == n) return sum;
        return smallestValue(sum);
    }

    public static int primeFactors(int n) {
        // Print the number of 2s that divide n
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            sum += n;

        return sum;
    }


    public static int similarPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Map<Character, Integer> map1 = new HashMap<>();
                Map<Character, Integer> map2 = new HashMap<>();
                fre(words[i], words[j], map1, map2);
                if (check(map1, map2)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        int n = map1.size();
        int m = map2.size();
        if (n != m) return false;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    private static void fre(String s1, String s2, Map<Character, Integer> map1, Map<Character, Integer> map2) {
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
    }
}
