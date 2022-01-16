package com.springcloud.dao;

import com.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.zip.Deflater;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-04 21:32
 * @version: 1.0
 */
@Mapper
@Repository
public interface DeptMapper {
    public boolean addDept(Dept dept);
    public Dept queryById(long id);
    public List<Dept> queryAll();
}
