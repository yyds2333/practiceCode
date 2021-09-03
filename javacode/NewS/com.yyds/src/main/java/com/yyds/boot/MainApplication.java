package com.yyds.boot;

import ch.qos.logback.core.db.DBHelper;
import com.yyds.boot.bean.Pet;
import com.yyds.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
* @SpringBootApplication:告诉SpringBoot这是一个SpringBoot应用
*/
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        User user = run.getBean("user01",User.class);

        Pet pet = run.getBean("tom",Pet.class);

        System.out.println("用户的宠物:"+(user.getPet()==pet));

        System.out.println("============================>");

        String[] beanNamesFroType = run.getBeanNamesForType(User.class);

        for (String name:beanNamesFroType){
            System.out.println(name);
        }
        System.out.println(run.getBean(DBHelper.class));
    }
}
