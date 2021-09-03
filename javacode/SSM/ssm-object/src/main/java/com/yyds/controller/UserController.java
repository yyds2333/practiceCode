package com.yyds.controller;

import com.yyds.pojo.User;
import com.yyds.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //查询全部角色，且返回List数组
    @RequestMapping("/getAll")
    public String selectAllUser(Model model){
        List<User> userList=userService.selectAllUser();
        model.addAttribute("list",userList);
        return "allUser";
    }

}
