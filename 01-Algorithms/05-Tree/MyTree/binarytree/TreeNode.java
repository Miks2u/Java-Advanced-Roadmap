package com.ds.binarytree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode(TreeNode left, int value ,TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + val +
                '}';
    }
}
