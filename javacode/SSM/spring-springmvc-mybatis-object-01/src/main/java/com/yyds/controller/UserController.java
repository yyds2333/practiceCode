package com.yyds.controller;

import com.yyds.pojo.User;
import com.yyds.pojo.UserPojo.UserS;
import com.yyds.service.others.OthersService;
import com.yyds.service.user.UserService;
import com.yyds.utils.UserSwitchUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
//@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private OthersService othersService;

    //查询全部角色，且返回List数组
    @RequestMapping("/getAll")
    public String selectAllUser(HttpServletRequest request,Model model){
        List<User> userList = userService.selectAllUser();
        List<UserS> userSList = new ArrayList<>();
        userSList = UserSwitchUntils.switchUser(userList,userSList,othersService,userService);
        model.addAttribute("userList",userSList);
        return "/admin/user";
    }

    @RequestMapping("/all")
    public String test(){
        return "showLabortory";
    }

    @RequestMapping("/getName")
    @ResponseBody
    public User getName(HttpSession session){
        User user = (User) session.getAttribute("adminUser");
        Integer ms=0;
        if (user.getRoleId()==1){
            ms = 1;
        }else if(user.getRoleId()==2){
            ms = 2;
        }else{
            ms = 3;
        }
        return user;
    }

    @RequestMapping("/searchByName")
    public String searchByName(String name,Model model){
        List<User> userList = userService.seleteUserByName(name);
        List<UserS> userSList = new ArrayList<>();
        userSList = UserSwitchUntils.switchUser(userList,userSList,othersService,userService);
        model.addAttribute("userList",userSList);
        return "/admin/user";
    }


    //跳转到用户修改页面
    @RequestMapping("/updateUserPage")
    public String updateUserPage(int id,Model model){
        User user = userService.selectUserById(id);
        model.addAttribute("user",user);
        return "/admin/updateUser";
    }

    @RequestMapping("/addUserPage")
    public String addUserPage(){
        return "/admin/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        int i = userService.addUser(user);
        System.err.println("User===========>"+user+"=======>");
        return "redirect:/user/getAll";
    }

    //更新完用户信息后回到用户查询列表
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/getAll";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        userService.deleteUserById(id);
        return "redirect:/user/getAll";
    }

    @RequestMapping("/getUserByCode")
    @ResponseBody
    public String getUserByCode(String code){
        User user = userService.selectUserByCode(code);
        String msf = "";
        if (user!=null){
            msf = "no";
        }else{
            msf = "yes";
        }
        return msf;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public String getUserById(int id){
        User user = userService.selectUserById(id);
        String msg = "";
        if (user!=null){
            msg = "no";
        }else{
            msg = "yes";
        }
        return msg;
    }

}
