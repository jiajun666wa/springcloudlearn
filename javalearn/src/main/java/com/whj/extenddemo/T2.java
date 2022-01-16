package com.whj.extenddemo;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2022-01-15 19:08
 * @version: 1.0
 */
public class T2  extends  T1{

    public static void main2(String[] args) {
       main(args); //子类可以调用父类的main方法 ，注意主方法不是main方法
        System.out.println("T2.main()");
    }

    //子类定义自己的 main 方法，隐藏掉父类中的实现，那么这也是可以的
    public static void main(String [] args) {
        System.out.println("hello world Main2");
    }

}
