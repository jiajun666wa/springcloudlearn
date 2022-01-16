package com.whj.gof23.factorymodel.mode2;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-28 00:24
 * @version: 1.0
 */
public class ConcreteFactoryXM implements MyAbstractFactory{
    @Override
    public Phone ProductPhone() {
        return new PhoneXM();
    }

    @Override
    public Watch ProductWatch() {
        return new WatchXM();
    }
}
