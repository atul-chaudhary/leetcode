package com.atul.unkown;



import java.util.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practise {
    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(8);
        node.left.left = new Node(4);
        node.left.right = new Node(12);
        node.left.right.left = new Node(10);
        node.left.right.right = new Node(14);


        node.right = new Node(22);

        System.out.println(KDistanceNodes(node, 8, 2));
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here
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

    public static void printRootToLeafPaths(Node node, Deque<Integer> path, ArrayList<ArrayList<Integer>> result) {
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
