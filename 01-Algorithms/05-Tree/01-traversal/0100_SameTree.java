//100.相同的树
//简单
//BFS与DFS解法

//1.BFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        //初始化队列
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();
        deque1.offer(p);
        deque2.offer(q);
        //遍历
        while(!deque1.isEmpty() && !deque2.isEmpty()){
            int levelSize = deque1.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode pNode = deque1.poll();
                TreeNode qNode = deque2.poll();
                //判断节点中是数据是否一致
                if(pNode.val != qNode.val){
                    return false;
                }
                //判断是否都有左右子树
                if(pNode.left != null && qNode.left != null){
                    deque1.offer(pNode.left);
                    deque2.offer(qNode.left);
                }else if(!(pNode.left == null && qNode.left == null)){
                    return false;
                } 
                if(pNode.right != null && qNode.right != null){
                    deque1.offer(pNode.right);
                    deque2.offer(qNode.right);
                }else if(!(pNode.right == null && qNode.right == null)){
                    return false;
                }
            }
        }
        return true;
    }
}

//2.DFS

