package com.whj.gof23.strategyMode.strategyMode3;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 14:43
 * @version: 1.0
 */
public class Duck {
    private FlyBehavior flyBehavior;
    public Duck(){}
    public Duck(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    public void quack(){
        System.out.println(flyBehavior);
    };
    public void swim(){};
    public void display(){};
    public void fly(){
        flyBehavior.fly();
    }

}
