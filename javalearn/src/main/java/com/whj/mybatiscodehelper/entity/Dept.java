package com.whj.mybatiscodehelper.entity;

import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2022-01-09 12:36:33
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -25889129687741831L;
    
    private Integer deptno;
    
    private String dname;
    
    private String dbSource;


    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

}