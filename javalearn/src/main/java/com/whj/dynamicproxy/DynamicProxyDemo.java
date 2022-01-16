package com.whj.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-31 16:41
 * @version: 1.0
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        AbcstactObject subject=null;
        InvocationHandler handler = new DynamicProxyHandler(new ConcreteObject());
        subject = (AbcstactObject) Proxy.newProxyInstance(
                AbcstactObject.class.getClassLoader(),
                new Class[]{AbcstactObject.class},handler
/*                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("InvocationHandler");
//                        System.out.println("proxy==>" + proxy.toString());
//                        System.out.println("method==>" + method.getName());
//                        System.out.println("args==>" + args.toString());
                        method.invoke(new ConcreteObject(),args);
                        return null;
                    }
                }*/
                );

        subject.show("abc");

    }
}
