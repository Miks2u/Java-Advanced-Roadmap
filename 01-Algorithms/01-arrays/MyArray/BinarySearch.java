package com.ds.search;

public class BinarySearch {
    //二分查找

    //查到返回值
    //没查到返回-1

    //左闭右闭
    public static int binarySearchCLose(int[] a, int target) {
        //定义两个指针分别指向左右两侧
        int i = 0, j = a.length - 1;

        //开始循环
        while (i <= j) {
            //定义中间变量
            int m = (i + j) >>> 1;//无符号右移解决溢出问题 ，或者 m = (2i + j - i)/2 = i + (j - i)/2
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }

        //没找到
        return -1;
    }


    //左闭右开
    public static int binarySearchHalfOPen(int[] a, int target) {
        //左右指针分别指向两侧
        int left = 0, right = a.length;

        while (left < right) {
            //定义中间变量
            int mid = left + (right - left) / 2;

            //判断
            if (target < a[mid]) {
                right = mid;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }


    public static int binarySearchBalanced(int[] a,int target){
        //定义左右指针
        int left = 0,right = a.length;

        //循环条件不同
        while (right -left > 1){
            int mid = (right + left) >>> 1;

            if(target < a[mid]){
                right = mid;
            }else{
                left = mid;
            }
//            if(a[mid] < target){
//                left = mid;
//            }else{
//                right = mid;
//            }
        }

        if(a[left] == target ){
            return left;
        }else{
            return -1;
        }
    }


}
