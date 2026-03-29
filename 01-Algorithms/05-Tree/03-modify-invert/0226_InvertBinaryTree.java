//226.翻转二叉树
//简单
//思路：先反转，后递归
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
        	return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
        
    }
}