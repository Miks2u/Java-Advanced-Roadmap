//34. 在排序数组中查找元素的第一个和最后一个位置
//简单
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = startIndex(nums,target);
        int end = endIndex(nums,target);

        return new int[] {start,end};

    }

//左索引
    public int startIndex(int[] nums,int target){
        int left=0,right = nums.length;

        while(left < right){
            int mid = (left+right) >>>1;
            if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        if(left < nums.length && nums[left] == target  ){
            return left;
        }
        return -1;
    }

//右索引
      public int endIndex(int[] nums,int target){
        int left=0,right = nums.length;
        while(left<right){
            int mid = (left + right) >>>1;

            if(nums[mid] <= target){
                left = mid +1;
            }else{
                right = mid;
            }
        }
         if( left -1 >=0 && nums[left - 1] == target ){
            return left-1;
        }else return-1;
    }
}