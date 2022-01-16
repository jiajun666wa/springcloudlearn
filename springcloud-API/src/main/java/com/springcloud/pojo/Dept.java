package com.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-04 20:51
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@Accessors //链式写法
public class Dept implements Serializable {
    private long deptno;
    private String dname;
    private String db_source;

   public Dept(String dname){
       this.dname = dname;
   }
   /*
    链式写法:
   Dept  dept = new Dept();
   dept.setDeptNo(11).setDname("tesst");
   */
}
