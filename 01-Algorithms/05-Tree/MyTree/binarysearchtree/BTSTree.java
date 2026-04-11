package com.ds.binarysearchtree;

public class BTSTree {
    BTSNode root;

    static class BTSNode {
        int key;
        Object value;
        BTSNode left;
        BTSNode right;

        public BTSNode(int key) {
            this.key = key;
        }

        public BTSNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BTSNode(int key, Object value, BTSNode left, BTSNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    /**
     * 根据关键字查值
     *
     * @param key - 关键字
     * @return 该关键字对应的值
     */
    public Object get(int key) { //递归实现
        return doGet(root, key);
    }

    private Object doGet(BTSNode node, int key) {
        //如果没有 返回null
        if (node == null) return null;

        if (key < node.key) {
            return doGet(node.left, key); //往左找
        } else if (node.key < key) {
            return doGet(node.right, key); //往右找
        } else {
            return node.value; //找到了
        }
    }

    //非递归
    /*public Object get(int key) {
        BTSNode node = root;
        while(node != null){
            if(key < node.key){
                node = node.left;
            }else if (node.key < key){
                node = node.right;
            }else {
                return node.value;
            }
        }
        return null;
    }*/

    /**
     * 查找最小值
     * @return 返回最小值
     */
    public Object min(){
        return doMin(root);
    }
    private Object doMin(BTSNode node){
        if(node == null) return null;
        if(node.left == null) return node.value;
        return doMin(node.left);
    }

    /**
     * 查找最大值
     * @return 返回最大值
     */
    public Object max(){
        return doMax(root);
    }
    private Object doMax(BTSNode node){
        if(node == null) return null;
        if(node.right == null) return node.value;
        return doMax(node.right);
    }

    /**
     * 添加数据：若存在则修改，不存在就新增
     * @param key - 关键字
     * @param value - 值
     */
    public void put(int key, Object value){
        BTSNode node = root;
        BTSNode parent = null;
        while (node != null) {
            parent = node;
            if(key < node.key){ //向左找
                node = node.left;
            }else if(node.key < key){ //向右找
                node = node.right;
            }else { //找到了：修改
                node.value = value;
                return;
            }
        }
        //没找到：新增
        if(parent == null){
            root = new BTSNode(key,value);
            return;
        }
        if(parent.key < key){
            parent.right = new BTSNode(key,value);
        }else {
            parent.left = new BTSNode(key,value);
        }
    }
}
