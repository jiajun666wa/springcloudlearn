package com.whj.gof23.buildermodel;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-27 10:17
 * @version: 1.0
 */
public class BuilderModelTest {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);

        final Product product = director.getproduct();
        System.out.println(product);
    }
}
