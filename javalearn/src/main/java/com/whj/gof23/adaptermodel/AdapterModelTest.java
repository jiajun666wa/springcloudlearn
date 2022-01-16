package com.whj.gof23.adaptermodel;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-27 14:27
 * @version: 1.0
 */
public class AdapterModelTest {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
