package com.whj.gof23.strategyMode.strategyMode3;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 14:48
 * @version: 1.0
 */
public class FlyWithWing implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("FlyWithWing.fly()");
    }
}
