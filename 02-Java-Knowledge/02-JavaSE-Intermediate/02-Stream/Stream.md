#### Stream是一套流水线加工协议

- 加工三部

  1.获取流：list.stream() 将数据刷入流水线 （获取流对象）

  2.中间方法：filter，map，distinct....

  ​						中间操作是**懒加载**的，没遇到终结方法前他们一个都不会执行

  3.终结方法：forEach，collect，count

  ​						终结方法一旦执行，流水线关闭，stream对象不可再用

- Stream不会修改原始集合，就像复印件。这保证了在复杂项目里的数据安全
- **不要**在简单循环中强行使用Stream，因为Lambda表达式和Stream的创建是有开销的。

#### 方法引用

对Lambda表达式的进一步简化。

适用于**Lambda表达式只调用一个现有方法**的场景。

示例: s -> System.sout.println(s)  可简化为方法引用 System.out::println



#### 异常处理

- 异常体系的结构

  ​	Throwable：所有错误的祖宗

  ​			Error：系统级崩溃，程序员无法处理（如内存溢出）

  ​			Exception：我们要处理的异常

  ​						运行时异常：RuntimeException及其子类，通常是逻辑Bug

  ​						编译时异常：除RuntimeException 之外所有的异常，不处理编译不了

  ​				自定义异常：JDK自带的异常无法见名知意的表示出需求中的异常时，可以自己定义，但要继承Exception(自定义编译时异常)或RuntimeException(自定义运行时异常)

- 关键字

  1.try...catch：拦截并处理，处理完继续运行

  2.finall：必执行。无论是否异常，finally块内的代码都要执行。

  3.throw：主动开火，在方法内部抛出一个异常

  4.throws：甩锅。在方法签名上声明，谁调用谁处理。

- **不要**用异常来实现业务逻辑。异常的堆栈追踪非常消耗CPU算力，异常是用来处理意外的，不是拿来实现业务的