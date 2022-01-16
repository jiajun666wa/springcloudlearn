package com.example.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-22 21:01
 * @version: 1.0
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
}
