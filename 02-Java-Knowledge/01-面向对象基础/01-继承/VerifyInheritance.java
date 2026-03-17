package com.itheima;

/**
 * @author Pile-e
 * @description 验证继承中的内存布局与变量排列
 */
public class VerifyInheritance {
    public static void main(String[] args) {
        Sub s = new Sub();
        // 1. 内存连续性验证：子类对象不仅包含子类的 b，也包含父类的 a
        // 在内存中，a 的位置通常在对象头之后，b 紧随其后
        System.out.println("访问父类变量：" + s.a);

        // 2. 隐藏（Hiding）验证
        // 如果子类定义了同名变量，父类变量依然存在，只是被“遮住”了
        // 必须通过转型或者 super 才能看到那个偏移量
        s.show();
    }
}

class Base {
    int a = 10;
    int same = 100;
}

class Sub extends Base {
    int b = 20;
    int same = 200; // 属性遮蔽

    public void show() {
        System.out.println("当前类的 same：" + this.same); // 偏移量指向子类字段
        System.out.println("父类的 same：" + super.same);    // 偏移量指向父类字段
    }
}

