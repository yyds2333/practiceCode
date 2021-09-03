package com.yyds.test;

import com.yyds.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(2333);
        Dao dao = (Dao) context.getBean("daoimpl");
        System.out.println(dao);
        dao.add();
    }
}
