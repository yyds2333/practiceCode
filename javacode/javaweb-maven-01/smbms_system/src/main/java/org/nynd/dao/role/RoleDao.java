package org.nynd.dao.role;


import org.nynd.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleDao {
    //查询用户列表
    public List<Role> getRoleList(Connection connection);
}
