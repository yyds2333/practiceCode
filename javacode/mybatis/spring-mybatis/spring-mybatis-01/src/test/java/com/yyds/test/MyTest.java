package com.yyds.test;

import com.yyds.mapper.UserMapper;
import com.yyds.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper um=context.getBean("userMapper",UserMapper.class);
        int i=um.deleteUserById(3);
        int i2=um.deleteUserById(3);
        List<User> userList=um.getUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
