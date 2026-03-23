//49.字母异位词分组
//中等
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        //先拿出String数组中的每个元素
        for(String s : strs){
            //拆分为一个个的字符，并且排序
            char[] c = s.toCharArray();
            Arrays.sort(c);
            //将排序后的字符数组转为字符串后 作为key
            String key = String.valueOf(c);
            //若key不存在就新建一个List，存在就直接get出来
            List<String> list = map.getOrDefault(key , new ArrayList<>());
            list.add(s);
            map.put(key , list);
        }
        //利用ArrayList构造器，把map中所有的List都返回
        return new ArrayList<>(map.values());
    }
}