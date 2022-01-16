package com.whj.gof23.buildermodel;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-27 10:03
 * @version: 1.0
 */
public class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product getproduct(){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        return builder.getProduct();
    }
}
