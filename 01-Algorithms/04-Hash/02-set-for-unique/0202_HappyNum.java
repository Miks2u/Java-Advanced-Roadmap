//202.快乐数
//简单
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            n = getNext(n);
            if(set.contains(n)){ //若遇到过就会陷入循环
                return false;
           }
             set.add(n);
       }
       return true;
    }
//计算各位上数的平方和
    public int getNext(int n){
        int sum = 0;
        while(n > 0){
            int d = n %10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}