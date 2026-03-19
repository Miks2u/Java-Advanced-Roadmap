//349.两个数组的交集
//简单
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //set1存数组，set2存结果
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        //存入set1
        for(int i : nums1){
            set1.add(i);
        }
        //检查，若存在则存入set2
        for(int i : nums2){
            if(set1.contains(i)) set2.add(i);
        }
        //set2转回数组
        int[] res = new int[set2.size()];
        int index = 0;
        for(Integer num : set2){
            res[index++] = num;
        }
        return res;
    }
}