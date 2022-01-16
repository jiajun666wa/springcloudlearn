package com.whj.gof23.strategyMode;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 11:19
 * @version: 1.0
 */
@Slf4j
public class StrategyModelTest {

    public static void main(String[] args) {
        Officer officer = new Officer();
        officer.setDesc("officer desc");
        System.out.println(officer.getDesc());
//        officer.manage();
        log.info("===================================");
        Administrator administrator = new Administrator();
        administrator.manage();
        administrator.doSomething();

    }
}
