//704-二分查找
//简单
class Solution {
    public int search(int[] nums, int target) {
        int i = 0,j = nums.length;
        while(j-i>1){
            int m = (i + j) >>> 1;
            if(target < nums[m]){
                j = m;
            }else {
                i = m;
            }
        }
        if(nums[i] == target){
            return i;
        }else{
            return -1;
        }
    }
}