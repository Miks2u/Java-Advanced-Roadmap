//111.二叉树的最小深度
//简单
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //初始化队列
        int minDepth = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        //遍历
        while(!deque.isEmpty()){
            minDepth++;
            int levelSize = deque.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = deque.poll();
                if(curr.left == null && curr.right == null){
                    return minDepth;
                }
                if(curr.left != null){
                    deque.offer(curr.left);
                }
                if(curr.right != null){
                    deque.offer(curr.right);
                }
            }
        }
        return minDepth;
    }
}