package com.whj.gof23.adaptermodel;

/**
 * @description: 适配器类：这是一个转换器，通过继承或者引用适配者的对象，
 *               把适配者接口转化成目标接口，让客户按目标接口的格式访问适配者
 * @author: whj
 * @createTime: 2021-12-27 13:39
 * @version: 1.0
 */

public class Adapter  implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    //处理目标接口
    @Override
    public void request() {
        //此处可以做一些特殊操作，以便可以调用下面的方法
        adaptee.specificRequest();//处理适配者接口
    }


}
