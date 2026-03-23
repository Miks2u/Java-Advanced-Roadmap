//20.有效的括号
//简单

class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        char[] arr = s.toCharArray();
        int index = 0;
        for(char c : arr){
            if(c == '('){
                arr[index++] = ')';
            }else if(c == '['){
                arr[index++] = ']';
            }else if(c == '{'){
                arr[index++] = '}';
            }else if(index == 0 || c != arr[--index]){
                return false;
            }
        }
        return index == 0;
    }

}