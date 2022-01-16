package com.example.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-11 17:46
 * @version: 1.0
 */
@Data
@Component //注册bean
public class Dog {

    private String name;
    private Integer age;
}