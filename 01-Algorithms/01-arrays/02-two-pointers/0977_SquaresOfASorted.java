//977.有序数组的平方
//简单
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int[] arr = new int[nums.length];
        int i = nums.length - 1;

        while(l <= r){
            if(nums[l]*nums[l] >= nums[r]*nums[r]){
                arr[i] = nums[l]*nums[l];
                l++;
            }else{
                arr[i] = nums[r]*nums[r];
                r--;
            }
            i--;
        }
        return arr;
    }
}