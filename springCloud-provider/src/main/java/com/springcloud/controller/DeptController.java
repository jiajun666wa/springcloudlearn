package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-04 21:45
 * @version: 1.0
 */
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        System.out.println("dept"+ dept.toString());
        return deptService.addDept(dept);
    }
    @GetMapping(("/dept/get/{id}"))
    public Dept queryById(@PathVariable("id") long id){
        return deptService.queryById(id);
    }
    @GetMapping(("/dept/list"))
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
}
