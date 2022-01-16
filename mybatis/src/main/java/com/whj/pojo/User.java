package com.whj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-07 12:28
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String pwd;

}
