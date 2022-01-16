package com.whj.mybatiscodehelper.controller;

import com.whj.mybatiscodehelper.entity.Dept;
import com.whj.mybatiscodehelper.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Dept)表控制层
 *
 * @author makejava
 * @since 2022-01-09 12:36:37
 */
@RestController
@RequestMapping("dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Dept selectOne(Integer id) {
        return this.deptService.queryById(id);
    }

}