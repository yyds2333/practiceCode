package org.yyds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/tt")
    public String getJudge(String username,String password){
        String msg="";
        if (username.equals("亚迪")){
            msg="ok";
        }else {
            msg="error";
        }
        if (password.equals("234567")){
            msg="ok";
        }else {
            msg="error";
        }
        System.out.println("coming");

        return msg;
    }
}
