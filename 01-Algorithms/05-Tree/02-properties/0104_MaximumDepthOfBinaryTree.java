//104.二叉树的最大深度
//简单
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //递归获得左右子树的高度
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}