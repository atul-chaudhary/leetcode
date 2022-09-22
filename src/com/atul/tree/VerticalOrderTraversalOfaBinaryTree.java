package com.atul.tree;

import java.util.*;

public class VerticalOrderTraversalOfaBinaryTree {

    public static void main(String[] args) {

    }

    static class Pair {
        int x; //horizontal distance
        int y; // vertical distance
        TreeNode node;

        public Pair(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }

    static class Vertical{
        int y;
        int val;

        public Vertical(int y, int val) {
            this.y = y;
            this.val = val;
        }
    }

    public static List<List<Integer>> verticalTraversalOpt(TreeNode root) {
        TreeMap<Integer,PriorityQueue<Vertical>> map = new TreeMap<>();
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0, 0, root));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            TreeNode node = pair.node;
            int x = pair.x;
            int y = pair.y;


            if(map.containsKey(x)){
                map.get(x).offer(new Vertical(y, node.val));
            }else{
                PriorityQueue<Vertical> pq_temp = new PriorityQueue<>((a,b)-> a.y==b.y ? a.val- b.val: a.y-b.y);
                pq_temp.add(new Vertical(y, node.val));
                map.put(x, pq_temp);
            }

            if (node.left != null) {
                pq.offer(new Pair(x - 1, y + 1, node.left));
            }

            if (node.right != null) {
                pq.offer(new Pair(x + 1, y + 1, node.right));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Vertical>> ent : map.entrySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            PriorityQueue<Vertical> pq_temp = ent.getValue();
            while (!pq_temp.isEmpty()){
                    temp.add(pq_temp.poll().val);
                }
            result.add(temp);
        }

        return result;
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0, 0, root));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            TreeNode node = pair.node;
            int x = pair.x;
            int y = pair.y;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(pair.node.val);

            if (node.left != null) {
                pq.offer(new Pair(x - 1, y + 1, node.left));
            }

            if (node.right != null) {
                pq.offer(new Pair(x + 1, y + 1, node.right));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> ent : map.entrySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> temp_map = ent.getValue();
            for(Map.Entry<Integer, PriorityQueue<Integer>> entry : temp_map.entrySet()){
                PriorityQueue<Integer> temp_pq = entry.getValue();
                while (!temp_pq.isEmpty()){
                    temp.add(temp_pq.poll());
                }
            }
            result.add(temp);
        }

        return result;
    }
}
