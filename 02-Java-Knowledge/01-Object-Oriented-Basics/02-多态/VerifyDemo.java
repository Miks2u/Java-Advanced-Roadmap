package com.itheima;

/**
 * @author pile-e
 * @description 验证多态在内存中的表现：变量的静态绑定 vs 方法的动态绑定
 * @date 2026-03-17
 */
public class VerifyDemo {
    public static void main(String[] args) {
        // 1. 向上转型：父类引用指向子类对象
        Animal a = new Dog();

        // 【验证：变量看左边】
        // 虽然 new Dog() 确实在堆里开辟了含有 name="小狗" 的空间，
        // 但引用 a 是 Animal 类型，编译器只能根据 Animal 的偏移量找到 "动物"
        System.out.println("名字是：" + a.name);

        // 【验证：方法看右边】
        // 运行阶段，JVM 会通过 a 指向的对象头找到 Dog 的 vtable（虚方法表），
        // 从而调用 Dog 重写后的 eat 方法。
        a.eat();

        // 【验证：子类特有方法】
        // a.lookDoor(); // 编译报错！因为 Animal 的“说明书”里没有这个偏移量

        // 2. 向下转型：找回被隐藏的子类空间
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            System.out.println("转型后看到子类变量：" + d.name);
            d.lookDoor();
        }
    }
}

class Animal {
    String name = "动物";

    public void eat() {
        System.out.println("动物在吃东西");
    }
}

class Dog extends Animal {
    String name = "小狗"; // 注意：这里是属性遮蔽，不是重写

    @Override
    public void eat() {
        System.out.println("狗吃骨头（来自 Dog 的 vtable）");
    }

    public void lookDoor() {
        System.out.println("狗在看门");
    }
}
