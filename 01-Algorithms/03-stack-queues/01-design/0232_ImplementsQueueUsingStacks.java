//232.用栈实现队列
//简单
//使用两种方式实现:数组/栈

//1.用Java带的接口实现
class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        if(outStack.isEmpty() && inStack.isEmpty()){
            return true;
        }
        return false;
    }
}


//2.用数组实现
class MyQueue {
        private int[] inStack;//入队列
        private int inTop;
        private int[] outStack;//出队列
        private int outTop;

    public MyQueue() {
        inStack = new int[10]; //入队列
        inTop = -1;

        outStack = new int[10]; //出队列
        outTop = -1;
    }
    
    public void push(int x) {
        inStack[++inTop] = x;
        
    }
    
    public int pop() {
        //没有元素的时候
        if(outTop == -1){
            while(inTop != -1){
                outStack[++outTop] = inStack[inTop--];
            }
        }
        //出队列
        return outStack[outTop--];
        
    }
    
    public int peek() {
         //没有元素的时候
        if(outTop == -1){
            while(inTop != -1){
                outStack[++outTop] = inStack[inTop--];
            }
        }
        //出队列
        return outStack[outTop];
    }
    
    public boolean empty() {
        if(inTop == -1 && outTop == -1){
            return true;
        }
        return false;
        
    }
}

