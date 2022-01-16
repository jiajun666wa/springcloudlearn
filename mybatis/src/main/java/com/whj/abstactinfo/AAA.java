package com.whj.abstactinfo;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-07 10:51
 * @version: 1.0
 */
public  abstract class AAA {
    abstract void show();
    abstract void hidden();
    void showB(){
        System.out.println("showB()");
    }

}

class BBB extends AAA {

    public static void main(String[] args) {
        AAA a=   new AAA() {
            void show() {    System.out.println("show()");     }

            void hidden() {            }
        };
        a.show();
        a.showB();
        System.out.println("=============================");
        AAA b=  new BBB();
        b.show();
        b.showB();
    }

    void show() {
        System.out.println("bbb.show()");
    }

    void hidden() {

    }
}

/**
 * 抽象类中
 * 1、可以有非抽象方法
 * 2、抽象方法不能有实现  （抽象的东西多由子类继承去实现，自己实现方法没有意义）
 * 3、类中只含有单个方法可以采用lomda表达式
 *
 */