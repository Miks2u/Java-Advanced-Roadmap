//26. 删除有序数组中的重复项
//简单
class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;

        while(fast < nums.length){
            if(nums[fast] == nums[slow]){
                fast++;
            }else{
                nums[++slow] = nums[fast++];
            }
        }
        return slow+1;
    }
}