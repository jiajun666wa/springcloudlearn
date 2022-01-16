package com.whj.gof23.templatemodel;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 19:29
 * @version: 1.0
 */
public class SubClass extends Parent{
    @Override
    public void method1() {
        super.method1();
    }

    @Override
    public void method3() {
        System.out.println("method3()==>子类实现，父类提供抽象方法！");
    }

    public static void main(String[] args) {
        final SubClass subClass = new SubClass();
        subClass.method1();
        subClass.method2();
        subClass.method3();
        subClass.method4();
    }
}
