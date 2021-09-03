package com.yyds.mapper;

import com.yyds.pojo.User;
import com.yyds.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
        //获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //通过sqlSession对象的getMapper方法获取一个UserMapper动态代理类
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getUserList();
        for (User user:userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    //添加用户
    @Test
    public void userAdd(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper接口的实例化对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setId(8);
        user.setName("大西瓜");
        user.setUserPassword("5418899");
        System.out.println(user);
        int i=mapper.userAdd(user);

        //提交事务
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void userAdd2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("id",7);
        map.put("username","uuyd");
        map.put("password","00000");
        int i=mapper.userAdd2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    //修改用户
    @Test
    public void userUpadte(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        //动态代理生产Mapper对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setId(2);
        user.setName("hhh");
        user.setUserPassword("9888");
        int i=mapper.userModify(user);
        System.out.println(i);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //删除用户
    @Test
    public void userDelect(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int i=mapper.userDelete(5);

        //提交事务
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    //分页查询用户
    @Test
    public void userListOne(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Map<String,Object> map=new HashMap<>();
        map.put("startIndex",6);
        map.put("pageSize",2);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getUserListOne(map);
        for (User user : userList) {
            System.out.println(user);
        }
        Logger logger=Logger.getLogger(UserMapper.class);
        logger.info("info:这是info输出");
        sqlSession.close();
    }
}
