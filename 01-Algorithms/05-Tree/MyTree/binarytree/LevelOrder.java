package com.ds.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrder {
    //二叉树的层序遍历
    //时间复杂度：O(n)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //初始化队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            //记录队列当前长度
            int levelSize = deque.size();
            List<Integer> currLevel = new ArrayList<>();
            //一次性把当前层所有元素全部弹出
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.poll();
                currLevel.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(currLevel);
        }
        return res;
    }
}
