package com.ds.recursion;

public class RecursionBinarySearch {
    //递归实现二分查找

    public static int RecBinarySearch(int[] arr, int target, int i, int j) {
        //不对外界暴露查找过程
        return f(arr, target, i, j);
    }

    private static int f(int[] arr, int target, int i, int j) {
        //如果没找到返回-1
        if(i > j){
            return -1;
        }
        //二分查找
        int m = (i + j) >>> 1;
        if (arr[m] < target) {
            return f(arr, target, m + 1, j);
        }else if(target < arr[m]){
            return f(arr,target,i,m-1);
        }else{
            return m;
        }
    }
}
