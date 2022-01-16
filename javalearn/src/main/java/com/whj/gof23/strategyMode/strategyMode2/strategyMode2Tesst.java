package com.whj.gof23.strategyMode.strategyMode2;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 12:14
 * @version: 1.0
 */
public class strategyMode2Tesst {

    public static void main(String[] args) throws Exception {
        A a = new A();
        final Handler handler = StrategyFactory.getInvokeStrategy("A");
        handler.method1();
        handler.method2();

    }
}
