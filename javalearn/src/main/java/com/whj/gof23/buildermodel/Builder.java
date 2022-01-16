package com.whj.gof23.buildermodel;

/**
 * @description:  接口interface可以有具体的方法实现
 * @author: whj
 * @createTime: 2021-12-27 10:02
 * @version: 1.0
 */
public interface Builder {
    Product product = new Product();
    void buildA();
    void buildB();
    void buildC();
    void buildD();
    default Product getProduct(){
        return product;
    }
}
