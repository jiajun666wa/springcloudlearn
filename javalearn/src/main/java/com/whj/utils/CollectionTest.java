package com.whj.utils;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-25 15:50
 * @version: 1.0
 */
public class CollectionTest {
    public static void main(String[] args) {
        CollectionUtils.isNotEmpty( new ArrayList<>());

        final ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        final List<List<Object>> lists = Lists.partition(list, 8);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("============================");
            final List<Object> list1 = lists.get(i);
            list1.forEach(System.out::print);
        }
    }
}
