## ArrayList

**基础**：底层是数组，查询快、增删慢

- 1.5倍扩容：让扩容后的新空间更有机会利用到之前释放的内存碎片
- 右移运算符：右移1位效率极高，直接在二进制层面运算



## LinkedList

**基础**：底层是链表，增删快、查询慢

- 现代CPU缓存下ArrayList增删可能比LinkedList还快：ArrayList内存连续，可以利用CPU的预取指令，而LinkedList的节点到处乱跳，会导致频繁的Cache Miss



## 迭代器

遍历List时不能用list.remove()，是因为修改集合的时候modCount次数会+1，迭代器内部存了expectedModCount，如果两者不相等就会抛出ConcurrentModificException异常（并发修改异常）