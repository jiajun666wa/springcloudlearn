package com.springcloud.service;

import com.springcloud.pojo.Dept;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-04 21:41
 * @version: 1.0
 */
public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(long id);
    public List<Dept> queryAll();
}
