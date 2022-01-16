package com.whj.lombok;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2022-01-09 11:23
 * @version: 1.0
 */

public class TestLombok {
    public static void main(String[] args) {
        final Animal testAnimal = Animal.builder()
                .age(1)
                .name("testAnimal")

                .build();
        System.out.println(testAnimal.toString());
    }

}

