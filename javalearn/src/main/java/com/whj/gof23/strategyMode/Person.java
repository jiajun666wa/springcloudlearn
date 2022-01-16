package com.whj.gof23.strategyMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 11:14
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private String desc;
    //普通操作
    public void doSomething(){
        System.out.println("Person.doSomething() ");
    }
    //管理操作
//    public void manage(){
//        System.out.println("Person.manage() ");
//    }
}
