//438.找到字符串中所有字母异位词
//中等
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        //先将p中的字母频次存入数组
        for(int i = 0; i < p.length() ; i++){
            pCount[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        //滑动窗口
        while(right < s.length()){
            sCount[s.charAt(right) - 'a']++;
            //窗口达到p长度时开始收缩
            if(right - left == p.length() - 1){
                //比较是否异位
                if(Arrays.equals(sCount , pCount)){
                    res.add(left);
                }
                //收缩左边界 先消除后缩小
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }
}