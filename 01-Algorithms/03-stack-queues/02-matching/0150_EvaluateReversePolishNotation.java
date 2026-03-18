//逆波兰表达式求值
//中等
//数字则入栈，运算符则运算

class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int index = 0;

        for(String s : tokens){
            //判断是运算符还是数字
            if(s.equals("+")){
                int num2 = stack[--index];
                int num1 = stack[--index];
                stack[index++] = num1 + num2;
            }else if(s.equals("-")){
                int num2 = stack[--index];
                int num1 = stack[--index];
                stack[index++] = num1 - num2;
            }else if(s.equals("*")){
                int num2 = stack[--index];
                int num1 = stack[--index];
                stack[index++] = num1 * num2;
            }else if(s.equals("/")){
                int num2 = stack[--index];
                int num1 = stack[--index];
                stack[index++] = num1 / num2;
            }else{
                //存入数字
                stack[index++] = Integer.parseInt(s);
            }
        }
        return stack[index -1];

    }
}