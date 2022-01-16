package com.example.config;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 22:27
 * @version: 1.0
 */
public class ShiroUtil {
    public static String createSalt(){
        //生成32的随机盐值
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**
     * @param srcPwd    原始密码
     * @param saltValue 盐值
     */
    public static String saltPassword(Object srcPwd, String saltValue){
        return new Md5Hash(srcPwd,saltValue,1024).toHex(); //Md5Hash继承了SimpleHash
        //return new SimpleHash("MD5", srcPwd, saltValue, 1024).toString();
    }
}