# Collection

### ArrayList

**基础**：底层是数组，查询快、增删慢

- 1.5倍扩容：让扩容后的新空间更有机会利用到之前释放的内存碎片
- 右移运算符：右移1位效率极高，直接在二进制层面运算

### LinkedList

**基础**：底层是链表，增删快、查询慢

- 现代CPU缓存下ArrayList增删可能比LinkedList还快：ArrayList内存连续，可以利用CPU的预取指令，而LinkedList的节点到处乱跳，会导致频繁的Cache Miss

  

### HashSet

**底层实现**：哈希表，结构为数组 + 链表 + 红黑树( JDK8以后 )

当链表长度超过8，并且数组长度大于等于64时，自动将链表转化为红黑树

### TreeSet

**底层**：红黑树，能自动排序是因为每存入一个元素，就会进行一次”左旋“或”右旋“来保持平衡



## 迭代器

遍历List时不能用list.remove()，是因为修改集合的时候modCount次数会+1，迭代器内部存了expectedModCount，如果两者不相等就会抛出ConcurrentModificException异常（并发修改异常）



# Map

存的是**键值对**( Key - Value )

### HashMap

**底层**：是哈希表，结构为结构为数组 + 链表 + 红黑树(  JDK8以后)

- 根据Key的hashCode计算索引，O(1)的时间复杂度。
- 确保键唯一靠的是hashCode()和equals()
- 默认加载因子为0.75，是基于泊松分布计算出的最优解
- 在计算索引时，Java使用了取模运算的位运算，所以HashMap的长度必须是2的n次幂。

### TreeMap

**底层**：红黑树

- 不看Hash，只根据存进去的Key大小顺序进行排序

### LinkedHashMap

**底层**：在HashMap的基础上加了双向链表，每个元素都有指向上个元素与下个元素的指针（头的pre和尾的next为null），可以记住存入的顺序

### Map的三种遍历

- **KeySet**：先拿Key，再根据Key去找Value
- **EntrySet**：直接拿”键值对“对象
- **forEach**