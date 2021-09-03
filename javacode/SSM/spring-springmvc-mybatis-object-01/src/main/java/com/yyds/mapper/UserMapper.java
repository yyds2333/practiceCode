package com.yyds.mapper;

import com.yyds.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


public interface UserMapper {
    //增加一个用户
    public int addUser(User user);

    //删除一个用户
    public int deleteUserById(@Param("id") int id);

    //修改一个用户
    public int updateUser(User user);

    //查询一个用户
    public User selectUserById(@Param("id")int id);

    //查询所有用户
    public List<User> selectAllUser();

    //模糊查询用户
    public List<User> seleteUserByName(String name);

    //通过code查询一个用户
    public User selectUserByCode(@Param("code")String code);

}
