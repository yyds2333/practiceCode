package org.nynd.dao.role;

import org.nynd.dao.BaseDao;
import org.nynd.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    //查询用户列表
    @Override
    public List<Role> getRoleList(Connection connection) {
        //创建数据库操作对像
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        //数据库连接语句
        String sql="select * from smbms_role";
        Object[] objects={};
        if (connection!=null){
            resultSet= BaseDao.execute(connection,preparedStatement,resultSet,sql,objects);
        }
        List<Role> roleList=new ArrayList<>();
        try {
            while(resultSet.next()){
                Role _role=new Role();
                _role.setId(resultSet.getInt("id"));
                _role.setRoleCode(resultSet.getString("roleCode"));
                _role.setRoleName(resultSet.getString("roleName"));
                roleList.add(_role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }
        return roleList;
    }
}
