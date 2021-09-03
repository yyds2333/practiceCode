package com.yyds.boot.controller;


import com.yyds.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car cca(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello,Spring Boot2!";
    }
}
