package com.uuyd.config;

import com.uuyd.pojo.Dog;
import com.uuyd.pojo.User;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.uuyd.pojo")
@Scope("singleton")
public class YdsConfig {

    @Bean
    public User getUser(){
        return new User();
    }

    @Bean
    public Dog getDog(){
        return new Dog("daooo");
    }

    @Bean
    public Dog getDog1(){
        return new Dog();
    }
}
