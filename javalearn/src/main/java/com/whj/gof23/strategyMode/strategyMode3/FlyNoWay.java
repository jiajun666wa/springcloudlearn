package com.whj.gof23.strategyMode.strategyMode3;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 14:49
 * @version: 1.0
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("FlyNoWay.fly()");
    }
}
