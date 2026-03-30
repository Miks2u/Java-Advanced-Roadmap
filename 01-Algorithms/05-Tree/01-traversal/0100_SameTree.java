//100.相同的树
//简单
//BFS与DFS解法

//1.BFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        //初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        //遍历
        while(!queue.isEmpty()){
                TreeNode pNode = queue.poll();
                TreeNode qNode = queue.poll();

                if(qNode == null && pNode == null){
                    continue;
                }
                if(qNode == null || pNode == null){
                    return false;
                }
                //判断节点中是数据是否一致
                if(pNode.val != qNode.val){
                    return false;
                }

                queue.offer(pNode.left);
                queue.offer(qNode.left);
                queue.offer(pNode.right);
                queue.offer(qNode.right);
        }
        return true;
    }
}

//2.DFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
