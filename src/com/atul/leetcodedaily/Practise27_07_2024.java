package com.atul.leetcodedaily;

import java.util.*;

public class Practise27_07_2024 {
    public static void main(String[] args) {
        String str = "mxz";
        int k = 3;
        System.out.println(stringHash(str, k));
    }

    public static String stringHash(String s, int k) {
        int n = s.length();
        int count = 0;
        int sum = 0;
        String str = "";
        for (int i = 0; i < n; i++) {
            count++;
            sum += s.charAt(i)-97;
            if (count == k) {
                int rem = sum % 26;
                str += String.valueOf((char)(rem+97));
                sum = 0;
                count = 0;
            }
        }
        return str;
    }

    static class Pair9 {
        int x;
        int y;

        public Pair9(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        Queue<Pair9> pq = new PriorityQueue<>((a, b) -> calculateDistance(b) - calculateDistance(a));
        int[] result = new int[n];
        int count = 0;
        int index = 0;
        for (int[] it : queries) {
            pq.offer(new Pair9(it[0], it[1]));
            if (pq.size() > 4) {
                pq.poll();
            }

            count++;
            if (count < k) {
                result[index++] = -1;
            } else {
                result[index++] = calculateDistance(pq.poll());
            }
        }
        return result;
    }

    private static int calculateDistance(Pair9 p) {
        return Math.abs(p.x) + Math.abs(p.y);
    }

    public int generateKey(int num1, int num2, int num3) {
        String str1 = append(String.valueOf(num1));
        String str2 = append(String.valueOf(num2));
        String str3 = append(String.valueOf(num3));

        String result = "";
        for (int i = 0; i < 4; i++) {
            result += min(str1, str2, str3, i);
        }
        return Integer.parseInt(result);
    }

    private static int min(String str1, String str2, String str3, int index) {
        return Math.min(Integer.parseInt(String.valueOf(str1.charAt(index))), Math.min(Integer.parseInt(String.valueOf(str2.charAt(index))), Integer.parseInt(String.valueOf(str3.charAt(index)))));
    }

    private static String append(String sb) {
        if (sb.length() < 4) {
            int len = 4 - sb.length();
            for (int i = 0; i < len; i++) {
                sb = "0" + sb;
            }
        }

        return sb;
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        int k = original.length;
        if (k < n * m) return new int[][]{};
        int row = 0;
        int col = 0;
        for (int i = 0; i < k; i++) {
            if (col == n) {
                row++;
                col = 0;
            }
            if (row >= m || col >= n) {
                return new int[][]{};
            }
            result[row][col] = original[i];
            col++;
        }
        return result;
    }

    public static int solve(String str) {
        int n = str.length();
        Map<Character, Integer> caps = new HashMap<>();
        Map<Character, Integer> small = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                caps.putIfAbsent(ch, i);
            }

            if (ch >= 'a' && ch <= 'z') {
                small.put(ch, i);
            }
        }
        int result = 0;

        for (Map.Entry<Character, Integer> entry : small.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            char charToSearch = String.valueOf(key).toUpperCase().charAt(0);
            if (caps.containsKey(charToSearch) && caps.get(charToSearch) > val) {
                result++;
            }
        }
        return result;
    }

    static class Pair8 {
        int vert;
        double wt;

        public Pair8(int vert, double wt) {
            this.vert = vert;
            this.wt = wt;
        }
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair8>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int index = 0;
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            double wt = succProb[index++];
            list.get(u).add(new Pair8(v, wt));
            list.get(v).add(new Pair8(u, wt));
        }

        Queue<Pair8> pq = new LinkedList<>();
        pq.offer(new Pair8(start_node, 0));
        boolean[] seen = new boolean[n];
        seen[start_node] = true;

        double result = Double.MIN_VALUE;
        while (!pq.isEmpty()) {
            Pair8 p = pq.poll();
            int vert = p.vert;
            double wt = p.wt;
            if (vert == end_node) {
                System.out.println(wt);
                result = Math.max(result, wt);
            }

            for (Pair8 it : list.get(vert)) {
                if (seen[it.vert] == false) {
                    pq.offer(new Pair8(it.vert, wt + it.wt));
                }
            }
        }
        return result;
    }

    static class Pair7 {
        int vert;
        int wt;

        public Pair7(int vert, int wt) {
            this.vert = vert;
            this.wt = wt;
        }
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<Pair7>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            if (wt == -1) {
                list.get(u).add(new Pair7(v, 1));
            } else {
                list.get(u).add(new Pair7(v, wt));
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[source] = 0;

        Queue<Pair7> pq = new LinkedList<>();
        pq.offer(new Pair7(source, 0));
        while (!pq.isEmpty()) {
            Pair7 temp = pq.poll();
            int vert = temp.vert;
            int wt = temp.wt;
            for (Pair7 p : list.get(vert)) {
                if (wt + dist[p.vert] < wt + p.wt) {
                    dist[p.vert] = wt + p.wt;
                    pq.offer(new Pair7(p.vert, wt + p.wt));
                }
            }
        }
        return new int[][]{{}};
    }

    public static int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (solve(nums[i], nums[j]) || solve(nums[j], nums[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean solve(int i, int j) {
        String str1 = String.valueOf(i);
        int num1 = Integer.parseInt(str1);
        StringBuilder sb2 = new StringBuilder(String.valueOf(j));
        if (str1.length() == 1 && sb2.length() == 1 && str1.equals(sb2.toString())) {
            return true;
        }
        int n = sb2.length();
        for (int k = 0; k < n; k++) {
            for (int l = k + 1; l < n; l++) {
                char ch1 = sb2.charAt(k);
                char ch2 = sb2.charAt(l);
                sb2.replace(k, k + 1, String.valueOf(ch2));
                sb2.replace(l, l + 1, String.valueOf(ch1));
                if (Integer.parseInt(sb2.toString()) == num1) {
                    System.out.println(sb2 + "<<>>" + num1);
                    return true;
                }
                sb2.replace(k, k + 1, String.valueOf(ch1));
                sb2.replace(l, l + 1, String.valueOf(ch2));
            }
        }
        return false;
    }

    static class Pair6 {
        int val;
        int index;

        public Pair6(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        Queue<Pair6> pq = new PriorityQueue<>((a, b) -> a.val == b.val ? a.index - b.index : a.val - b.val);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair6(nums[i], i));
        }

        while (k-- > 0) {
            Pair6 temp = pq.poll();
            temp.val *= multiplier;
            pq.offer(temp);
        }

        for (int i = 0; i < n; i++) {
            Pair6 p = pq.poll();
            nums[p.index] = p.val;
        }
        return nums;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] it : prerequisites) {
            int u = it[0];
            int v = it[1];
            list.get(v).add(u);
        }

        boolean[] seen = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (seen[i] == false) {
                dfs(list, i, seen, stack);
            }
        }

        System.out.println(stack);

        Map<Integer, Integer> map = new HashMap<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            map.put(stack.pop(), i);
        }

        System.out.println(map);

        for (int[] it : prerequisites) {
            int u = it[0];
            int v = it[1];
            int uIndex = map.get(u);
            int vIndex = map.get(v);
            if (uIndex < vIndex) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> list, int node, boolean[] seen, Stack<Integer> stack) {
        seen[node] = true;
        for (int it : list.get(node)) {
            if (!seen[it]) {
                dfs(list, it, seen, stack);
            }
        }
        stack.push(node);
    }

    public static int minSteps(int n) {
        if (n == 1) return 0;
        return solve(n, 1, 1);
    }

    private static int solve(int n, int noOfA, int copy) {
        if (noOfA == n) {
            return 0;
        }
        if (noOfA > n) {
            return (int) 1e9;
        }

        int copyPaste = 2 + solve(n, noOfA * 2, noOfA);
        int paste = 1 + solve(n, noOfA + copy, copy);
        return Math.min(paste, copyPaste);
    }

    public static String fractionAddition(String str) {
        int n = str.length();
        List<Integer> num = new ArrayList<>();
        List<Character> opt = new ArrayList<>();
        List<Integer> deno = new ArrayList<>();

        int index = 0;
        while (index < n) {
            String nume = "";
            while (str.charAt(index) != '/') {
                nume += str.charAt(index);
                index++;
            }
            index++;
            num.add(Integer.parseInt(nume));
            String temp = "";
            while (index < n) {
                if ((str.charAt(index) == '+' || str.charAt(index) == '-')) {
                    break;
                }
                temp += str.charAt(index);
                index++;
            }
            if (index < n)
                opt.add(str.charAt(index));
            System.out.println("temp" + temp);
            deno.add(Integer.parseInt(temp));

        }

        System.out.println(num);
        System.out.println(opt);
        System.out.println(deno);
        return "";
    }

    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 && k == 1) return new int[]{nums[0]};
        Queue<Integer> pq = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);
        int[] result = new int[n - k + 1];
        int count = 1;
        int index = 0;
        for (int i = 1; i < n; i++) {
            count++;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (nums[i] - 1 != nums[i - 1]) {
                pq.offer(i);
            }

            if (count == k) {
                count--;
                int beginning = i - k + 1;
                if (!pq.isEmpty() && pq.peek() >= beginning && pq.peek() <= i) {
                    result[index++] = -1;
                } else {
                    result[index++] = map.lastEntry().getKey();
                }

                //removing from map ans also from queue;
                int begNum = nums[beginning];
                map.put(begNum, map.get(begNum) - 1);
                if (map.get(begNum) == 0) {
                    map.remove(begNum);
                }
                if (!pq.isEmpty() && beginning + 1 == pq.peek()) {
                    pq.poll();
                }
            }
        }

        return result;
    }

    public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        Map<String, Long> map = new HashMap<>();
        long result1 = solve(energyDrinkA, energyDrinkB, 0, true, map);
        long result2 = solve(energyDrinkA, energyDrinkB, 0, false, map);
        return Math.max(result1, result2);
    }

    private static long solve(int[] nums1, int[] nums2, int i, boolean cur, Map<String, Long> dp) {
        if (i >= nums1.length) {
            return 0;
        }
        String str = i + "|" + cur;
        if (dp.containsKey(str)) return dp.get(str);
        if (cur) {
            long result = Math.max(nums1[i] + solve(nums1, nums2, i + 1, true, dp), solve(nums1, nums2, i + 1, false, dp));
            dp.put(str, result);
            return result;
        } else {
            long result = Math.max(solve(nums1, nums2, i + 1, true, dp), nums2[i] + solve(nums1, nums2, i + 1, false, dp));
            dp.put(str, result);
            return result;
        }
    }

    static class Pair5 {
        int val;
        int index;

        public Pair5(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair5{" +
                    "" + val +
                    ",  " + index +
                    '}';
        }
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        List<Pair5> curr = new ArrayList<>();
        int index = 0;
        for (List<Integer> list : arrays) {
            for (int it : list) {
                curr.add(new Pair5(it, index));
            }
            index++;
        }
        Collections.sort(curr, (a, b) -> a.val - b.val);
        System.out.println(curr);
        int size = curr.size();
        int left = 0;
        int right = size - 1;
        while (left < right) {
            Pair5 first = curr.get(left);
            Pair5 last = curr.get(right);
            if (first.index == last.index) {
                int cond1 = Integer.MIN_VALUE;
                int cond2 = Integer.MIN_VALUE;
                int cond3 = Integer.MIN_VALUE;

                if (left + 1 < right) {
                    cond1 = calMaxValue(last, curr.get(left + 1));
                }
                if (right - 1 > left) {
                    cond2 = calMaxValue(curr.get(right - 1), first);
                }
                if (right - 1 > left + 1) {
                    cond3 = calMaxValue(curr.get(right - 1), curr.get(left + 1));
                }
                int result = Math.max(cond1, Math.max(cond2, cond3));
                if (result != Integer.MIN_VALUE) return result;
            } else {
                return Math.max(last.val - first.val, first.val - last.val);
            }
            left++;
            right--;
        }
        return 0;
    }

    private static int calMaxValue(Pair5 first, Pair5 last) {
        if (first.index != last.index) {
            return Math.max(last.val - first.val, first.val - last.val);
        }
        return Integer.MIN_VALUE;
    }

    public static boolean lemonadeChange(int[] bills) {
        int noOfFives = 0;
        int noOfTens = 0;
        for (int it : bills) {
            if (it == 5) {
                noOfFives++;
            } else if (it == 10) {
                if (noOfFives >= 1) {
                    noOfFives--;
                    noOfTens++;
                } else return false;
            } else {
                int fives = (noOfFives - 1) * 5;
                int tens = noOfTens * 10;
                if (noOfFives >= 1 && (fives + tens >= 15)) {
                    if (tens >= 1) {
                        noOfTens--;
                        noOfFives--;
                    } else {
                        noOfFives -= 3;
                    }
                } else return false;
            }
        }
        return true;
    }

    public static int minDays(int[][] grid) {
        //calculate current island;
        int n = grid.length;
        int m = grid[0].length;

        int count = calculateCurrentIsland(grid);
        System.out.println(count + "<<>>");
        if (count > 1 || count == 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int currentCount = calculateCurrentIsland(grid);
                    if (currentCount > 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private static int calculateCurrentIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] seen = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    dfs(grid, i, j, seen);
                    count++;
                }
            }
        }
        return count;
    }

    static int[] xdir = {1, -1, 0, 0};
    static int[] ydir = {0, 0, 1, -1};

    private static void dfs(int[][] grid, int i, int j, boolean[][] seen) {
        seen[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int xtemp = xdir[k] + i;
            int ytemp = ydir[k] + j;
            if (xtemp >= 0 && xtemp < grid.length && ytemp >= 0 && ytemp < grid[0].length &&
                    grid[xtemp][ytemp] == 1 && !seen[xtemp][ytemp]) {
                dfs(grid, xtemp, ytemp, seen);
            }
        }
    }

    public static int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int[] count = new int[1];
        dfs(list, 0, new boolean[n], count);
        return count[0];
    }

    private static int dfs(List<List<Integer>> list, int node, boolean[] seen, int[] count) {
        seen[node] = true;
        List<Integer> temp = new ArrayList<>();
        for (int it : list.get(node)) {
            if (!seen[it]) {
                temp.add(dfs(list, it, seen, count));
            }
        }

        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int it : temp) {
            sum += it;
            set.add(it);
        }

        if (set.isEmpty() || set.size() == 1) {
            count[0]++;
        }
        return sum + 1;
    }

    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = n * 3;
        int[][] nums = new int[m][m];

        int y = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            int size = grid[i].length();
            String str = grid[i];
            for (int j = 0; j < size; j++) {
                char ch = str.charAt(j);
                fill(nums, x, y, ch);
            }
            y += 3;
        }

        //System.out.println(Arrays.deepToString(nums));
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        return 0;
    }

    private static void fill(int[][] nums, int i, int j, char ch) {
        if (ch == '/') {
            int index = j + 3;
            for (int k = i; k < i + 3; k++) {
                nums[k][index--] = 1;
            }
        } else {
            int index = j;
            for (int k = i; k < i + 3; k++) {
                nums[k][index++] = 1;
            }
        }
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < m - 3; j++) {

            }
        }
        return 1;
    }

    private static boolean check(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[10];

        //row sum check +
        int[] row = new int[n];
        int index = 0;
        for (int i = x; i < x + 3; i++) {
            int sum = 0;
            for (int j = y; j < y + 3; j++) {
                nums[grid[i][j] - 1]++;
                sum += grid[i][j];
            }
            row[index++] = sum;
        }

        for (int i = 0; i < n; i++) {

        }
        return false;
    }


    static class Pair4 {
        int color;
        int fre;

        public Pair4(int color, int fre) {
            this.color = color;
            this.fre = fre;
        }
    }

    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        for (int[] it : pick) {
            int first = it[0];
            int sec = it[1];

            Map<Integer, Integer> temp = map.get(first);
            map.get(first).put(sec, temp.getOrDefault(sec, 0) + 1);
        }

        int count = 0;
//        for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
//            int player = entry.getKey();
//            Map<Integer, Integer> color = entry.getValue();
//            for (Map.Entry<Integer, Integer> ent : color.entrySet()) {
//                int val = ent.getValue();
//                if (val >= player + 1) {
//                    count++;
//                    break;
//                }
//            }
//        }
        return count;
    }

    public static int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int rowCount = 0;
        for (int[] it : grid) {
            rowCount += flipRequired(it);
        }

        int colCount = 0;
        for (int i = 0; i < m; i++) {
            int[] newCol = new int[n];
            for (int j = 0; j < n; j++) {
                newCol[j] = grid[j][i];
            }
            colCount += flipRequired(newCol);
        }

        return Math.min(rowCount, colCount);
    }

    private static int flipRequired(int[] nums) {
        int n = nums.length;
        int first = 0;
        int last = n - 1;
        int count = 0;
        while (first < last) {
            if (nums[first] != nums[last]) {
                count++;
            }
            first++;
            last--;
        }
        return count;
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.putIfAbsent(i, new TreeSet<>());
            map.get(i).add(i + 1);
        }
        int[] result = new int[m];


        //preparing graph
        List<List<Pair3>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            list.get(i).add(new Pair3(i + 1, 1));
        }

        for (int i = 0; i < m; i++) {
            int first = queries[i][0];
            int sec = queries[i][1];
            list.get(first).add(new Pair3(sec, 1));
            int dij = dij(list, n);
            result[i] = dij;
        }
        return result;
    }

    static class Pair3 {
        int vert;
        int dis;

        public Pair3(int vert, int dis) {
            this.vert = vert;
            this.dis = dis;
        }
    }

    private static int dij(List<List<Pair3>> list, int n) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        Queue<Pair3> pq = new LinkedList<>();
        pq.offer(new Pair3(0, 0));
        while (!pq.isEmpty()) {
            Pair3 temp = pq.poll();
            int vert = temp.vert;
            int dis = temp.dis;
            for (Pair3 it : list.get(vert)) {
                if (dis + 1 < distance[it.vert]) {
                    pq.offer(new Pair3(it.vert, dis + 1));
                    distance[it.vert] = dis + 1;
                }
            }
        }
        return distance[n - 1];
    }


    static class Pair1 {
        String str;
        int val;

        public Pair1(String str, int val) {
            this.str = str;
            this.val = val;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        Queue<Pair1> pq = new LinkedList<>();
        pq.offer(new Pair1(beginWord, 0));

        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair1 p = pq.poll();
                int m = p.str.length();
                for (int j = 0; j < m; j++) {
                    for (char k = 'a'; k <= 'z'; k++) {

                    }
                }
            }
        }

        return 0;
    }


    private static void trav(char[][] grid) {
        for (char[] it : grid) {
            System.out.println(Arrays.toString(it));
        }
    }

    static class Pair {
        int x;
        int y;
        int val;

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void solveUp(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


    }

    public static void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] seen = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    solve(grid, i, j, seen);
                }
            }
        }
    }

    private static boolean solve(char[][] grid, int i, int j, boolean[][] seen) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 'O' && (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1)) {
            return false;
        }
        if (grid[i][j] == 'X' || seen[i][j]) {
            return true;
        }

        seen[i][j] = true;
        boolean top = solve(grid, i - 1, j, seen);
        boolean bottom = solve(grid, i + 1, j, seen);
        boolean left = solve(grid, i, j - 1, seen);
        boolean right = solve(grid, i, j + 1, seen);

        if (top && bottom && left && right) {
            grid[i][j] = 'X';
            return true;
        }
        return false;
    }

    public static int[][] updateMatrix2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> pq = new LinkedList<>();
        int[][] dist = new int[n][m];
        boolean[][] seen = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    pq.offer(new Pair(i, j, 0));
                    seen[i][j] = true;
                }
            }
        }

        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.x;
            int y = pair.y;
            dist[x][y] = pair.val;
            for (int i = 0; i < 4; i++) {
                int newX = xcor[i] + pair.x;
                int newY = ycor[i] + pair.y;
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && seen[newX][newY] == false) {
                    pq.offer(new Pair(newX, newY, pair.val + 1));
                    seen[newX][newY] = true;
                }
            }
        }

        return dist;
    }


    public static int numTeams(int[] rating) {
        return solve(rating, 0, "", new HashMap<>());
    }

    private static int solve(int[] nums, int index, String str, Map<String, Integer> map) {
        String[] num = str.split(",");
        if (num.length == 3) {
            int first = Integer.parseInt(num[0]);
            int second = Integer.parseInt(num[1]);
            int third = Integer.parseInt(num[2]);
            if ((first < second && second < third) || (first > second && second > third)) {
                return 1;
            }
            return 0;
        }
        if (index >= nums.length) {
            return 0;
        }

        String st = index + "|" + str;
        if (map.containsKey(st)) return map.get(st);

        int pick = solve(nums, index + 1, str + nums[index] + ",", map);
        int notPick = solve(nums, index + 1, str, map);

        map.put(st, pick + notPick);
        return pick + notPick;
    }

    public boolean canAliceWin(int[] nums) {
        long single = 0;
        long doub = 0;
        for (int it : nums) {
            String num = String.valueOf(it);
            if (num.length() == 1) {
                single += it;
            } else {
                doub += it;
            }
        }

        if (single > doub) return true;
        else if (doub > single) return true;
        return false;
    }

    static class Tuple {
        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Tuple> pq = new LinkedList<>();
        //boolean[][] seen = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    pq.offer(new Tuple(i, j, 0));
                    //mat[i][j] = solveBFS(i, j, mat);
                }
            }
        }

        int[] xdir = {1, -1, 0, 0};
        int[] ydir = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Tuple temp = pq.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = xdir[j] + temp.x;
                    int newY = ydir[j] + temp.y;
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                        pq.offer(new Tuple(newX, newY, temp.val + 1));
                        //seen[newX][newY] = true;
                    }
                }
            }
        }

        return mat;
    }

    private static int solveBFS(int x, int y, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] xdir = {1, -1, 0, 0};
        int[] ydir = {0, 0, 1, -1};
        Queue<Tuple> pq = new LinkedList<>();
        boolean[][] seen = new boolean[n][m];

        pq.offer(new Tuple(x, y, 0));
        seen[x][y] = true;

        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Tuple temp = pq.poll();
                if (grid[temp.x][temp.y] == 0) {
                    return temp.val;
                }
                for (int j = 0; j < 4; j++) {
                    int newX = xdir[j] + temp.x;
                    int newY = ydir[j] + temp.y;
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && seen[newX][newY] == false) {
                        pq.offer(new Tuple(newX, newY, temp.val + 1));
                        seen[newX][newY] = true;
                    }
                }
            }
        }
        return 0;
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        long[][] chars = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    chars[i][j] = 0;
                } else {
                    chars[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int wt = cost[i];
            chars[u][v] = Math.min(chars[u][v], wt);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chars[i][k] != Integer.MAX_VALUE && chars[k][j] != Integer.MAX_VALUE) {
                        chars[i][j] = Math.min(chars[i][j], chars[i][k] + chars[k][j]);
                    }
                }
            }
        }

        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (u != v) {
                if (chars[u][v] == Integer.MAX_VALUE) {
                    return -1;
                } else {
                    result += chars[u][v];
                }
            }
        }
        return result;
    }

}
