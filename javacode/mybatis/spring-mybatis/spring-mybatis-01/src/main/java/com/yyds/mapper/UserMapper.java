package com.yyds.mapper;

import com.yyds.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> getUser();
    public int deleteUserById(@Param("id") int id);
}
