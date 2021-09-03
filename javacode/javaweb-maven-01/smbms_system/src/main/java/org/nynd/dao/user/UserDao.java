package org.nynd.dao.user;

import org.nynd.pojo.User;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface UserDao {
    //查询登录用户的方法
    public User loginUser(Connection connection,String userCode);
    //修改当前用户密码
    public boolean passwordUpdate(Connection connection,int id,String password);
    //根据用户角色或用户userCode查询用户数量
    public int userCount(Connection connection,String userName,int userROle);
    //根据用户名或用户角色进行查询
    public List<User> pageSearch(Connection connection,String userName,int userRole,int currentPageNo,int pageSize);
    //添加新用户
    public boolean addUser(Connection connection, String userCode, String userName, String userPassword, int gender, Date brithday,String phone,String address,int userRole);
    //查询userCode获取该角色是否已存在
    public boolean checkUserCode(Connection connection,String userCode);
    //增加用户信息
    public int add(Connection connection, User user);

    //
    public User getLoginUser(Connection connection, String userCode)
            throws Exception;
    //
    public User getUserById(Connection connection, String id) throws Exception;
    //
    public int modify(Connection connection, User user) throws Exception;
    //
    public int deleteUserById(Connection connection,Integer delId) throws Exception;

    //获取时间
    public Date getDateS();
}
