package com.yyds.controller;

import com.yyds.pojo.User;
import com.yyds.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    //自动装载service类
    @Autowired
    private UserService userService;

    @RequestMapping("/adminlogin")
    public String adminLogin(){
        return "adminLogin";
    }

    @RequestMapping("/userlogin")
    public String userLogin(){
        return "login";
    }

    //根据用户信息判断是否为管理员且信息是否正确，如果正确，进入后台首页
    @RequestMapping("/adminloginCheck")
    public String admin(@RequestParam("code") String code, @RequestParam("pass") String password, HttpSession session,Model model){
        User user = userService.selectUserByCode(code);
        System.out.println(user+"-=-=-=-=");
        if (user!=null){
            if (user.getPassword().equals(password) && user.getRoleId() == 1) {
                session.setAttribute("adminUser", user);
                model.addAttribute("admin",user.getUser_name());
                return "/admin/welcome";
            }else if (user.getRoleId()!=1){
                model.addAttribute("msg", "用户权限不足");
            }else{
                model.addAttribute("msg", "密码错误");
            }
        }else{
            model.addAttribute("msg","用户不存在");
        }
        return "adminLogin";
    }

    //根据用户信息判断是否正确，如果正确，进入前台首页
    @RequestMapping("/userloginCheck")
    public String user(@RequestParam("code") String code, @RequestParam("pass") String password, HttpSession session, Model model){
        User user = userService.selectUserByCode(code);
        if (user!=null){
            if (user.getPassword().equals(password)&&user.getCode().equals(code)) {
                session.setAttribute("user", user);
                return "redirect:/client/labAllUserLogin";
            }else {
                model.addAttribute("msg", "密码错误");
            }
        }else{
            model.addAttribute("msg","用户不存在");
        }
        return "login";
    }

    //根据ajax传来的数据校验是否存在用户
    @RequestMapping("/login")
    @ResponseBody
    public String userCode(@RequestParam("code") String code,Model model){
        User user = userService.selectUserByCode(code);
        System.out.println(code+"==========================="+user);
        String oso = "";
        if (user!=null&&user.getRoleId()>1){
            oso = "O";
            System.out.println("O");
        }else if (user!=null&&user.getRoleId()==1){
            oso = "P";
        }else{
            oso = "X";
            System.out.println("X");
        }
        model.addAttribute("oso",oso);
        System.out.println(oso+"null");
        return oso;
    }

}
