package com.atul.unkown;

import java.util.*;

public class Practise {
    public static void main(String[] args) {
        List<Integer> tasks = Arrays.asList(2, 3, 1, 2, 5, 8, 4, 3);
        List<Integer> proce = Arrays.asList(8, 10);
        System.out.println(minProcessingTime(proce, tasks));
    }

    public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int n = tasks.size();
        Collections.sort(tasks);
        int index = 0;
        int cur = n / 4;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            int num = tasks.get(i);
            int cal = processorTime.get(index) + num;
            max = Math.max(max, cal);
            if (count == cur) {
                count = 0;
            }
        }
        return max;
    }

    public int differenceOfSums(int n, int m) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                sum += i;
            }
        }

        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sum2 += i;
            }
        }

        return sum - sum2;
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }

        long result = Long.MIN_VALUE;
        for (int i = 1; i <= n - 2; i++) {
            long cur = left[i - 1] - nums[i];
            result = Math.max(cur * right[i + 1], result);
        }
        return result;
    }

    public static long maximumTripletValueNotOpt(int[] nums) {
        int n = nums.length;
        int curIndex = -1;
        int maxTillNow = nums[0];
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            int num = maxTillNow - nums[i];
            if (num > max) {
                max = num;
                curIndex = i;
            }
            maxTillNow = Math.max(maxTillNow, nums[i]);
        }


        System.out.println(max + "<<>>");
        int maxCur = 1;
        for (int i = curIndex + 1; i < n; i++) {
            maxCur = Math.max(maxCur, nums[i]);
        }

        long result = (long) max * maxCur;
        if (result < 0) return 0;
        return result;
    }

    public static long maximumTripletValuetry(int[] nums) {
        int n = nums.length;
        int firstIndex = -1;
        int first = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > first) {
                first = nums[i];
                firstIndex = i;
            }
        }

        int secIndex = -1;
        int sec = Integer.MAX_VALUE;
        for (int i = firstIndex + 1; i < n - 1; i++) {
            if (nums[i] < sec) {
                sec = nums[i];
                secIndex = i;
            }
        }

        int thirdIndex = -1;
        int third = Integer.MIN_VALUE;
        for (int i = secIndex + 1; i < n; i++) {
            if (nums[i] > third) {
                third = nums[i];
                thirdIndex = i;
            }
        }

        long num = (long) (nums[firstIndex] - nums[secIndex]) * nums[thirdIndex];
        if (num < 0) return 0;
        return num;
    }

    public long maximumTripletValue1(int[] nums) {
        int n = nums.length;
        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long num = (long) (nums[i] - nums[j]) * nums[k];
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }

    public static int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        for (List<Integer> it : composition) {
            int res = binarySearch(it, stock, cost, budget);
            ans = Math.max(ans, res);
        }
        return ans;
    }

    private static int binarySearch(List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget) {
        int first = 0;
        int last = (int) 1e9;
        int result = 0;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (check(mid, composition, stock, cost, budget)) {
                result = mid;
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return result;
    }

    private static boolean check(int cur, List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget) {
        int n = stock.size();
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (long) (Math.max((cur * composition.get(i) - stock.get(i)), 0)) * cost.get(i);
        }
        return total <= budget;
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int it = countSetBits(i);
            if (it == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }


    //00,25,50,75
    public static int minimumOperations(String num) {
        int n = num.length();
        int index5 = num.lastIndexOf("5");
        int index0 = num.lastIndexOf("0");
        int ans = n;

        if (index0 != -1) {
            for (int i = index0 - 1; i >= 0; i--) {
                int cur = Integer.parseInt(String.valueOf(num.charAt(i)));
                if (cur == 0 || cur == 5) {
                    int val = n - (index0 + 1);
                    val += (index0 - (i + 1));
                    ans = Math.min(ans, val);
                }
            }
            ans = Math.min(ans, n - 1);
        }

        if (index5 != -1) {
            for (int i = index5 - 1; i >= 0; i--) {
                int cur = Integer.parseInt(String.valueOf(num.charAt(i)));
                if (cur == 2 || cur == 7) {
                    int val = n - (index5 + 1);
                    val += (index5 - (i + 1));
                    ans = Math.min(ans, val);
                }
            }
        }

        return Math.min(ans, n);
    }

    public static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        //code here
        int[][] grid = new int[n][n];
        for (int[] it : grid) {
            Arrays.fill(it, -1);
        }
        int len = edges.length;
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            grid[u][v] = wt;
            grid[v][u] = wt;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    grid[i][j] = 0;
                }
                if (grid[i][j] == -1) {
                    grid[i][j] = (int) 1e9;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (grid[i][j] <= distanceThreshold) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }

        System.out.println(map);
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int val = map.getOrDefault(i, 0);
            if (val <= min) {
                min = val;
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

    public void shortest_distance(int[][] matrix) {
        // Code here
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                }

                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = Math.min(matrix[j][i], matrix[j][j] + matrix[j][i]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }

    }

    static class TupleY {
        int i;
        int j;
        int wt;

        public TupleY(int i, int j, int wt) {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }

        public TupleY(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "{" +
                    +i + ","
                    + j + ","
                    + wt + "," +
                    '}';
        }
    }

    static int mod = (int) 1e9 + 7;

    private static int dijKat(List<List<TupleY>> adj, int src, int dst, int n) {
        Queue<TupleY> pq = new PriorityQueue<>((a, b) -> a.j - b.j);
        pq.offer(new TupleY(src, 0));

        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[src] = 0;
        while (!pq.isEmpty()) {
            TupleY temp = pq.poll();
            int u = temp.i;
            int wt = temp.j;
            if (u == dst) {
                return wt;
            }
            for (TupleY it : adj.get(u)) {
                if (it.j + wt < dis[it.i]) {
                    dis[it.i] = it.j + wt;
                    pq.offer(new TupleY(it.i, it.j + wt));
                }
            }
        }
        return -1;
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here]
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(start);

        int level = 0;

        while (!pq.isEmpty()) {
            int size = pq.size();
            level++;
            for (int i = 0; i < size; i++) {
                int node = pq.poll();
                if (node == end) {
                    return level - 1;
                }
                for (int it : arr) {
                    if (it * node <= end) {
                        pq.offer((it * node) % 100000);
                    }
                }
            }
        }

        return -1;
    }

    public static int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Code here
        List<List<TupleY>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : flights) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            //adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new TupleY(v, wt));
        }
        System.out.println(adj);
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        Queue<TupleY> pq = new LinkedList<>();
        pq.offer(new TupleY(src, 0, 0));

        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            TupleY temp = pq.poll();
            int vert = temp.i;
            int price = temp.j;
            int stops = temp.wt;

            if (stops <= k + 1 && vert == dst) {
                min = Math.min(min, price);
            }

            for (TupleY it : adj.get(vert)) {
                int vertIt = it.i;
                int priceIt = it.j;
                if (priceIt + price < dist[vertIt] && stops + 1 <= k + 1) {
                    dist[vertIt] = price + priceIt;
                    pq.offer(new TupleY(vertIt, dist[vertIt], stops + 1));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static int MinimumEffort(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = (int) 1e9;
            }
        }
        dis[0][0] = 0;

        Queue<TupleY> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new TupleY(0, 0, 0));

        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            TupleY temp = pq.poll();
            int i = temp.i;
            int j = temp.j;
            int diff = temp.wt;

            if (i == n - 1 && j == m - 1) return diff;

            for (int k = 0; k < 4; k++) {
                int xtemp = xcor[k] + i;
                int ytemp = ycor[k] + j;
                if (isValid(grid, xtemp, ytemp)) {
                    int newDiff = Math.max(Math.abs(grid[xtemp][ytemp] - grid[i][j]), diff);
                    if (newDiff < dis[xtemp][ytemp]) {
                        pq.offer(new TupleY(xtemp, ytemp, newDiff));
                        dis[xtemp][ytemp] = newDiff;
                    }
                }
            }
        }

        return 0;
    }

    private static boolean isValid(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Your code here

        int n = grid.length;
        int m = grid[0].length;

        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};

        boolean[][] vis = new boolean[n][m];
        vis[source[0]][source[1]] = true;

        Queue<TupleY> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new TupleY(source[0], source[1], 0));

        while (!pq.isEmpty()) {
            TupleY temp = pq.poll();
            int i = temp.i;
            int j = temp.j;
            int wt = temp.wt;

            if (i == destination[0] && j == destination[1]) {
                return wt;
            }

            for (int k = 0; k < 4; k++) {
                int xtemp = xcor[k] + i;
                int ytemp = ycor[k] + j;

                if (xtemp < 0 || xtemp >= n || ytemp < 0 || ytemp >= m || grid[xtemp][ytemp] == 0 || vis[xtemp][ytemp]) {
                    continue;
                }

                pq.offer(new TupleY(xtemp, ytemp, wt + 1));
                vis[xtemp][ytemp] = true;
            }
        }

        return -1;
    }


    static class PairY {
        int vert;
        int wt;

        public PairY(int vert, int wt) {
            this.vert = vert;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "{" +
                    +vert + ","
                    + wt +
                    '}';
        }
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here

        List<List<PairY>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            adj.get(u).add(new PairY(v, wt));
            adj.get(v).add(new PairY(u, wt));
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        dist[1] = 0;
        Queue<PairY> pq = new LinkedList<>();
        pq.offer(new PairY(1, 0));

        while (!pq.isEmpty()) {
            PairY pairY = pq.poll();
            int node = pairY.vert;
            int wt = pairY.wt;

            for (PairY it : adj.get(node)) {
                if (wt + it.wt < dist[it.vert]) {
                    dist[it.vert] = wt + it.wt;
                    parent[it.vert] = node;
                    pq.offer(new PairY(it.vert, wt + it.wt));
                }
            }
        }

//        System.out.println(Arrays.toString(dist));
        //      System.out.println(Arrays.toString(parent));

        if (dist[n] == (int) 1e9) {
            return Collections.singletonList(-1);
        }

        List<Integer> result = new ArrayList<>();
        result.add(n);
        int index = n;
        while (parent[index] != index) {
            result.add(parent[index]);
            index = parent[index];
        }
        Collections.reverse(result);
        return result;
    }

    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Code here
        Set<String> set = new HashSet<>();
        for (String it : wordList) set.add(it);

        Queue<ArrayList<String>> pq = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(startWord);
        pq.offer(arrayList);

        int level = 0;
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        ArrayList<String> usedWords = new ArrayList<>();
        while (!pq.isEmpty()) {
            int size = pq.size();

            if (usedWords.size() > level) {
                level++;
                for (String it : usedWords) {
                    set.remove(it);
                }
            }
            for (int i = 0; i < size; i++) {
                ArrayList<String> list = pq.poll();
                String last = list.get(list.size() - 1);
                if (last.equals(targetWord)) {
                    result.add(list);
                }
                int len = last.length();
                for (int j = 0; j < len; j++) {
                    char[] chars = last.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        String formed = new String(chars);
                        if (set.contains(formed)) {
                            list.add(formed);
                            pq.offer(new ArrayList<>(list));
                            usedWords.add(formed);
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }
        }

        return result;
    }

    public ArrayList<ArrayList<String>> findSequencesYO(String startWord, String targetWord, String[] wordList) {

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set<String> st = new HashSet<String>();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }

        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations.
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        // A vector to store the resultant transformation sequence.
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int cnt = 0;

        // BFS traversal with pushing the new formed sequence in queue
        // when after a transformation, a word is found in wordList.
        while (!q.isEmpty()) {
            cnt++;
            ArrayList<String> vec = q.peek();
            q.remove();

            // Now, erase all words that have been
            // used in the previous levels to transform
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // store the answers if the end word matches with targetWord.
            if (word.equals(targetWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will
                        // remove from everywhere
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        // mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }

            }
        }
        return ans;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        int[] check = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                path(adj, vis, pathVis, i, check);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    /*public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (path(adj, vis, pathVis, i)) {
                    return true;
                }
            }
        }
        return false;
    }
     */

    private static boolean path(List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, int node,
                                int[] nodes) {
        vis[node] = true;
        pathVis[node] = true;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                if (path(adj, vis, pathVis, it, nodes)) {
                    return true;
                }
            } else if (pathVis[it]) {
                return true;
            }
        }
        nodes[node] = 1;
        pathVis[node] = false;
        return false;
    }


    static class Color {
        int val;
        int color;

        public Color(int val, int color) {
            this.val = val;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "val=" + val +
                    ", color=" + color +
                    '}';
        }
    }

    public static boolean isBipartite(int V, List<List<Integer>> adj) {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color, -1);
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (color(adj, i, vis, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean color(List<List<Integer>> adj, int curNode, boolean[] vis, int[] col) {
        Queue<Color> pq = new LinkedList<>();
        pq.offer(new Color(curNode, 0));
        vis[curNode] = true;
        while (!pq.isEmpty()) {
            Color c = pq.poll();
            int node = c.val;
            int color = c.color;
            for (int it : adj.get(node)) {
                if (vis[it] == false) {
                    pq.offer(new Color(it, 1 - color));
                    vis[it] = true;
                    col[it] = 1 - color;
                } else if (col[it] != -1 && color == col[it]) {
                    return true;
                }
            }
        }
        return false;
    }


    static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(grid, i, j, list, vis);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    static class Typle {
        int i;
        int j;
        int[] cor;

        public Typle(int i, int j, int[] cor) {
            this.i = i;
            this.j = j;
            this.cor = cor;
        }

        public Typle(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void dfs(int[][] grid, int i, int j, List<String> list, boolean[][] vis) {
        Queue<Typle> pq = new LinkedList<>();
        pq.offer(new Typle(i, j, new int[]{i, j}));
        vis[i][j] = true;

        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};
        while (!pq.isEmpty()) {
            Typle node = pq.poll();
            int x = node.i;
            int y = node.j;
            int[] cor = node.cor;
            list.add(toString(cor[0], cor[1], x, y));
            for (int k = 0; k < 4; k++) {
                int xtemp = xcor[k] + x;
                int ytemp = ycor[k] + y;
                if (normal(grid, xtemp, ytemp) && !vis[xtemp][ytemp] && grid[xtemp][ytemp] == 1) {
                    pq.offer(new Typle(xtemp, ytemp, new int[]{x, y}));
                    vis[xtemp][ytemp] = true;
                }
            }
        }
    }

    protected static String toString(int i, int j, int x, int y) {
        return (i - x) + "|" + (j - y);
    }

    static char[][] fill(int n, int m, char[][] grid) {
        // code here
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 'O') {
                fil(grid, 0, i, vis);
            }

            if (grid[n - 1][i] == 'O') {
                fil(grid, n - 1, i, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') {
                fil(grid, i, 0, vis);
            }
            if (grid[i][m - 1] == 'O') {
                fil(grid, i, m - 1, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }

        return grid;
    }

    private static void fil(char[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j]) return;
        vis[i][j] = true;
        fil(grid, i, j - 1, vis);
        fil(grid, i, j + 1, vis);
        fil(grid, i - 1, j, vis);
        fil(grid, i + 1, j, vis);
    }

    static class Dis {
        int i;
        int j;
        int dist;

        public Dis(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public static int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] temp = new int[n][m];

        Queue<Dis> pq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    pq.offer(new Dis(i, j, 0));
                }

                temp[i][j] = grid[i][j];
                if (grid[i][j] == 0) {
                    temp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            Dis node = pq.poll();
            int i = node.i;
            int j = node.j;
            int dis = node.dist;
            temp[i][j] = Math.min(temp[i][j], dis);
            for (int k = 0; k < 4; k++) {
                int xtemp = xcor[k] + i;
                int ytemp = ycor[k] + j;
                if (normal(grid, xtemp, ytemp) && temp[xtemp][ytemp] > dis + 1) {
                    pq.offer(new Dis(xtemp, ytemp, dis + 1));
                    temp[xtemp][ytemp] = dis + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    temp[i][j] = 0;
                }
            }
        }
        return temp;
    }

    private static boolean normal(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    public static boolean isCycle(int V, List<List<Integer>> adj) {
        // Code here
        int[] parent = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (solveBFS(adj, vis, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class PairTuple {
        int val;
        int parent;

        public PairTuple(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    private static boolean solveBFS(List<List<Integer>> adj, boolean[] vis, int node) {
        Queue<PairTuple> pq = new LinkedList<>();
        pq.offer(new PairTuple(node, -1));
        vis[node] = true;
        while (!pq.isEmpty()) {
            PairTuple pair = pq.poll();
            int val = pair.val;
            int web = pair.parent;
            for (int it : adj.get(val)) {
                if (vis[it] == false) {
                    pq.offer(new PairTuple(it, val));
                    vis[it] = true;
                } else if (web != it) {
                    return true;
                }
            }
        }
        return false;
    }


    static class PairRot {
        int i;
        int j;
        int time;

        public PairRot(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

        @Override
        public String toString() {
            return "PairRot{" +
                    "i=" + i +
                    ", j=" + j +
                    ", time=" + time +
                    '}';
        }
    }

    public static int orangesRotting(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<PairRot> pq = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    pq.offer(new PairRot(i, j, 0));
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};
        int result = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            PairRot pairRot = pq.poll();
            int i = pairRot.i;
            int j = pairRot.j;
            int time = pairRot.time;
            result = Math.max(result, time);
            for (int k = 0; k < 4; k++) {
                int xtemp = xcor[k] + i;
                int ytemp = ycor[k] + j;
                if (check(grid, vis, xtemp, ytemp)) {
                    pq.offer(new PairRot(xtemp, ytemp, time + 1));
                    vis[xtemp][ytemp] = true;
                    grid[xtemp][ytemp] = 2;
                }
            }
        }
        boolean isFreshFound = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    isFreshFound = true;
                    break;
                }
            }
        }
        if (isFreshFound) return -1;
        else return result;
    }

    private static boolean check(int[][] grid, boolean[][] vis, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || grid[i][j] == 0 || grid[i][j] == 2) {
            return false;
        }
        return true;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == sr && j == sc) {
                    fill(image, i, j, newColor, vis);
                }
            }
        }
        return image;
    }

    private static void fill(int[][] image, int i, int j, int color, boolean[][] vis) {
        vis[i][j] = true;
        int currentColor = image[i][j];
        image[i][j] = color;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int xTemp = xcor[k] + i;
            int yTemp = ycor[k] + j;
            if (isValid(image, xTemp, yTemp, vis, currentColor)) {
                fill(image, xTemp, yTemp, color, vis);
            }
        }
    }

    private static boolean isValid(int[][] grid, int i, int j, boolean[][] vis, int color) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || grid[i][j] != color) {
            return false;
        }
        return true;
    }


    public static int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == false) {
                    solveDFS(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private static void solveDFSLeetcode(char[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        //int[][] cor = {{-1, -1}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int xTemp = xcor[k] + i;
            int yTemp = ycor[k] + j;
            if (isValid(grid, xTemp, yTemp, vis)) {
                solveDFS(grid, xTemp, yTemp, vis);
            }
        }
    }

    private static void solveDFS(char[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        int[][] cor = {{-1, -1}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int k = 0; k < 8; k++) {
            int xTemp = cor[k][0] + i;
            int yTemp = cor[k][1] + j;
            if (isValid(grid, xTemp, yTemp, vis)) {
                solveDFS(grid, xTemp, yTemp, vis);
            }
        }
    }

    private static boolean isValid(char[][] grid, int i, int j, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || grid[i][j] == '0') {
            return false;
        }
        return true;
    }

    static int numProvinces(List<List<Integer>> adj, int V) {
        // code here
        boolean[] vis = new boolean[V + 1];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfsAll(adj, i, new ArrayList<>(), vis);
                count++;
            }
        }
        return count;
    }

    private static void dfsAll(List<List<Integer>> adj, int node, ArrayList<Integer> result, boolean[] vis) {
        //result.add(node);
        vis[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (adj.get(node).get(i) == 1 && vis[i] == false) {
                dfsAll(adj, i, result, vis);
            }
        }
    }

    private static void dfs(List<List<Integer>> adj, int node, ArrayList<Integer> result, boolean[] vis) {
        //result.add(node);
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (adj.get(node).get(it) == 1 && vis[it] == false) {
                dfs(adj, it, result, vis);
            }
        }
    }


    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(0);
        boolean[] vis = new boolean[V];
        while (!pq.isEmpty()) {
            int node = pq.poll();
            result.add(node);
            for (int it : adj.get(node)) {
                if (vis[it] == false) {
                    pq.offer(it);
                    vis[it] = true;
                }
            }
        }
        return result;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                index = i;
            }
        }
        return index;
    }

    public static boolean searchPattern(String str, String pat) {
        // code here
        int n = str.length();
        int m = pat.length();
        int[][] dp = new int[n + 1][m + 1];

        int len = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    len = Math.max(len, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return len == m;
    }


    private static int pattern(String s1, String s2, int i, int j, int cur) {
        if (i >= s1.length() || j >= s2.length()) return cur;

        if (s1.charAt(i) == s2.charAt(j)) {
            cur = pattern(s1, s2, i + 1, j + 1, cur + 1);
        }
        return Math.max(cur, Math.max(pattern(s1, s2, i + 1, j, 0), pattern(s1, s2, i, j + 1, 0)));
    }

    public int LongestRepeatingSubsequence(String s1) {
        // code here
        int n = s1.length();
        String s2 = s1;
        Integer[][] dp = new Integer[n + 1][n + 1];
        return lcsRE(s1, s2, 0, 0, dp);
    }

    private static int lcsRE(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (i != j && s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsRE(s1, s2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(lcsRE(s1, s2, i + 1, j, dp), lcsRE(s1, s2, i, j + 1, dp));
        }
    }


    public static int longestCommonSubstr(String s1, String s2, int n, int m) {
        // code here
        int min = Math.min(n, m);
        Integer[][][] dp = new Integer[n + 1][m + 1][min + 1];
        return LongestCommonSubString(s1, s2, n, m, 0, dp);
    }


    public static int LongestCommonSubString(String x, String y, int m, int n, int curr_max, Integer[][][] dp) {
        if (m == 0 || n == 0) return curr_max;

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return dp[m][n][curr_max] = LongestCommonSubString(x, y, m - 1, n - 1, curr_max + 1, dp);

        return dp[m][n][curr_max] = Math.max(LongestCommonSubString(x, y, m - 1, n, 0, dp), LongestCommonSubString(x, y, m, n - 1, 0, dp));
    }


    private static int lcsSub(String s1, String s2, int i, int j, Integer[][] dp, int cur, int[] max) {
        if (i >= s1.length() || j >= s2.length()) {
            return cur;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            max[0] = lcsSub(s1, s2, i + 1, j + 1, dp, cur + 1, max);
        }
        int temp = Math.max(lcsSub(s1, s2, i + 1, j, dp, 0, max), lcsSub(s1, s2, i, j + 1, dp, 0, max));
        max[0] = Math.max(max[0], temp);
        return dp[i][j] = max[0];
    }

    static int lcs(int x, int y, String s1, String s2) {
        // your code here
        Integer[][] dp = new Integer[x + 1][y + 1];
        return lcs(s1, s2, 0, 0, dp);
    }

    private static int lcs(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(lcs(s1, s2, i + 1, j, dp), lcs(s1, s2, i, j + 1, dp));
        }
    }

    public static int minCoins(int coins[], int M, int V) {
        // Your code goes here
        Integer[][] dp = new Integer[M + 1][V + 1];
        int result = coin(coins, V, 0, dp);
        return result == (int) 1e9 ? -1 : result;
    }

    private static int coin(int[] coin, int v, int index, Integer[][] dp) {
        if (v == 0) return 0;
        if (index >= coin.length) return (int) 1e9;

        if (dp[index][v] != null) return dp[index][v];

        int pick = (int) 1e9;
        if (coin[index] <= v)
            pick = 1 + coin(coin, v - coin[index], index, dp);
        int notPick = coin(coin, v, index + 1, dp);
        return dp[index][v] = Math.min(pick, notPick);
    }

    public static long count(int coins[], int N, int sum) {
        // code here.
        Long[][] dp = new Long[N + 1][sum + 1];
        return change(coins, sum, 0, dp);
    }

    private static long change(int[] coin, int sum, int index, Long[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (index >= coin.length) {
            return 0;
        }

        if (dp[index][sum] != null) return dp[index][sum];
        long pick = 0;
        if (coin[index] <= sum)
            pick = change(coin, sum - coin[index], index, dp);
        long notPick = change(coin, sum, index + 1, dp);
        return dp[index][sum] = pick + notPick;
    }

    public static int cutRod(int price[], int n) {
        //code here
        Integer[][] dp = new Integer[n + 1][n + 1];
        return cutRodUtil(price, price.length - 1, n, dp);
    }

    static int cutRodUtil(int[] price, int ind, int N, Integer[][] dp) {

        if (ind == 0) {
            return N * price[0];
        }

        if (dp[ind][N] != null)
            return dp[ind][N];

        int notTaken = 0 + cutRodUtil(price, ind - 1, N, dp);

        int taken = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= N)
            taken = price[ind] + cutRodUtil(price, ind, N - rodLength, dp);

        return dp[ind][N] = Math.max(notTaken, taken);
    }

    static int knapSack(int N, int W, int val[], int wt[]) {
        // code here
        Integer[][] dp = new Integer[N + 1][W + 1];
        return knapUn(val, wt, 0, W, dp);
    }

    private static int knapUn(int[] price, int[] weight, int index, int w, Integer[][] dp) {
        if (index >= price.length) return 0;
        if (dp[index][w] != null) return dp[index][w];

        if (weight[index] <= w) {
            int pick = price[index] + knapUn(price, weight, index, w - weight[index], dp);
            int notPick = knapUn(price, weight, index + 1, w, dp);
            return dp[index][w] = Math.max(pick, notPick);
        } else {
            return dp[index][w] = knapUn(price, weight, index + 1, w, dp);
        }
    }

    static int findTargetSumWays(int[] nums, int n, int target) {
        // code here
        //Integer[][] dp = new Integer[n + 1][target + 1];
        Map<String, Integer> dp = new HashMap<>();
        return solveTarget(nums, 0, target, 0, dp);
    }

    private static int solveTarget(int[] nums, int index, int target, int cur, Map<String, Integer> dp) {
        if (cur == target && index == nums.length) return 1;
        if (index >= nums.length) return 0;

        String key = index + "|" + cur;
        if (dp.containsKey(key)) return dp.get(key);

        int add = solveTarget(nums, index + 1, target, cur + nums[index], dp);
        int sub = solveTarget(nums, index + 1, target, cur - nums[index], dp);

        dp.put(key, add + sub);
        return add + sub;
    }

    public static int countPartitions(int n, int d, int arr[]) {
        // Code here
        // Your code goes here
        int sum = 0;
        for (int it : arr) {
            sum += it;
        }
        Integer[][] dp = new Integer[arr.length + 1][sum + 1];
        return diff(arr, 0, sum, 0, dp, d);
    }

    static int countPartitionsUtil(int ind, int target, int[] arr, int[][] dp) {
//        if (ind == 0) {
//            if (target == 0 && arr[0] == 0)
//                return 2;
//            if (target == 0 || target == arr[0])
//                return 1;
//            return 0;
//        }

        if (target == 0 && ind == 0) {
            return 1;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];
        int notTaken = countPartitionsUtil(ind - 1, target, arr, dp);
        int taken = 0;
        if (arr[ind] <= target)
            taken = countPartitionsUtil(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = (notTaken + taken) % mod;
    }

    private static int diff(int[] nums, int index, int totalSum, int sum, Integer[][] dp, int diff) {
        if (index >= nums.length) {
            int remain = totalSum - sum;
            if (sum - remain == diff) {
                return 1;
            }
            return 0;
        }
        if (dp[index][sum] != null) return dp[index][sum];
        int pick = diff(nums, index + 1, totalSum, sum + nums[index], dp, diff) % mod;
        int notPick = diff(nums, index + 1, totalSum, sum, dp, diff) % mod;
        return dp[index][sum] = (pick + notPick) % mod;
    }


    public static int minDifference(int arr[], int n) {
        // Your code goes here
        int sum = 0;
        for (int it : arr) {
            sum += it;
        }
        Integer[][] dp = new Integer[arr.length + 1][sum + 1];
        return 0;//diff(arr, 0, sum, 0, dp, d);
    }

    public static int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        Integer[][] dp = new Integer[n + 1][sum + 1];
        return solve(arr, 0, sum, dp);
    }

    //    static int mod = (int) 1e9 + 7;
    private static int solve(int[] nums, int index, int sum, Integer[][] dp) {
        if (sum == 0 && index == nums.length) return 1;
        if (index >= nums.length) return 0;
        if (dp[index][sum] != null) return dp[index][sum];

        if (nums[index] <= sum) {
            int pick = solve(nums, index + 1, sum - nums[index], dp) % mod;
            int notPick = solve(nums, index + 1, sum, dp) % mod;
            return dp[index][sum] = (pick + notPick) % mod;
        } else {
            return dp[index][sum] = solve(nums, index + 1, sum, dp) % mod;
        }
    }

    static int equalPartition(int N, int arr[]) {
        // code here
        int sum = 0;
        for (int it : arr) {
            sum += it;
        }
        if (sum % 2 != 0) return 0;
        Boolean[][] dp = new Boolean[N + 1][sum + 1];
        return solve(arr, 0, sum / 2, dp) ? 1 : 0;
    }


    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // code here
        Boolean[][] dp = new Boolean[N + 1][sum + 1];
        return solve(arr, 0, sum, dp);
    }

    private static boolean solve(int[] nums, int index, int sum, Boolean[][] dp) {
        if (sum == 0) return true;
        if (index >= nums.length) return false;
        if (dp[index][sum] != null) return dp[index][sum];

        if (nums[index] <= sum) {
            boolean pick = solve(nums, index + 1, sum - nums[index], dp);
            boolean notPick = solve(nums, index + 1, sum, dp);
            return dp[index][sum] = pick || notPick;
        } else {
            return dp[index][sum] = solve(nums, index + 1, sum, dp);
        }
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        Integer[][] dp = new Integer[n + 1][W + 1];
        return knap(val, wt, 0, W, dp);
    }

    private static int knap(int[] price, int[] weight, int index, int w, Integer[][] dp) {
        if (index >= price.length) return 0;
        if (dp[index][w] != null) return dp[index][w];

        if (weight[index] <= w) {
            int pick = price[index] + knap(price, weight, index + 1, w - weight[index], dp);
            int notPick = knap(price, weight, index + 1, w, dp);
            return dp[index][w] = Math.max(pick, notPick);
        } else {
            return dp[index][w] = knap(price, weight, index + 1, w, dp);
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

    }

    public static Node buildTree(int inorder[], int postOrder[], int n) {
        // code here
        Map<Integer, TreeSet<Integer>> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.putIfAbsent(inorder[i], new TreeSet<>());
            inMap.get(inorder[i]).add(i);
        }
        return formTreePost(inorder, 0, n - 1, postOrder, 0, n - 1, inMap);
    }

    private static Node formTreePost(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart,
                                     int postEnd, Map<Integer, TreeSet<Integer>> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        Node node = new Node(postOrder[postEnd]);
        int idx = inMap.get(node.data).first();
        inMap.get(node.data).remove(idx);
        int leftItem = idx - inStart;

        node.left = formTreePost(inorder, inStart, idx - 1, postOrder, postStart, postStart + leftItem - 1, inMap);
        node.right = formTreePost(inorder, idx + 1, inEnd, postOrder, postStart + leftItem, postEnd - 1, inMap);
        return node;
    }


    public static int countNodes(Node root) {
        // Code here
        if (root == null) return 0;

        int left = left(root.left);
        int right = right(root.right);

        if (left == right) return (2 << left - 1);

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int left(Node root) {
        Node node = root;
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    private static int right(Node root) {
        Node node = root;
        int count = 0;
        while (node != null) {
            count++;
            node = node.right;
        }
        return count;
    }


    public static int minTime(Node root, int target) {
        // Your code goes here
        if (root == null) return 0;
        Map<Node, Node> parentMap = new HashMap<>();
        Node[] count = new Node[1];
        parent(root, null, parentMap, count, target);

        Set<Node> vis = new HashSet<>();

        int level = 0;
        Queue<Node> pq = new LinkedList<>();
        pq.offer(count[0]);
        vis.add(count[0]);
        while (!pq.isEmpty()) {
            int size = pq.size();
            level++;
            for (int i = 0; i < size; i++) {
                Node node = pq.poll();
                if (node.left != null && !vis.contains(node.left)) {
                    pq.offer(node.left);
                    vis.add(node.left);
                }
                if (node.right != null && !vis.contains(node.right)) {
                    pq.offer(node.right);
                    vis.add(node.right);
                }
                if (parentMap.get(node) != null && !vis.contains(parentMap.get(node))) {
                    pq.offer(parentMap.get(node));
                    vis.add(parentMap.get(node));
                }
            }
        }
        return level - 1;
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist'
        if (root == null) return new ArrayList<>();
        Map<Node, Node> parentMap = new HashMap<>();
        Node[] count = new Node[1];
        parent(root, null, parentMap, count, target);

        //System.out.println(parentMap);
        Set<Node> vis = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        int level = 0;
        Queue<Node> pq = new LinkedList<>();
        pq.offer(count[0]);
        vis.add(count[0]);
        while (!pq.isEmpty()) {
            int size = pq.size();
            level++;
            for (int i = 0; i < size; i++) {
                Node node = pq.poll();
                if (level == k + 1) {
                    result.add(node.data);
                }
                if (node.left != null && !vis.contains(node.left)) {
                    pq.offer(node.left);
                    vis.add(node.left);
                }
                if (node.right != null && !vis.contains(node.right)) {
                    pq.offer(node.right);
                    vis.add(node.right);
                }
                if (parentMap.get(node) != null && !vis.contains(parentMap.get(node))) {
                    pq.offer(parentMap.get(node));
                    vis.add(parentMap.get(node));
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    private static void parent(Node node, Node parent, Map<Node, Node> map, Node[] target, int tar) {
        if (node == null) {
            return;
        }
        parent(node.left, node, map, target, tar);
        if (node.data == tar) {
            target[0] = node;
        }
        map.put(node, parent);
        parent(node.right, node, map, target, tar);
    }


    static class Tuple {
        int left;
        int right;
        Node node;

        public Tuple(int left, int right, Node node) {
            this.left = left;
            this.right = right;
            this.node = node;
        }
    }

    static class Pair2 {
        Node node;
        int val;

        public Pair2(Node node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    static int getMaxWidth(Node root) {
        // Your code here
        if (root == null) return 0;
        Queue<Pair2> pq = new LinkedList<>();
        pq.offer(new Pair2(root, 1));
        int result = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int size = pq.size();
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                Pair2 pair2 = pq.poll();
                Node temp = pair2.node;
                if (i == 0) {
                    first = pair2.val;
                }

                if (i == size - 1) {
                    last = pair2.val;
                }
                int val = pair2.val;
                if (temp.left != null) {
                    pq.offer(new Pair2(temp.left, val * 2));
                }

                if (temp.right != null) {
                    pq.offer(new Pair2(temp.right, val * 2 + 1));
                }
            }
            result = Math.max(result, last - first + 1);
        }
        return result;
    }


    Node lca(Node root, int n1, int n2) {
        // Your code here
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // Code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        paths(root, result, new ArrayList<>());
        //printRootToLeafPaths(root, new ArrayDeque<>(), result);
        return result;
    }

    private static void paths(Node root, ArrayList<ArrayList<Integer>> result, List<Integer> list) {
        if (root == null) return;

        list.add(root.data);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
            //return;
        }
        paths(root.left, result, list);
        paths(root.right, result, list);
        if (!list.isEmpty())
            list.remove(list.size() - 1);
    }

    public static void printRootToLeafPaths(Node
                                                    node, Deque<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }

        path.addLast(node.data);
        if (isLeaf(node)) {
            //System.out.println(path);
            result.add(new ArrayList<>(path));
            //return;
        }

        printRootToLeafPaths(node.left, path, result);
        printRootToLeafPaths(node.right, path, result);
        path.removeLast();
    }

    public static boolean isSymmetric(Node root) {
        // add your code here;
        return sym(root.left, root.right);
    }

    private static boolean sym(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 == null) return false;
        if (root1 == null && root2 != null) return false;
        if (root1.data != root2.data) return false;

        return sym(root1.left, root2.left) && sym(root1.right, root2.right);
    }

    static ArrayList<Integer> rightView(Node root) {
        //add code here.
        if (root == null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, 0, root));
        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();
            int x = temp.left;
            int y = temp.right;
            Node node = temp.node;

            if (!map.containsKey(y)) {
                map.put(y, node.data);
            }

            if (node.right != null) {
                pq.offer(new Tuple(x + 1, y + 1, node.right));
            }
            if (node.left != null) {
                pq.offer(new Tuple(x - 1, y + 1, node.left));
            }

        }
        //System.out.println(map);
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }


    static ArrayList<Integer> leftView(Node root) {
        //add code here.
        if (root == null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, 0, root));
        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();
            int x = temp.left;
            int y = temp.right;
            Node node = temp.node;

            if (!map.containsKey(y)) {
                map.put(y, node.data);
            }

            if (node.left != null) {
                pq.offer(new Tuple(x - 1, y + 1, node.left));
            }
            if (node.right != null) {
                pq.offer(new Tuple(x + 1, y + 1, node.right));
            }
        }
        System.out.println(map);
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static ArrayList<Integer> bottomView(Node root) {
        // Code here
        if (root == null) return new ArrayList<>();
        Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, 0, root));
        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();
            int x = temp.left;
            int y = temp.right;
            Node node = temp.node;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new ArrayList<>());
            map.get(x).get(y).add(node.data);

            if (node.left != null) {
                pq.offer(new Tuple(x - 1, y + 1, node.left));
            }
            if (node.right != null) {
                pq.offer(new Tuple(x + 1, y + 1, node.right));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            int key = entry.getKey();
            TreeMap<Integer, List<Integer>> temp = entry.getValue();
            List<Integer> list = temp.lastEntry().getValue();
            result.add(list.get(list.size() - 1));
        }
        return result;
    }

    static ArrayList<Integer> topView(Node root) {
        // add your code
        if (root == null) return new ArrayList<>();
        Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, 0, root));
        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();
            int x = temp.left;
            int y = temp.right;
            Node node = temp.node;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new ArrayList<>());
            map.get(x).get(y).add(node.data);

            if (node.left != null) {
                pq.offer(new Tuple(x - 1, y + 1, node.left));
            }
            if (node.right != null) {
                pq.offer(new Tuple(x + 1, y + 1, node.right));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            int key = entry.getKey();
            TreeMap<Integer, List<Integer>> temp = entry.getValue();
            result.add(temp.firstEntry().getValue().get(0));
        }
        return result;
    }


    static ArrayList<Integer> verticalOrder(Node root) {
        // add your code here
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, 0, root));
        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();
            int x = temp.left;
            int y = temp.right;
            Node node = temp.node;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new ArrayList<>());
            map.get(x).get(y).add(node.data);

            if (node.left != null) {
                pq.offer(new Tuple(x - 1, y + 1, node.left));
            }
            if (node.right != null) {
                pq.offer(new Tuple(x + 1, y + 1, node.right));
            }
        }

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
            int key = entry.getKey();
            Map<Integer, List<Integer>> temp = entry.getValue();
            for (Map.Entry<Integer, List<Integer>> ent : temp.entrySet()) {
                result.addAll(ent.getValue());
            }
        }

        System.out.println(map);

        return result;
    }


    ArrayList<Integer> boundary(Node node) {
        if (node == null) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (isLeaf(node) == false)
            result.add(node.data);
        addLeft(node.left, result);
        addLeaveNode(node, result);
        addRight(node.right, result);
        return result;
    }

    private static void addRight(Node root, ArrayList<Integer> list) {
        Node node = root;
        ArrayList<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (isLeaf(node) == false) temp.add(node.data);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        Collections.reverse(temp);
        list.addAll(temp);
    }

    private static void addLeaveNode(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        addLeaveNode(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.data);
        }
        addLeaveNode(root.right, list);
    }

    private static void addLeft(Node root, ArrayList<Integer> list) {
        Node node = root;
        while (node != null) {
            if (isLeaf(node) == false) list.add(node.data);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    private static boolean isLeaf(Node root) {
        if (root != null && root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    ArrayList<Integer> zigZagTraversal(Node root) {
        //Add your code here.
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> pq = new LinkedList<>();
        pq.offer(root);
        boolean dir = true;
        while (!pq.isEmpty()) {
            int size = pq.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = pq.poll();
                temp.add(node.data);
                if (node.left != null) {
                    pq.offer(node.left);
                }
                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            if (dir) {
                result.addAll(temp);
                dir = false;
            } else {
                Collections.reverse(temp);
                result.addAll(temp);
                dir = true;
            }
        }
        return result;
    }


    static boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            if (root1.data == root2.data) {
                return true;
            }
            return false;
        }


        boolean left = isIdentical(root1.left, root2.left);
        boolean right = isIdentical(root1.right, root2.right);
        return root1.data == root2.data && (left && right);
    }


    int findMaxSum(Node node) {
        //your code goes here
        int[] count = new int[1];
        count[0] = Integer.MIN_VALUE;
        return path(node, count);
    }

    private static int path(Node root, int[] count) {
        if (root == null) {
            return 0;
        }

        int left = root.data + path(root.left, count);
        int right = root.data + path(root.right, count);
        count[0] = Math.max(count[0], left + right + root.data);
        return Math.max(left, right);
    }

    int diameter(Node root) {
        // Your code here
        int[] count = new int[1];
        count[0] = Integer.MIN_VALUE;
        width(root, count);
        return count[0];
    }

    private static int width(Node root, int[] max) {
        if (root == null) return 0;

        int left = width(root.left, max);
        int right = width(root.right, max);

        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }

    boolean isBalanced(Node root) {
        // Your code here
        int result = solveHeight(root);
        if (result == -1) return false;
        return true;
    }

    private static int solveHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int left = solveHeight(root.left);
        if (left == -1) {
            return -1;
        }

        int right = solveHeight(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public static int maxDepth(Node root) {
        // code here
        return solve(root);
    }

    private static int solve(Node root) {
        if (root == null) return 0;
        int left = 1 + solve(root.left);
        int right = 1 + solve(root.right);

        return Math.max(left, right);
    }

    static ArrayList<Integer> levelOrder(Node node) {
        // Your code here
        if (node == null) return null;
        Queue<Node> pq = new LinkedList<>();
        pq.offer(node);
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Node temp = pq.poll();
                result.add(temp.data);
                if (temp.left != null) {
                    pq.offer(temp.left);
                }

                if (temp.right != null) {
                    pq.offer(temp.right);
                }
            }
        }
        return result;
    }

    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> trav = new ArrayList<>();
        solve(root, trav);
        return trav;
    }

    private static void solvePostOrder(Node root, ArrayList<Integer> trav) {
        if (root == null) return;
        solvePostOrder(root.left, trav);
        solvePostOrder(root.right, trav);
        trav.add(root.data);
    }

    private static void solveInorder(Node root, ArrayList<Integer> trav) {
        if (root == null) return;
        solve(root.left, trav);
        trav.add(root.data);
        solve(root.right, trav);
    }

    static ArrayList<Integer> preorder(Node root) {
        // Code here
        ArrayList<Integer> trav = new ArrayList<>();
        solve(root, trav);
        return trav;
    }

    private static void solve(Node root, ArrayList<Integer> trav) {
        if (root == null) return;
        trav.add(root.data);
        solve(root.left, trav);
        solve(root.right, trav);
    }


    static int finalAns = Integer.MIN_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] kids = new int[k];
        solve(0, kids, cookies);
        return finalAns;
    }

    private static void solve(int index, int[] kids, int[] cook) {
        if (index == cook.length) {
            int max = Integer.MIN_VALUE;
            for (int it : kids) {
                max = Math.max(max, it);
            }
            finalAns = Math.max(finalAns, max);
            return;
        }

        for (int i = 0; i < kids.length; i++) {
            kids[i] += cook[index];
            solve(index + 1, kids, cook);
            kids[i] -= cook[index];
        }
    }

    static class PairT {
        int j;
        double prob;

        public PairT(int j, double prob) {
            this.j = j;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<PairT>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];
            double prob = succProb[i];

            adj.get(x).add(new PairT(y, prob));
            adj.get(y).add(new PairT(x, prob));
        }

        boolean[] vis = new boolean[n];

        Queue<PairT> pq = new PriorityQueue<>((a, b) -> (int) (b.prob - a.prob));
        pq.offer(new PairT(start, 1));

        double result = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            PairT node = pq.poll();
            if (node.j == end) result = Math.max(result, node.prob);
            vis[node.j] = true;
            for (PairT it : adj.get(node.j)) {
                if (vis[it.j] == false) {
                    pq.offer(new PairT(it.j, node.prob * it.prob));
                }
            }
        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }

    static int binarysearch(int arr[], int n, int k) {
        // code here
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (long it : A) {
            pq.offer(it);

            if (pq.size() > K2) {
                pq.poll();
            }
        }
        System.out.println(pq);

        long k2 = pq.peek();
        long cur = K2;
        while (!pq.isEmpty() && cur > K1) {
            pq.poll();
            cur--;
        }

        //System.out.println(k2);
        long k1 = pq.peek();
        //System.out.println(k1);
        long sum = 0;
        for (long it : A) {
            if (it > k1 && it < k2) {
                sum += it;
            }
        }
        return sum;
    }


    static class Pair {
        int val;
        int fre;

        public Pair(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] result = new int[k];
        int index = 0;
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.fre - a.fre);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                result[index++] = pq.poll().val;
            }
        }
//        int[] result = new int[k];
//        int index = 0;
//        while (k > 0) {
//            result[index++] = pq.poll().val;
//            k--;
//        }
        return result;
    }


    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        // your code here
        Queue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int it : arr) {
            pq.offer(it);

            if (pq.size() > k) {
                result.add(pq.poll());
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        int[] temp = Arrays.copyOf(arr, arr.length);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(arr[i], set);
            } else {
                map.get(arr[i]).add(i);
            }
        }
        Arrays.sort(temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(map);
        for (int i = 0; i < n; i++) {
            if (temp[i] == arr[i]) continue;
            int item = arr[i];
            Set<Integer> set = map.get(item);
            System.out.println(i + "<<>>" + k);
            if (!set.contains(i + k)) {
                return "No";
            }
        }
        return "Yes";
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        // code here
        Queue<Integer> pq = new PriorityQueue<>();
        for (int it : arr) {
            pq.offer(it);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static int kthSmallestopt(int[] arr, int l, int r, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : arr) {
            pq.offer(it);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        //Your code here
        Queue<Integer> pq = new PriorityQueue<>();
        for (int it : arr) {
            pq.offer(it);
        }
        int result = -1;
        while (k > 0) {
            result = pq.poll();
            k--;
        }
        return result;
    }
}
