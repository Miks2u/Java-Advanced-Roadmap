//27.移除元素
//简单
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int k = 0;
        while(fast < nums.length){
            if(nums[fast] ==val){
                fast++;
            }else{
                nums[slow++] = nums[fast++];
                k++;
                }
            
        }
        return k;
    }
}