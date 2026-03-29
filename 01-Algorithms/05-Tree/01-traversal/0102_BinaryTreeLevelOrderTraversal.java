//102.二叉树的层序遍历
//中等
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //初始化队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        //一次性遍历一层
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = deque.poll();
                currLevel.add(curr.val);
                if(curr.left != null){
                    deque.offer(curr.left);
                }
                if(curr.right != null){
                    deque.offer(curr.right);
                }
            }
            res.add(currLevel);
        }
        return res;
    }
}