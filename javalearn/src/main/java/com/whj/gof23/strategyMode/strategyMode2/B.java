package com.whj.gof23.strategyMode.strategyMode2;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 12:10
 * @version: 1.0
 */
public class B extends MyHandler {
    @Override
    public void method2() {
        System.out.println("B.method2()");
    }

    @Override
    public void afterSetProperties() {
        StrategyFactory.register("B",this);
    }
}
