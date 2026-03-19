//387. 字符串中的第一个唯一字符
//简单
// 使用HashMap & 26位数组存次数
class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0){
            return -1;
        }
        HashMap<Character , Integer> map = new HashMap<>();

        //放入字符并记录次数
        for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                map.put(c , map.getOrDefault(c, 0)+1);
        }

        //开始查找
        for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                int times = map.get(c);
                if(times == 1) return i;
        }
        return -1;
    }
}

//6位数组存次数
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] count = new int[26];
        //存入数据并记录次数
        for(int i = 0 ; i < n ; i++){
            count[c[i] - 'a']++;
        }
        //查看次数
        for(int i = 0 ; i < n ; i++){
            if(count[c[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}