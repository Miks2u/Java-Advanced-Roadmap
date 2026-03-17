package com.ds.hashtable;

public class HashTable {

    //节点类
    static class Entry {
        int hash;
        Object key;
        Object value;
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    //成员变量
    Entry[] table = new Entry[16];
    int size = 0; //元素个数
    float loadFactor = 0.75f; // 阈值
    int threshold = (int) (loadFactor * table.length);


    /*
        - 位运算
        - 前提：数组长度必须是2的n次方
        - hash & (数组长度 - 1)
     */

    //根据hash码获得value
    Object get(int hash, Object key) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            return null;
        }
        Entry p = table[index];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    //向hash表存入新key value，如果key重复则更新value数据
    void put(int hash, Object key, Object value) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            table[index] = new Entry(hash, key, value);
            //size++;
        } else {
            Entry p = table[index];
            while (true) {
                if (p.key.equals(key)) {
                    p.value = value;
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value);
            //size++;
        }
        size++;
        if (size > threshold) {
            resize();
        }
    }

    //扩容
    void resize() {
        Entry[] newTable = new Entry[table.length * 2];
        /*
            拆链表
            按位与分为两部分
                hash & table.length == 0
                hash & table.length != 0
         */
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            Entry a = null;     //按位与结果 为0
            Entry b = null;     //按位与结果 不为0
            Entry aHead = null; //a链表表头
            Entry bHead = null; //b链表表头
            while (p != null) {
                if ((p.hash & table.length) == 0) {
                    if (a != null) {
                        a.next = p;
                    }else{
                        aHead = p;
                    }
                    a = p;
                } else {
                    if (b != null) {
                        b.next = p;
                    }else{
                        bHead = p;
                    }
                    b = p;
                }
                p = p.next;
            }
            //给两个链表分配
            //规律：a链表位置不变，b链表接到 a + table.length 的索引

            //链表尾指向null
            if(a != null){
                a.next = null;
                newTable[i] = aHead;
            }
            if(b != null){
                b.next = null;
                newTable[i + table.length] = bHead;
            }

        }
        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }

    //根据hash码删除，返回删除的value
    Object remove(int hash, Object key) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            return null;
        }
        Entry p = table[index];
        Entry pre = null;

        while (p != null) {
            if (p.key.equals(key)) {
                if (pre == null) {
                    table[index] = p.next;
                } else {
                    pre.next = p.next;
                }
                size--;
                return p.value;
            }
            pre = p;
            p = p.next;
        }
        return null;
    }
}
