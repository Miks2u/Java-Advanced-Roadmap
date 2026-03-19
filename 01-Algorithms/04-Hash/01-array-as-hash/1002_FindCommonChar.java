//1002.查找共用字符
//简单
class Solution {
    public List<String> commonChars(String[] words) {
        int[] minCount = new int[26];
        //先记录第一个字符串
        for(char c : words[0].toCharArray()){
            minCount[c - 'a']++;
        }
        //开始对比
        for(int i = 1; i < words.length; i++){
            int[] curCount = new int[26];
            char[] c = words[i].toCharArray();

            //存入curCount
            for(int j = 0 ; j < c.length ; j++){
                curCount[c[j] - 'a']++;
            }
            //进行对比
            for(int k = 0; k < minCount.length ; k++){
                minCount[k] = Math.min(minCount[k],curCount[k]);
            }

        }
        //将minCount转为List
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            //剩几次存几次
            while(minCount[i]>0){
                //将(i+'a')转为char，再转成String存入res
                res.add(String.valueOf((char)(i+'a')));
                minCount[i]--;
            }
        }
        return res;
    }
}