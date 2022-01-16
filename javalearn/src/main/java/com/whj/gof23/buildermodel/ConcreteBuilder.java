package com.whj.gof23.buildermodel;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-27 10:03
 * @version: 1.0
 */

public class ConcreteBuilder  implements Builder{
    public ConcreteBuilder(){}
    @Override
    public void buildA() {
        product.setId(1);
        System.out.println("buildA()");
    }

    @Override
    public void buildB() {
        product.setName("test");
        System.out.println("buildB()");
    }

    @Override
    public void buildC() {
        product.setDesc("desc");
        System.out.println("buildC()");
    }

    @Override
    public void buildD() {
        product.setDate("date");
        System.out.println("buildD()");
    }


}
