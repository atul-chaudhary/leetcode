package com.atul.tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
}

class SolutionPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>  list = new ArrayList<>();
        treeHelper(root, list);

        // if(root==null) return list;
        // list.add(root.val);
        // list.addAll(preorderTraversal(root.left));
        // list.addAll(preorderTraversal(root.right));
        return list;

    }

    public void treeHelper(TreeNode node, List<Integer> list){
        if(node==null) return;
        //treeHelper(node.val);
        list.add(node.val);
        treeHelper(node.left, list);
        treeHelper(node.right, list);
    }
}
