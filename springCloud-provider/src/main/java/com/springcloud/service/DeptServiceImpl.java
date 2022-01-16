package com.springcloud.service;

import com.springcloud.dao.DeptMapper;
import com.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-04 21:42
 * @version: 1.0
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    DeptMapper deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept queryById(long id) {
        return deptDao.queryById(id);
    }

    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
