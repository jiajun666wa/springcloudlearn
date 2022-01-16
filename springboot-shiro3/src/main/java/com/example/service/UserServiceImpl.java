package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 15:10
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
