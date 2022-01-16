package com.whj.gof23.adaptermodel;

/**
 * @description: 适配者类 ： 被访问和适配的现存组件库中的组件接口
 * @author: whj
 * @createTime: 2021-12-27 13:39
 * @version: 1.0
 */
public class Adaptee {
    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用！");
    }
}
