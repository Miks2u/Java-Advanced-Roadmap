package com.ds.recursion;

public class Factorial {
    //阶乘
    public int f(int n){
        if(n == 1){
            return 1;
        }
        return n * f(n-1);
    }
}
