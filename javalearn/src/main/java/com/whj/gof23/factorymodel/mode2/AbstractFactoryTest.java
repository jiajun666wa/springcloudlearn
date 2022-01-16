package com.whj.gof23.factorymodel.mode2;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-28 00:34
 * @version: 1.0
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        final MyAbstractFactory factoryXM = new ConcreteFactoryXM();
        factoryXM.ProductWatch().show();
        factoryXM.ProductPhone().show();

    }
}
