//112.路径总和
//简单
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //空节点
        if(root == null) return false;
        //到达叶节点，判断路径和是否等于目标值
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }
        //递归左右子树
        int newTarget = targetSum - root.val;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}