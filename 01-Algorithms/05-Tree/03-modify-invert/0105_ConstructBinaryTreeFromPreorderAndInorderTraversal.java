//105.从前序与中序遍历序列构造二叉树
//中等
//前序第一个为根节点 中序的根节点左为左子树，右为右子树
//左子树在中序的长度:L = rootIndex - inStart
//左子树在前序的区间:[preStart + 1, preStart + L]
//右子树在前序的区间:[preStart + L + 1, preEnd]
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //将数据存入map
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        //结束条件
        if(preStart > preEnd) return null;
        //当前节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        //在中序遍历中找到根节点
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inStart; //左子树有多少节点

        //构建左子树
        root.left = helper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        //构建右子树
        root.right = helper(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
        
    }
}