package com.atul.tree.BST;

public class BST {

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.insert(8);
        driver.insert(5);
        driver.insert(1);
        driver.insert(7);
        driver.insert(10);
        driver.insert(12);

        driver.traverse(driver.root);
    }
}


class Driver{
    TreeNode root;
    public void insert(int val){
        if(root == null){
            root = new TreeNode(val);
        }else{
            TreeNode cur = root;
            while(true){
                if(val < cur.val){
                    if(cur.left != null){
                        cur = cur.left;
                    }else{
                        cur.left = new TreeNode(val);
                        break;
                    }
                }else{
                    if(cur.right != null){
                        cur = cur.right;
                    }else{
                        cur.right = new TreeNode(val);
                        break;
                    }
                }
            }
        }
    }

    public void traverse(TreeNode root){
        if(root== null) return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}


