package com.yyds.mapper;

import com.yyds.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{
    //原来由sqlSession完成的工作，现在交由sqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUser() {
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        return userMapper.getUser();
    }

    @Override
    public int deleteUserById(int id) {
        return sqlSession.getMapper(UserMapper.class).deleteUserById(id);
    }
}
