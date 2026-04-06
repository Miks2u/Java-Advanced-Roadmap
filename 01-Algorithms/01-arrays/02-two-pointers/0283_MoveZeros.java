//283.移动零
//简单
class Solution {
    public void moveZeroes(int[] nums) {
    	//遇到0跳过并记数，非0则往前移动0出现次数次
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }else if(count > 0){
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
    }
}