package org.nynd.service.userService.userServiceImpl;

import org.junit.Test;
import org.nynd.dao.BaseDao;
import org.nynd.dao.user.UserDao;
import org.nynd.dao.user.UserDaoImpl;
import org.nynd.pojo.User;
import org.nynd.service.userService.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    //引入dao层
    private UserDao userDao;

    //初始化userDao
    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    //通过Service层去调用dao层来查询响应的属性
    @Override
    public User loginCheck(String userCode, String userPassword) {
        Connection connection=null;
        User user=new User();
        try{
            //获取连接
            connection= BaseDao.getConnection(connection);
            //通过userCode来获取数据库中响应的信息
            user = userDao.loginUser(connection,userCode);
            if (user != null) {//获取到人物并进行对比
                System.out.println(user.getUserPassword() + "+" + userPassword);
                if (!user.getUserPassword().equals(userPassword)) {
                    System.out.println("password error!");
                    //如果密码不正确，将人物设为空
                    user = null;
                }
            } else {
                System.out.println("user is null!");
                //如果userCode不存在，将user设为null
                user = null;
            }
        }finally {
            //关闭连接
            boolean flag=true;
            flag=BaseDao.closeResource(connection,null,null);
            if (flag){
                System.out.println("Service connected success！");
            }
        }
        return user;
    }
    //根据id修改密码
    @Override
    public boolean passwordUpdate(int id, String password) {
        //创建连接
        Connection connection=null;
        connection=BaseDao.getConnection(connection);
        //调用方法获得修改结果
        boolean flag=false;
        try{
            flag=userDao.passwordUpdate(connection, id, password);
        }finally {
            System.out.println("service passwordUpdate run success!");
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
    //根据传来的userCode或者userRole查询用户数量
    @Override
    public int searchUserCount(String userName,int userRole){
        Connection connection=null;
        int count=0;
        try{
            //获取数据库链接
            connection=BaseDao.getConnection(connection);
            //获取查询数据
            count=userDao.userCount(connection,userName,userRole);
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return count;
    }
    //根据userName或者usesrRole拿到含有User对象的List结果数组
    @Override
    public List<User> pageSearch(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection=null;
        List<User> users=new ArrayList<>();
        int page=(currentPageNo-1)*5;
        try {
            connection=BaseDao.getConnection(connection);
            users=userDao.pageSearch(connection,queryUserName,queryUserRole,page,pageSize);
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        for (User user : users) {
            System.out.println("this pageSearch + "+queryUserName+"--->"+queryUserRole);
        }
        return users;

    }
    //添加新用户
    @Override
    public boolean addUser(String userCode, String userName, String userPassword, int gender, Date brithday, String phone, String address, int userRole){
        boolean flag=false;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection(connection);
            //向dao层传递参数并获取回复
            flag = userDao.addUser(connection,userCode,userName,userPassword,gender,brithday,phone,address,userRole);
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
    //根据userCode查询用户
    @Override
    public boolean userIsEmpty(String userCode) {
        Connection connection=null;
        boolean flag=false;
        try{
            connection=BaseDao.getConnection(connection);
            flag=userDao.checkUserCode(connection,userCode);
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    @Override
    public boolean add(User user) {
        // TODO Auto-generated method stub

        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection(connection);
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userDao.add(connection,user);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public User selectUserCodeExist(String userCode) {
        // TODO Auto-generated method stub
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection(connection);
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }


    @Override
    public boolean modify(User user) {
        // TODO Auto-generated method stub
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection(connection);
            if(userDao.modify(connection,user) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public User getUserById(String id) {
        // TODO Auto-generated method stub
        User user = null;
        Connection connection = null;
        try{
            connection = BaseDao.getConnection(connection);
            user = userDao.getUserById(connection,id);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            user = null;
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    @Override
    public boolean deleteUserById(Integer delId) {
        // TODO Auto-generated method stub
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection(connection);
            if(userDao.deleteUserById(connection,delId) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Test
    public void test(){
        UserService us=new UserServiceImpl();

    }
}
