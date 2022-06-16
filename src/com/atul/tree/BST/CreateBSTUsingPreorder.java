package com.atul.tree.BST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateBSTUsingPreorder {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = createTree(preorder, 0, preorder.length-1,
                inorder,0, inorder.length-1,
                inorderMap
        );
        traverse(root);
    }

    public static void traverse(TreeNode node){
        if(node== null){
            return;
        }
        System.out.println(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    public static TreeNode createTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> map
    ) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(root.val);
        int numbers = rootIndex - inStart;
        root.left = createTree(preorder, preStart + 1, preStart + numbers,
                inorder, inStart, rootIndex - 1,
                map
        );
        root.right = createTree(preorder, preEnd + numbers + 1, preEnd,
                inorder, rootIndex+1, inEnd,
                map
        );

        return  root;
    }
}
