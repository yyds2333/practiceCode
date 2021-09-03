package com.yyds.mapper;

;

import org.apache.ibatis.annotations.*;
import com.yyds.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取List<User>对象
    @Select("select * from mybatis.user_tbl")
    List<User> getUserList();
    //增加新用户
    @Insert("insert into mybatis.user_tbl (id,name,password) value (#{id},#{name},#{userPassword})")
    int userAdd(User user);
    @Insert("insert into mybatis.user_tbl (id,name,password) value (#{id},#{name},#{userPassword})")
    int userAdd2(Map map);
    //修改用户信息
    @Update("update mybatis.user_tbl set name=#{name},password=#{userPassword} where id=#{id}")
    int userModify(User user);
    //删除用户
    @Delete("delete from mybatis.user_tbl where id=${uid}")
    int userDelete(@Param("uid") int id);
    //分页查询
    List<User> getUserListOne(Map map);
}
