package com.whj.gof23.templatemodel;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 19:27
 * @version: 1.0
 */
public  abstract class Parent {
    public void method1(){
        System.out.println("method1()");
    }
    public void method2(){
        System.out.println("method2()");
    }
    public abstract void method3();
    public void method4(){
        System.out.println("method4()");
    }
}
