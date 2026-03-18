package com.itheima;

/**
 * @author Pile-e
 * @description 验证抽象类与接口的内存与设计区别
 */
public class VerifyDesign {
    public static void main(String[] args) {
        // 抽象类验证
        Door alarmDoor = new AlarmDoor();
        alarmDoor.open(); // 调用抽象类定义的方法

        // 接口验证
        if (alarmDoor instanceof Alarm) {
            ((Alarm) alarmDoor).alarm(); // 调用接口定义的扩展行为
        }
    }
}


// 接口：代表 "能做什么" (CAN-DO / LIKE-A)
// 它没有构造器，变量默认是 static final，不属于对象的实例空间
interface Alarm {
    void alarm(); // 纯粹的行为协议
}


// 抽象类：代表 "是什么" (IS-A)
// 它拥有构造器，可以定义非静态成员变量，在内存中为子类提供基础空间
abstract class Door {
    String material; // 抽象类可以有成员变量（状态）

    public abstract void open();

    public abstract void close();
}


// 子类：继承一个抽象类，实现多个接口
class AlarmDoor extends Door implements Alarm {
    @Override
    public void open() {
        System.out.println("开门");
    }

    @Override
    public void close() {
        System.out.println("关门");
    }

    @Override
    public void alarm() {
        System.out.println("响铃报警！");
    }
}

