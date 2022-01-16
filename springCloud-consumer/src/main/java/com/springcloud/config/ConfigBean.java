package com.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-04 23:27
 * @version: 1.0
 */
@Configuration
public class ConfigBean {

    @Bean
    RestTemplate getRestTemplate(){
       return new RestTemplate();
    }

}
