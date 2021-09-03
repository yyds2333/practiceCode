package com.yyds.utils;

import com.yyds.pojo.*;
import com.yyds.pojo.UserPojo.UserS;
import com.yyds.pojo.laboratoryPojo.LaboratoryJ;
import com.yyds.service.others.OthersService;
import com.yyds.service.user.UserService;

import java.util.List;

public class UserSwitchUntils {
    public static List<UserS> switchUser(List<User> userList, List<UserS> userSList, OthersService othersService, UserService userService){
        //获取department列表
        List<Role> roleList = othersService.getAllRole();
        List<Sex> sexList = othersService.getAllSex();
        for (int i=0;i<userList.size();i++){
            UserS userS = new UserS();
            User user = userList.get(i);
            userS.setId(user.getId());
            userS.setCode(user.getCode());
            userS.setUser_name(user.getUser_name());
            userS.setPassword(user.getPassword());
            for (Sex sex:sexList){
                if (sex.getId()==user.getSex()){
                    userS.setSex(sex.getSex());
                }
            }
            userS.setAge(user.getAge());
            userS.setTel_number(user.getTel_number());
            for (Role role:roleList){
                if (role.getId()==user.getRoleId()){
                    userS.setRoleId(role.getName());
                }
            }
            userSList.add(userS);
        }
        return userSList;
    }
}
