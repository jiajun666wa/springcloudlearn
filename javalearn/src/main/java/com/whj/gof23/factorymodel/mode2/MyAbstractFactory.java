package com.whj.gof23.factorymodel.mode2;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-28 00:20
 * @version: 1.0
 */
public interface MyAbstractFactory {
    Phone ProductPhone();
    Watch ProductWatch();
//    Sing  ProductSing();
}
