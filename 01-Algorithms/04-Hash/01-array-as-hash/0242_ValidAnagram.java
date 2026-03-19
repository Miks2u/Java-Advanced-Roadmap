//242.有效的字母异位词
//简单
//使用 (- 'a')来映射对应数组下标并记录出现次数
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] record = new int[26];

        //字母映射，有则+1
        for(int i = 0; i < s.length() ; i++){
            s.charAt(i);
            record[s.charAt(i) - 'a']++;
        }

        //取出字母，有则-1
        for(int i = 0; i < t.length() ; i++){
            t.charAt(i);
            if(record[t.charAt(i) - 'a'] > 0){
                record[t.charAt(i) - 'a']--;
            }else return false;
        }
        //判断是否全部取出
        for(int count : record){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}