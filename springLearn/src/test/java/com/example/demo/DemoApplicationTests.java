package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {


    @Test
    void contextLoads() {
    }



    @Autowired
    Dog dog;
    @Test
    public void dogTest(){
        System.out.println(dog); //打印看下狗狗对象
    }

    @Autowired
    Person person;
    @Test
    public void personTest(){
        System.out.println(person); //打印看下狗狗对象
    }

}
