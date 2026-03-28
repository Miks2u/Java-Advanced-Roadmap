package com.ds.recursion;
/*
插入排序：时间复杂度 O(n²)，空间复杂度 O(n)（递归栈）
最好情况：O(n) - 数组已有序
最坏情况：O(n²) - 数组逆序
平均情况：O(n²)
 */
public class InsertSort {
    public static void sort(int[] arr) {
        insertSort(arr, 1);
    }

    private static void insertSort(int[] arr, int low) {
        //结束条件
        if (low == arr.length) {
            return;
        }

        //排序
        //记录当前low指向的值
        int temp = arr[low];
        int i = low - 1;//已排序区域的右边界

        while (i >= 0 && arr[i] > temp) { //寻找插入位置
            arr[i + 1] = arr[i];
            i--;
        }

        //找到插入位置
        arr[i + 1] = temp;

        insertSort(arr,low+1);

    }
}
