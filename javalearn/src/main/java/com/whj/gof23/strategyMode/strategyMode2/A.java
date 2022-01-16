package com.whj.gof23.strategyMode.strategyMode2;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 12:07
 * @version: 1.0
 */
public class A extends MyHandler {
    public A(){
        afterSetProperties();
    }

    @Override
    public void afterSetProperties() {
        StrategyFactory.register("A",this);
    }

    @Override
    public void method1() {
        System.out.println("A.method1()");
    }

}
