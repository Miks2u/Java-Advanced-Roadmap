//209.长度最长的子数组
//中等
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        int k = Integer.MAX_VALUE;


        while(right < nums.length){
            max += nums[right];
            while(max >= target){
                k = k < right - left + 1 ? k : right - left + 1;
                max -= nums[left];
                left++;
            }
            right++;
        }
        return k == Integer.MAX_VALUE? 0 : k;

    }
}