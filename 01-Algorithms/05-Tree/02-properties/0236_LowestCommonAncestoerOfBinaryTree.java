//236.二叉树的最近公共祖先
//中等
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //出口：找到了或者到底了
        if(root == null || root == p || root == q) return root;
        //后序遍历：自底向上搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左右都找到了
        if(left != null && right != null) return root;
        //左边没找到 那就在右边
        if(left == null) return right;
        return left;
    }
}