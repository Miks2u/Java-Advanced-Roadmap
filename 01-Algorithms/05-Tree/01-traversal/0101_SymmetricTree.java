//101.对称二叉树
//简单
//若: 左子树的左 等于 右子树的右
//    左子树的右 等于 右子树的左
//    同时满足才对称
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left, root.right);
    }
    //用p来表示左，q来表示右
    public boolean dfs(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}