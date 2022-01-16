package com.whj.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-25 15:38
 * @version: 1.0
 */
public class CommonUtils {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Base64.encodeBase64("ss".getBytes("GBK")));
        DigestUtils.md5Hex("1111");

    }

}
