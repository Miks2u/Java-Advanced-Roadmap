package com.ds.binarytree;

import java.util.LinkedList;


public class TreeTraversalWithoutRec {
    //时间复杂度：O(n)

    /**
     * //不使用递归的前中后序遍历
     *
     * @param root 根节点
     */

    //前，中序遍历
    public static void order(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode curr = root;//代表当前节点
        LinkedList<TreeNode> stack = new LinkedList<>(); //代表一个栈，存走过的节点

        //若当前节点为空且栈也为空 代表遍历结束
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                //往左深入
                System.out.println("前序:" + curr.val);
                stack.push(curr); //压入栈为了记住回来的路
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println("中序：" + pop.val);
                curr = pop.right;
            }
        }

    }


    //后序遍历
    public static void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);//压入栈为了记住回来的路
                curr = curr.left;
            } else {
                //判断上一节点的右子树是否为空 ，以及上一节点的右子树是否遍历完
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    System.out.println("后序：" + pop.val);
                } else {
                    curr = peek.right;
                }
            }
        }
    }

    //通用的前中后序遍历代码！
    //基于后序遍历来完善修改
    public static void orderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pop = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println("前序遍历" + curr.val);
                stack.push(curr);
                //处理左子树
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                //右子树为空
                if (peek.right == null) {
                    System.out.println("中序遍历：" + peek.val);
                    pop = stack.pop();
                    System.out.println("后序遍历：" + pop.val);
                }
                //右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                    System.out.println("后序遍历：" + pop.val);
                }
                //右子树待处理
                else{
                    System.out.println("中序遍历" + peek.val);
                    curr = peek.right;
                }
            }
        }

    }
}
