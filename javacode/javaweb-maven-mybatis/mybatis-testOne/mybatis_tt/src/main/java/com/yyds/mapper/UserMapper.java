package com.yyds.mapper;

import com.yyds.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取List<User>对象
    List<User> getUserList();
    //增加新用户
    int userAdd(User user);
    int userAdd2(Map map);
    //修改用户信息
    int userModify(User user);
    //删除用户
    int userDelete(int id);
    //分页查询
    List<User> getUserListOne(Map map);
}
