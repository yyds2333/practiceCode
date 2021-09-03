package com.yyds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/outLogin")
public class OutLoginController {
    //注销
    @RequestMapping("/outloginUser")
    public String outLoginUser(HttpSession session){
        if (session.getAttribute("user")!=null){
            session.removeAttribute("user");
            return "login";
        }
        return "redirect:/unLoginPage/laboratoryList";
    }

    @RequestMapping("/outLoginAdmin")
    public String outLoginAdmin(HttpSession session){
        if (session.getAttribute("adminUser")!=null){
            session.removeAttribute("adminUser");
            return "adminLogin";
        }
        return "redirect:/unLoginPage/laboratoryList";
    }
}
