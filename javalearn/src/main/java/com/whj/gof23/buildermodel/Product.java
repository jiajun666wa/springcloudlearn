package com.whj.gof23.buildermodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-27 10:02
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String desc;
    private  String date;
}
