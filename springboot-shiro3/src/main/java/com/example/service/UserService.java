package com.example.service;

import com.example.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 15:09
 * @version: 1.0
 */

public interface UserService {
    public User queryUserByName(String name);

    public void insertUser(User user);
}
