//1.两数之和
//简单

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length ; i++){
             int need = target - nums[i];
             if(map.containsKey(need)){
                return new int[]{map.get(need),i};
             }
                map.put(nums[i],i);
        }
        return new int[0];
    }
}