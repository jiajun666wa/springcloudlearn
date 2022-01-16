package com.whj.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-31 16:56
 * @version: 1.0
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object obj;
    DynamicProxyHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(obj,args);
        return null;
    }
}
