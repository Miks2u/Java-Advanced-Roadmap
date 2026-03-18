package com.ds.singly;

public class SinglyLinkedList {
    //头节点
    private Node head = null;


    //节点类
    private static class Node {
        //值
        int value;
        //指向下一个节点
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //-------------------------------------------------------------------------------------------------------------
    //头插
    public void addFirst(int value) {
        head = new Node(value, head);
    }
//-------------------------------------------------------------------------------------------------------------

    //尾插

    //先找到最后一个元素
//需要注意是否只有head指针
    public Node findLast() {
        if (null == head) {
            return null;
        }

        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;

    }

    //------------------------------------
    public void addLast(int value) {
        Node p = findLast();
        if (head == null) {
            addFirst(value);
            return;
        }
        p.next = new Node(value, null);
    }

//-------------------------------------------------------------------------------------------------------------

    //遍历(while)
    public void forEach1() {
        //指向头指针所指节点
        Node p = head;

        //p指针指向null时 遍历结束 （链表到最后了）
        while (p != null) {
            //打印元素
            System.out.println(p.value);
            //指向下一节点
            p = p.next;
        }
    }

    //遍历(for)
    public void forEach2() {
        for (Node p = head; p != null; p = p.next) {
            System.out.println(p.value);
        }
    }

//-------------------------------------------------------------------------------------------------------------

    //根据索引查节点
    public Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index)
                return p;
        }
        return null;
    }

    //根据索引查元素
    public int get(int index) {
        Node p = findNode(index);
        if (p == null) {
            throw new IllegalArgumentException();
        }

        return p.value;
    }

//-------------------------------------------------------------------------------------------------------------

    //插入
    public void insert(int index, int value) {
        //头指针
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node pre = findNode(index - 1);
        //索引值不在范围内
        if (pre == null) {
            throw new IllegalArgumentException();
        }
        pre.next = new Node(value, pre.next);
    }

//-------------------------------------------------------------------------------------------------------------

    //删除头节点
    public void removeFirst() {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        head = head.next;
    }

    //根据索引删除节点
    public void remove(int index) {
        //如果要删的是头节点
        if(index == 0){
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if(prev == null){
            throw new IllegalArgumentException();
        }
        if(prev.next == null){
            throw new IllegalArgumentException();
        }
        prev.next = prev.next.next;
    }


}

