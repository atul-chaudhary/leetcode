package com.atul.leetcodedaily;

import java.util.*;

public class Practise07_07_2025 {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        String[] word = {"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        System.out.println(findWords(board, word));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        for (String str : words) {
            if (finder(str, board)) {
                result.add(str);
            }
        }
        return result;
    }

    static class Pair {
        int x;
        int y;
        int nextIndex;
        String word;

        public Pair(int x, int y, int nextIndex, String word) {
            this.x = x;
            this.y = y;
            this.nextIndex = nextIndex;
            this.word = word;
        }
    }

    private static boolean finder(String word, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        char ch = word.charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ch) {
                    if(finddfs(word, ""+ch, 0, board, i, j, new boolean[n][m], new boolean[n][m])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int[] xdir = {1, -1, 0, 0};
    static int[] ydir = {0, 0, -1, 1};

    private static boolean finddfs(String word, String cur, int index, char[][] board, int i, int j, boolean[][] seen, boolean[][] pathVis) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || seen[i][j] || pathVis[i][j] || index >= word.length() || word.charAt(index) != cur.charAt(index)) {
            return false;
        }

        seen[i][j] = true;
        pathVis[i][j] = true;
        if (word.equals(cur)) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int xtemp = xdir[k] + i;
            int ytemp = ydir[k] + j;
            if(xtemp  < 0 || xtemp >= board.length || ytemp < 0 || ytemp >= board[0].length){
                continue;
            }
            if (finddfs(word, cur + board[xtemp][ytemp], index + 1, board, xtemp, ytemp, seen, pathVis)) {
                return true;
            }
        }
        cur = cur.substring(0, cur.length() - 1);
        pathVis[i][j] = false;

        return false;
    }

    private static boolean find(String word, char[][] board, Pair pair, boolean[][] seen) {
        int[] xdir = {1, -1, 0, 0};
        int[] ydir = {0, 0, -1, 1};
        int n = board.length;
        int m = board[0].length;


        Queue<Pair> pq = new LinkedList<>();
        pq.offer(pair);
        seen[pair.x][pair.y] = true;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.word.equals(word)) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int xtemp = xdir[i] + p.x;
                int ytemp = ydir[i] + p.y;

                if (xtemp < 0 || xtemp >= n || ytemp < 0 || ytemp >= m ||
                        (p.nextIndex != -1 && board[xtemp][ytemp] != word.charAt(p.nextIndex)) || seen[xtemp][ytemp]
                ) {
                    continue;
                }
                pq.offer(new Pair(xtemp, ytemp,
                        word.length() > p.nextIndex + 1 ? p.nextIndex + 1 : -1,
                        p.word + word.charAt(p.nextIndex)));
                seen[xtemp][ytemp] = true;
            }
        }
        return false;
    }

    NodeTrie root;

    public void addWord(String word) {
        NodeTrie node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.insert(ch, new NodeTrie());
            }
            node = node.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        NodeTrie node = root;
        return solve(node, word);
    }

    private static boolean solve(NodeTrie node, String word) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (NodeTrie it : node.nodes) {
                    if (it != null && solve(it, word.substring(i + 1))) return true;
                }
                return false;
            }
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return node != null && node.isEnd;
    }

    public static int countDistinctSubstring(String st) {
        // your code here
        int n = st.length();
        NodeTrie root = new NodeTrie();
        int count = 0;
        for (int i = 0; i < n; i++) {
            NodeTrie node = root;
            for (int j = i; j < n; j++) {
                char ch = st.charAt(j);
                if (!node.containsKey(ch)) {
                    count++;
                    node.insert(ch, new NodeTrie());
                }
                node = node.get(ch);
            }
        }
        return count + 1;
    }

    public static String longestValidWord(String[] words) {
        // code here
        NodeTrie root = new NodeTrie();
        for (String str : words) {
            int n = str.length();
            NodeTrie node = root;
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if (!node.containsKey(ch)) {
                    node.insert(ch, new NodeTrie());
                }
                node = node.get(ch);
            }
            node.isEnd = true;
        }

        Arrays.sort(words);
        String result = "";
        for (String str : words) {
            int n = str.length();
            NodeTrie node = root;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if (!node.get(ch).isEnd) {
                    flag = false;
                    break;
                }
                node = node.get(ch);
            }
            if (node.isEnd && flag) {
                String s1 = result;
                String s2 = str;
                if (result.isEmpty()) {
                    result = str;
                } else if (s2.length() > s1.length()) {
                    result = s2;
                } else if (s1.length() == s2.length()) {
                    if (s1.compareTo(s2) < 0) {
                        result = s1;
                    } else if (s1.compareTo(s2) > 0) {
                        result = s2;
                    }
                }
            }
        }
        return result;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        NodeTrie nodeTrie = new NodeTrie();
        for (String string : wordDict) {
            int n = string.length();
            NodeTrie temp = nodeTrie;
            for (int i = 0; i < n; i++) {
                char ch = string.charAt(i);
                if (!temp.containsKey(ch)) {
                    temp.insert(ch, new NodeTrie());
                }

                temp = temp.get(ch);
            }
            temp.isEnd = true;
        }

        NodeTrie root = nodeTrie;
        int m = s.length();
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (!root.containsKey(ch)) return false;
            if (root.get(ch).isEnd) {
                root = nodeTrie;
                continue;
            }
            root = root.get(ch);
        }
        return true;
    }

    static class NodeTrie {
        NodeTrie nodes[] = new NodeTrie[26];
        int count;
        boolean isEnd;

        NodeTrie() {
        }

        NodeTrie(int val) {
            this.count = val;
        }

        public boolean containsKey(char ch) {
            return nodes[ch - 'a'] != null;
        }

        public NodeTrie get(char ch) {
            return nodes[ch - 'a'];
        }

        public void insert(char ch, NodeTrie node) {
            nodes[ch - 'a'] = node;
        }

    }

    public static String longestCommonPrefix(String[] strs) {
        NodeTrie root = new NodeTrie();
        for (String it : strs) {
            NodeTrie node = root;
            int n = it.length();
            for (int i = 0; i < n; i++) {
                char ch = it.charAt(i);
                if (!node.containsKey(ch)) {
                    node.insert(ch, new NodeTrie());
                }
                node.get(ch).count++;
                node = node.get(ch);
            }
        }

        String result = "";
        String word = strs[0];
        NodeTrie temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.containsKey(ch) || temp.get(ch).count != strs.length) {
                return result;
            }
            temp = temp.get(ch);
            result += ch;
        }
        return result;
    }

    public String serialize(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                sb.append(node).append(",");
                if (node.left != null) {
                    pq.offer(node.left);
                } else {
                    sb.append("#").append(",");
                }

                if (node.right != null) {
                    pq.offer(node.right);
                } else {
                    sb.append("#").append(",");
                }
            }
            sb.append("Y");
        }
        return sb.toString();
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return solvedfs(preorder, inorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode solvedfs(int[] preOrder, int[] inOrder, Map<Integer, Integer> map,
                                     int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int idx = map.get(preOrder[preStart]);
        int len = idx - inStart;

        TreeNode node = new TreeNode(preOrder[preStart]);

        node.left = solvedfs(preOrder, inOrder, map, preStart + 1, preStart + len, inStart, idx - 1);
        node.right = solvedfs(preOrder, inOrder, map, preStart + len + 1, preEnd, idx + 1, inEnd);

        return node;
    }

    private static int index(int[] inOrder, int val) {
        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            if (inOrder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        return solvedfd(root, k, count);
    }

    private static int solvedfd(TreeNode root, int k, int[] count) {
        if (root == null) return -1;

        int left = solvedfd(root.left, k, count);
        if (left != -1) return left;

        count[0]++;
        if (count[0] == k) return root.val;


        int right = solvedfd(root.right, k, count);
        if (right != -1) return right;

        return -1;
    }

    public static boolean isValidBST(TreeNode root) {
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean solve(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (!(root.val >= min && root.val <= max)) {
            return false;
        }
        if (solve(root.left, min, root.val) == false) return false;
        if (solve(root.right, root.val, max) == false) return false;
        return true;
    }

    public static String processStr(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch == '*') {
                if (sb.length() >= 1) {
                    sb.replace(sb.length() - 1, sb.length(), "");
                }
            } else if (ch == '#') {
                sb.append(sb);
            } else {
                sb.reverse();
            }
        }
        return sb.toString();
    }

    private static boolean validate(TreeNode root, int parent, boolean isleft, boolean isRight) {
        if (root == null) return true;

        if (isleft) {
            if (parent != -1 && root.val >= parent) return false;
        }
        if (isRight) {
            if (parent != -1 && root.val < parent) return false;
        }
        if (!validate(root.left, root.val, true, false)) return false;
        if (!validate(root.right, root.val, false, true)) return false;

        return true;
    }

    public static int goodNodes(TreeNode root) {
        int[] count = new int[1];
        inline(root, Integer.MIN_VALUE, count);
        return count[0];
    }

    private static void inline(TreeNode root, int maxTillNow, int[] count) {
        if (root == null) return;
        if (root.val >= maxTillNow) count[0]++;
        inline(root.left, Math.max(root.val, maxTillNow), count);
        inline(root.right, Math.max(root.val, maxTillNow), count);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        solve(root, 0, 0, map);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, List<Integer>> val = entry.getValue();
            List<Integer> list = val.lastEntry().getValue();
            result.add(list.get(list.size() - 1));
        }
        return result;
    }

    private static void solve(TreeNode root, int x, int y, Map<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }

        map.putIfAbsent(y, new TreeMap<>());
        map.get(y).putIfAbsent(x, new ArrayList<>());
        map.get(y).get(x).add(root.val);
        solve(root.left, x - 1, y + 1, map);
        solve(root.right, x + 1, y + 1, map);
    }

    class Node {
        Node[] nodes = new Node[26];
        int countPref = 0;
        int countEnds = 0;

        Node() {
        }

        public boolean containskey(char ch) {
            return nodes[ch - 'a'] != null;
        }

        public void insert(char ch, Node node) {
            nodes[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return nodes[ch - 'a'];
        }
    }

    public class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            // Write your code here.
            Node node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!node.containskey(ch)) {
                    node.insert(ch, new Node());
                }
                node = node.get(ch);
                node.countPref++;
            }
            node.countEnds++;
        }

        public int countWordsEqualTo(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.get(ch);
            }
            return node.countEnds;
        }

        public int countWordsStartingWith(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.get(ch);
            }
            return node.countPref;
        }

        public void erase(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.get(ch);
                node.countPref--;
            }
            node.countEnds--;
        }
    }
}
