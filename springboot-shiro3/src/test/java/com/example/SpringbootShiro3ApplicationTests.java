package com.example;

import com.example.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiro3ApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
    }

    @Test
    void testUserQueryByName() {
        System.out.println(userService.queryUserByName("张三"));
    }

}
