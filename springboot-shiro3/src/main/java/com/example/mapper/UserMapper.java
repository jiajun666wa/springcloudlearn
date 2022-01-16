package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 14:28
 * @version: 1.0
 */
@Repository
@Mapper
public interface UserMapper {
     User queryUserByName(String name);

     void insertUser(User user);
}
