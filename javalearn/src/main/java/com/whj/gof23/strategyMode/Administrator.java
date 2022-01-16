package com.whj.gof23.strategyMode;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 11:16
 * @version: 1.0
 */
public class Administrator extends Person implements MangeOperationInterface{
    @Override
    public void manage() {
        System.out.println("Administrator.manage()");
    }
}
