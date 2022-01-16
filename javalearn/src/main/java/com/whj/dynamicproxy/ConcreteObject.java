package com.whj.dynamicproxy;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-31 16:55
 * @version: 1.0
 */
public class ConcreteObject implements AbcstactObject{
    @Override
    public void show() {
        System.out.println(this.getClass().getName());
    }
    @Override
    public void show(String str) {
        System.out.println(str);
    }
}
