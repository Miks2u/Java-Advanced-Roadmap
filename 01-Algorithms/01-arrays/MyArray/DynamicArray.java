package com.ds.dynamic;

public class DynamicArray {
    //定义动态数组
    private int capacity = 8;  //定义容量
    private int size = 0;     //定义逻辑大小
    private int[] arr = new int[capacity];

    //增
    public void add(int index, int elem) {
        if (index < 0 || index > size) {
            System.out.println("index error");
            return;

        } else {
            //复制数组
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = elem;
        size++;
    }

    public void addLast(int elem) {
        add(size, elem);
    }


    //删除
    public int remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("index error");
            return -1;
        }
        int removed = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;


        return removed;
    }

    //扩容
    public void checkAndGrow(){
        if(size == capacity){
            //扩容为原来的1.5倍
            capacity += capacity>>>1;
            int[] newArr = new int[capacity];

            System.arraycopy(arr,0,newArr,0,size);
            arr = newArr;  
        }
    }


}



