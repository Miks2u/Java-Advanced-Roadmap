//3.无重复字符的最长字串
//中等
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	//判空
         if (s == null || s.isEmpty()) {
            return 0;
        }

        HashMap<Character , Integer> map = new HashMap<>();
        int max = 0;
        int left = 0,right = 0;

        //开始寻找最长字串的长度
        while(right < s.length()){
            char c = s.charAt(right);
            //若字符已存且在窗口范围
            if(map.containsKey(c) && map.get(c) >= left){
                left = map.get(c) + 1;
                }
                
            map.put(c , right);
            max = Math.max(max , right - left + 1);
            right++;
        }
        return max;
    }
}