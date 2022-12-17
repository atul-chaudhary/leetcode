package com.atul.trie;

public class MapSumPairs {
    public static void main(String[] args) {

    }

    static class Node {
        Node[] links = new Node[26];
        boolean isEnd;
        int value;

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }

        Node get(char ch){
            return links[ch-'a'];
        }
    }

    class MapSum {
        Node root = null;
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            insert(root, key, val);
        }

        public int sum(String prefix) {
            Node start = search(root, prefix);
            int[] result = new int[1];
            dfs(start, result);
            return result[0];
        }

        public void dfs(Node root, int[] count){
            if(root != null && root.isEnd){
                count[0] += root.value;
            }
            for (Node it : root.links){
                if(it != null){
                    dfs(it, count);
                }
            }
        }

        public Node search(Node root, String prefix){
            Node node = root;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                if(!node.containsKey(prefix.charAt(i))){
                    return null;
                }
                node = node.get(prefix.charAt(i));
            }
            return node;
        }

        public  void insert(Node root, String s, int value){
            Node node = root;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if(!node.containsKey(s.charAt(i))){
                    node.put(s.charAt(i), new Node());
                }
                node = node.get(s.charAt(i));
            }
            node.isEnd = true;
            node.value = value;
        }
    }

}
