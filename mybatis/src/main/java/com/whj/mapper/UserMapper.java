package com.whj.mapper;

import com.whj.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-07 12:32
 * @version: 1.0
 */
public interface UserMapper {
    //查询全部用户
    List<User> selectUser();
    //根据id查询用户
    User selectUserById(int id);
    //添加一个用户
    int addUser(User user);
    //修改一个用户
    int updateUser(User user);

    //通过密码和名字查询用户
    User selectUserByNP(@Param("username") String username, @Param("pwd") String pwd);

    User selectUserByNP2(Map<String,Object> map);


    }

