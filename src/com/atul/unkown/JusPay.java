
package com.atul.unkown;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JusPay {

    static Map<Integer, List<Integer>> adj = new HashMap<>();
    static boolean bfs(int s, int t) {
        Map<Integer, Integer> p = new HashMap<>();
        for (int x : adj.keySet()) {
            p.put(x, -1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        p.put(s, s);
        Map<Integer, Boolean> v = new HashMap<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            if (v.getOrDefault(u, false)) continue;
            v.put(u, true);
            if (u == t) {
                return true;
            }
            for (int x : adj.get(u)) {
                if (!v.getOrDefault(x, false)) {
                    q.add(x);
                    p.put(x, u);
                }
            }
        }
        return false;
    }

    static boolean dfs(int s, int d, int p) {
        if (s == d) return true;
        else {
            boolean f = false;
            for (int m : adj.get(s)) {
                if (m != p) {
                    f = dfs(m, d, s);
                }
                if (f) break;
            }
            return f;
        }
    }

    //2 question
    /*public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int e = Integer.parseInt(input[0]);
        for (int i = 0; i < e; i++) {
            int f = Integer.parseInt(br.readLine().trim());
            adj.put(f, new ArrayList<>());
        }
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            input = br.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            adj.get(b - 1).add(a - 1);
        }
        input = br.readLine().trim().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        List<Integer> ans = new ArrayList<>();
        for (int z : adj.get(y - 1)) {
            if (bfs(z, x - 1)) {
                ans.add(z + 1);
            }
        }
        for (int z : ans) {
            System.out.print(z + " ");
        }
    }
*/
    //third
    static class DSU {
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Integer> rank = new HashMap<>();

        public void addMember(int n) {
            parent.put(n, n);
            rank.put(n, 0);
        }

        public int getParent(int n) {
            if (parent.get(n).equals(n)) {
                return n;
            }
            int gPar = getParent(parent.get(n));
            parent.put(n, gPar);
            return parent.get(n);
        }

        public void union(int nodeU, int nodeV) {
            int parentU = getParent(nodeU);
            int parentV = getParent(nodeV);
            if (parentU == parentV)
                return;
            if (rank.get(parentU) < rank.get(parentV)) {
                parent.put(parentU, parentV);
            } else if (rank.get(parentV) < rank.get(parentU)) {
                parent.put(parentV, parentU);
            } else {
                parent.put(parentV, parentU);
                rank.put(parentU, rank.get(parentU) + 1);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        DSU dsu = new DSU();
        for (int i = 0; i < n; i++) {
            dsu.addMember(Integer.parseInt(sc.nextLine()));
        }
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            dsu.union(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        int one = Integer.parseInt(sc.nextLine());
        int two = Integer.parseInt(sc.nextLine());
        if ((dsu.getParent(one) == dsu.getParent(two))) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }


//1 question
/*
public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int vert = Integer.parseInt(bufferedReader.readLine());
            distance.put(vert, (int) 1e9);
            graph.putIfAbsent(vert, new ArrayList<>());
        }
        int m = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            String line = bufferedReader.readLine();
            String[] split = line.split(" ");
            int vertU = Integer.parseInt(split[0]);
            int vertV = Integer.parseInt(split[1]);
            int time = Integer.parseInt(split[2]);
            graph.get(vertU).add(new int[]{vertV, time});
        }
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a2 -> a2[1]));
        pq.offer(new int[]{a, 0});
        distance.put(a, 0);
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int vert = node[0];
            int time = node[1];
            for (int[] child : graph.get(vert)) {
                int newTime = time + child[1];
                int oldTime = distance.get(child[0]);
                if (newTime < oldTime) {
                    distance.put(child[0], newTime);
                    pq.offer(new int[]{child[0], newTime});
                }
            }
        }

        int ans = distance.get(b);
        if(ans == (int)1e9){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

 */
}
