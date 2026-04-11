//15.三数之和
//中等
//先排序，后用双指针
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            //跳过重复元素
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            //寻找剩下两个元素
            int j = i + 1, k = nums.length -1 ;
            int target = -nums[i];

            while(j < k){
                int sum = nums[j] + nums[k];
                if(sum == target){
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    //跳过重复元素
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }else if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
       }
       return results;
  }
}