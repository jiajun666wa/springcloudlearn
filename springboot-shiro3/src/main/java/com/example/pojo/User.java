package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 14:26
 * @version: 1.0
 */
@Data //getter setter
@NoArgsConstructor //无参
@AllArgsConstructor //全参
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
    private String perms;
    private String saltValue; //盐值
}
