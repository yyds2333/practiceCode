package com.zyds.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

//获取sqlSession对象的工具类
@SuppressWarnings("all")
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    //获取一个sqlSessionFactory对象的工具类
    static {
        //获取配置文件中的核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            System.out.println(sqlSessionFactory+"2333");
            e.printStackTrace();
        }
    }
    //通过SqlSessionFactory获取SqlSession对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}

