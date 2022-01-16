package com.whj.gof23.strategyMode.strategyMode3;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 14:43
 * @version: 1.0
 */
public class GreeenDuck extends Duck{

    private FlyBehavior flyable;
    public GreeenDuck(FlyBehavior flyable) {
        this.flyable  = flyable;
    }

    @Override
    public void display() {

    }
    public void fly(){
        System.out.println("GreeenDuck.fly()");
        flyable.fly();
    }

    public static void main(String[] args) {
        FlyWithWing flyWithWing = new FlyWithWing();
        final GreeenDuck greeenDuck = new GreeenDuck(flyWithWing);
        greeenDuck.fly();

        greeenDuck.quack();
    }
}
