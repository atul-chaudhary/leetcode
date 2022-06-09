package com.atul.tree;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zig = true;
        while(!queue.isEmpty()){
            int qsize = queue.size();
            int[] arr = new int[qsize];
            for(int i=0;i<qsize;i++){

                if(queue.peek().left != null) queue.offer(root.left);
                if(queue.peek().right != null) queue.offer(root.right);

                if(zig){
                    arr[i] = queue.poll().val;
                }else{
                    arr[qsize - i-1] = queue.poll().val;
                }

            }
            zig  = !zig;
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<qsize;i++){
                temp.add(arr[i]);
            }
            list.add(temp);
        }

        return list;
    }
}
