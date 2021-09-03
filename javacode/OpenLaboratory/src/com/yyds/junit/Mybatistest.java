package com.yyds.junit;

import com.yyds.test.Employ;
import com.yyds.test.EmployMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Mybatistest {

    /*
    * 1,根据配置文件（全局配置文件）创建一个SqlsessionFactory对象
    *
    *
    */
    @Test
    public void test() throws IOException {

        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession实例，能够执行已经映射的SQL语句
        SqlSession openSession= sqlSessionFactory.openSession();
        //sql的唯一标识
        //sql的执行要用的参数
        try {
            Employ employ = openSession.selectOne("com.yyds.test.EmployMapper.selectEmp", 2);
            System.out.println(employ);
        }finally {
            openSession.close();
        }

    }

    @Test
    public void test1() throws IOException{
        String resource= "mybatis_config.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //
        SqlSession openSession=sqlSessionFactory.openSession();
        try {
            //
            EmployMapper employMapper = openSession.getMapper(EmployMapper.class);
            //
            Employ employ = employMapper.getEmpById(2);
            System.out.println(employMapper.getClass());
            System.out.println(employ);
        }finally {
            openSession.close();
        }

    }
}
