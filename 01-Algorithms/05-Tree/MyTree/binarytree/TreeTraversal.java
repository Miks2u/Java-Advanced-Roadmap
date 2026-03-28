package com.ds.binarytree;

public class TreeTraversal {
    //时间复杂度：O(n)

    /**
     * 前序遍历: 中 左 右
     * @param node -节点
     */
    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + "\t"); //中
        preOrder(node.left); //左
        preOrder(node.right); //右
    }

    /**
     * 中序遍历: 左 中 右
     * @param node - 节点
     */
    public static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left); //左
        System.out.print(node.val + "\t"); //中
        inOrder(node.right); //右
    }

    /**
     * 后序遍历: 左 右 中
     * @param node - 节点
     */
    public static void postOrder(TreeNode node){
        if(node == null){
            return;
        }
        postOrder(node.left); //左
        postOrder(node.right); //右
        System.out.print(node.val + "\t"); //中
    }
}
