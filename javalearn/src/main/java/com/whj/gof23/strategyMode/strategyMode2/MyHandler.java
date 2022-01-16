package com.whj.gof23.strategyMode.strategyMode2;


/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-26 12:05
 * @version: 1.0
 */
public abstract class MyHandler implements Handler {
  public void method1() throws Exception {
      throw new Exception("no support method!!!");
  };
  public void method2() throws Exception {
      throw new Exception("no support method!!!");
  };

}
