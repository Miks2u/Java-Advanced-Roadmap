//503.下一个更大元素II
//中等
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(ans,-1);

        for(int i = 0; i < 2*n ; i++){
            int curIndex = i%n;
            while(!stack.isEmpty() && nums[curIndex] > nums[stack.peek()]){
                int index = stack.pop();
                ans[index] = nums[curIndex];
            }
            if(i < n){
                stack.push(i);
            }
        }
        return ans;
    }
}