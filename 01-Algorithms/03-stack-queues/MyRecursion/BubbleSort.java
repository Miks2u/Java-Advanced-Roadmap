package com.ds.recursion;

public class BubbleSort {
    //冒泡排序：时间复杂度 O(n²)
    //          是种稳定的排序算法

    //使用方法
    public void sort(int[] arr){
        int j = arr.length - 1;
        bubble(arr,j);
    }

    private void bubble(int[] arr, int j){
        //j代表此次排序的右边界
        //当j为0时排序完成
        if(j == 0){
            return;
        }

        //添加变量x来分割 有序部分与无序部分
        int x = 0;
        //排序部分
        for (int i = 0;i < j; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                //每次交换位置时将i赋值给x
                x = i;
            }
        }

        //递归
        bubble(arr,x);
    }
}
