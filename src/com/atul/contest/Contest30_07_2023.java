package com.atul.contest;

import java.util.*;

public class Contest30_07_2023 {
    public static void main(String[] args) {
        String[] str = {"des", "der", "dfr", "dgt", "dfs"};
        wordLadderLength("der", "dfs", str);
    }

    static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Code here
        Set<String> set = new HashSet<>();
        for (String it : wordList) {
            set.add(it);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        wordBfs(set, startWord, targetWord, result);
        System.out.println(result);
    }

    private static int wordBfs(Set<String> set, String start, String end, ArrayList<ArrayList<String>> result) {
        Queue<Word> pq = new PriorityQueue<>((a, b) -> a.count - b.count);
        pq.offer(new Word(start, 1));
        set.remove(start);
        ArrayList<String> list = new ArrayList<>();
        list.add(start);
        while (!pq.isEmpty()) {
            for (int k = 0; k < pq.size(); k++) {
                Word word = pq.poll();
                String currentWord = word.word;
                int cnt = word.count;
                if (currentWord.equals(end)) {
                    result.add(new ArrayList<>(list));
                }
                int wordLen = currentWord.length();
                for (int i = 0; i < wordLen; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char[] arr = currentWord.toCharArray();
                        arr[i] = j;
                        String formedWord = new String(arr);
                        if (set.contains(formedWord)) {
                            set.remove(formedWord);
                            pq.offer(new Word(formedWord, cnt + 1));
                            list.add(formedWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" + node +
                    "," + weight + "}";
        }
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        //Code here
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wei = edges[i][2];
            adj.get(u).add(new Edge(v, wei));
        }
        System.out.println(adj);
        int[] result = new int[N];
        Arrays.fill(result, (int) 1e9);
        result[0] = 0;
        Queue<Edge> pq = new LinkedList<>();
        pq.offer(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.node;
            int weight = edge.weight;
            result[node] = Math.min(weight, result[node]);
            for (Edge it : adj.get(node)) {
                if (result[it.node] > it.weight + weight) {
                    pq.offer(new Edge(it.node, it.weight + weight));
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == (int) 1e9) {
                result[i] = -1;
            }
        }
        return result;
    }

    public static String findOrder(String[] dict, int N, int K) {
        // Write your code here
        Map<Character, Set<Character>> adj = new HashMap<>();
        int len = dict.length;
        for (int i = 1; i < len; i++) {
            String s1 = dict[i - 1];
            String s2 = dict[i];
            int n = s1.length();
            int m = s2.length();
            int size = Math.min(n, m);
            for (int index = 0; index < size; index++) {
                char c1 = s1.charAt(index);
                char c2 = s2.charAt(index);
                if (c1 == c2) continue;
                adj.putIfAbsent(c1, new HashSet<>());
                adj.putIfAbsent(c2, new HashSet<>());
                adj.get(c1).add(c2);
                break;
            }
        }
        System.out.println(adj);
        Map<Character, Integer> map = new HashMap<>();
        for (Map.Entry<Character, Set<Character>> entry : adj.entrySet()) {
            map.putIfAbsent(entry.getKey(), 0);
            for (Character it : entry.getValue()) {
                map.put(it, map.getOrDefault(it, 0) + 1);
            }
        }
        //System.out.println("dist " + map);
        Queue<Character> pq = new LinkedList<>();
        for (Map.Entry<Character, Integer> it : map.entrySet()) {
            if (it.getValue() == 0) {
                pq.offer(it.getKey());
            }
        }
        String result = "";
        while (!pq.isEmpty()) {
            char node = pq.poll();
            result += node;
            for (char it : adj.get(node)) {
                map.put(it, map.get(it) - 1);
                if (map.get(it) == 0) {
                    pq.offer(it);
                }
            }
        }

        return result;
    }

    static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        int[] ind = new int[V];
        List<List<Integer>> adjNew = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjNew.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                ind[i]++;
                int v = adj.get(i).get(j);
                adjNew.get(v).add(i);
            }
        }

        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (ind[i] == 0) {
                pq.offer(i);
            }
        }
        System.out.println(Arrays.toString(ind));
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            result.add(node);
            for (int it : adjNew.get(node)) {
                ind[it]--;
                if (ind[it] == 0) {
                    pq.offer(it);
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int n = str.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    static int[] findOrder(int N, int m, List<List<Integer>> prerequisites) {
        // add your code here
        int[] degree = new int[N];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : prerequisites) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(v).add(u);
            degree[u]++;
        }
        Queue<Integer> pq = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                pq.offer(i);
                count++;
            }
        }
        if (count == 0) return new int[N];
        int[] result = new int[N];
        int index = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int node = pq.poll();
            result[index++] = node;
            cnt++;
            for (int it : adj.get(node)) {
                degree[it]--;
                if (degree[it] == 0) {
                    pq.offer(it);
                }
            }
        }
        if (cnt < N) return new int[N];
        return result;
    }

    public static boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        int[] degree = new int[N];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : prerequisites) {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
            degree[v]++;
        }

        Queue<Integer> pq = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                pq.offer(i);
                count++;
            }
        }

        if (count == 0) return false;
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            list.add(node);

            for (int it : adj.get(node)) {
                degree[it]--;
                if (degree[it] == 0) {
                    pq.offer(it);
                }
            }
        }
        if (list.size() == N) return true;
        return false;
    }

    public static int[] topoSort(int V, List<List<Integer>> adj) {
        // add your code here
        int size = adj.size();
        int[] degree = new int[V];
        for (int i = 0; i < size; i++) {
            int u = i;
            for (int j = 0; j < adj.get(i).size(); j++) {
                int v = adj.get(i).get(j);
                degree[v]++;
            }
        }

        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            list.add(node);

            for (int it : adj.get(node)) {
                degree[it]--;
                if (degree[it] == 0) {
                    pq.offer(it);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int it : hours) {
            if (it >= target) {
                count++;
            }
        }
        return count;
    }

    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int it : nums) {
            set.add(it);
        }
        int k = set.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int solve(int[] nums, int index, Map<Integer, Integer> map, int k, int cur) {
        if (index >= nums.length) {
            if (map.size() == k) {
                return 1;
            }
            return 0;
        }

        int pick = 0;
        if (cur == 1) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            pick = solve(nums, index + 1, map, k, 1);
            map.put(nums[index], map.get(nums[index]) - 1);
            if (map.get(nums[index]) == 0) {
                map.remove(nums[index]);
            }
        }
        int notPick = solve(nums, index + 1, map, k, 0);

        return notPick + pick;
    }

    /*public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int it : nums) {
            set.add(it);
        }
        int k = set.size();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if (map.size() == k) {
                count++;

                while (i < j) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if (map.get(nums[i]) == 0) {
                        map.remove(nums[i]);
                    }
                    if (map.size() < k) {
                        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                        break;
                    }
                    if (map.size() == k) {
                        count++;
                    }
                    i++;
                }
            }
            j++;
        }
        return count + 1;
    }

     */

    public static String minimumString(String a, String b, String c) {
        String re = printSuperSeq(a, b);
        return printSuperSeq(re, c);
    }

    static String printSuperSeq(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill table in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Below steps follow above recurrence
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Create a string of size index+1 to store the result
        String res = "";

        // Start from the right-most-bottom-most corner and
        // one by one store characters in res[]
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // If current character in a[] and b are same,
            // then current character is part of LCS
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                // Put current character in result
                res = a.charAt(i - 1) + res;

                // reduce values of i, j and indexes
                i--;
                j--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (dp[i - 1][j] < dp[i][j - 1]) {
                res = a.charAt(i - 1) + res;
                i--;
            } else {
                res = b.charAt(j - 1) + res;
                j--;
            }
        }

        // Copy remaining characters of string 'a'
        while (i > 0) {
            res = a.charAt(i - 1) + res;
            i--;
        }

        // Copy remaining characters of string 'b'
        while (j > 0) {
            res = b.charAt(j - 1) + res;
            j--;
        }

        // Print the result
        System.out.println(res);
        return res;
    }

}
