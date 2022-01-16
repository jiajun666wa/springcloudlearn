package com.whj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-07 11:33
 * @version: 1.0
 */
public class MybatisUtils {
    public static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

    }

    public static SqlSession getSession(){
      return   sqlSessionFactory.openSession();
    }
}
