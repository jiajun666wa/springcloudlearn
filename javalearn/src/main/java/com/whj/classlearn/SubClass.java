package com.whj.classlearn;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-22 11:00
 * @version: 1.0
 */
public class SubClass extends AbstractClassDemo {


    @Override
    public void method2() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method1();;
        subClass.method2();

    }
}


