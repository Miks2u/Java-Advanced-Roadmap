//122.最小栈
//中等
//2种解法：动态规划/一下存两个数

//1.动态规划
class MinStack {
     //动态规划思想，建一个最小栈存当前的最小元素
        int[] stack;
        int top;
        int[] min;
        int minTop;

    public MinStack() {
         //动态规划思想，建一个最小栈存当前的最小元素
        stack = new int[30001];
        top = -1;
        min = new int[30001];
        minTop = -1; 
    }
    
    public void push(int val) {
        stack[++top] = val;
        if(minTop == -1 || val < min[minTop]){
            min[++minTop] = val;
        }
    }
    
    public void pop() {
        if(stack[top] == min[minTop]){
            minTop--;
        }
            top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return min[minTop];
    }

}

//2.存当前数和最小数
class MinStack {
        private int[] stack;
        private int top;
    public MinStack() {
        stack = new int[60001];
        top = -1;
    }
    
    public void push(int val) {
        if(top == -1){
            stack[++top] = val;
            stack[++top] = val; //此时top为1 第二个元素
        }else{
            int min = stack[top];
            stack[++top] = val;
            stack[++top] = val < min?val:min;
        }
    }
    
    public void pop() {
        top -= 2;
    }
    
    public int top() {
        return stack[top -1];
    }
    
    public int getMin() {
        return stack[top];
    }
}
