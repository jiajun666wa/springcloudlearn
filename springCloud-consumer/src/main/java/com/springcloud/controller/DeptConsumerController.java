package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-04 23:25
 * @version: 1.0
 */
@RestController
public class DeptConsumerController {

    public final static String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private  RestTemplate restTemplate;

    @GetMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class,id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return (List<Dept>) restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


}
