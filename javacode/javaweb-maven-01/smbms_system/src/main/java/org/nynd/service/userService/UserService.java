package org.nynd.service.userService;

import org.nynd.pojo.User;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface UserService {
    //用户提交登录所需的信息
    public User loginCheck(String userCode,String userPassword);
    //根据userId修改密码
    public boolean passwordUpdate(int id,String password);
    //根据传来的userCode或者userRole查询用户数量
    public int searchUserCount(String userName,int userRole);
    //根据userName或者usesrRole拿到含有User对象的List结果数组
    public List<User> pageSearch(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
    //添加新用户
    public boolean addUser(String userCode, String userName, String userPassword, int gender, Date brithday, String phone, String address, int userRole);
    //根据userCode查询用户是否存在
    public boolean userIsEmpty(String userCode);
    //增加用户
    public boolean add(User user);
    //
    public User selectUserCodeExist(String userCode);
    //
    public boolean modify(User user);

    User getUserById(String id);

    public boolean deleteUserById(Integer delId);
}
