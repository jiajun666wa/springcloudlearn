package com.whj.gof23.factorymodel.mode1;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-28 00:00
 * @version: 1.0
 */
public class ConcreteFactory1 implements AbstractFactory{
    @Override
    public Product1 newProduct1() {
        return new ConcreteProduct12();
    }

    @Override
    public Product2 newProduct2() {
        return  new ConcreteProduct22();
    }
}
