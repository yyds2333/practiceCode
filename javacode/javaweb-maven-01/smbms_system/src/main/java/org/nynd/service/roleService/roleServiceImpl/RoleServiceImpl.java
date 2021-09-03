package org.nynd.service.roleService.roleServiceImpl;

import org.junit.Test;
import org.nynd.dao.BaseDao;
import org.nynd.dao.role.RoleDao;
import org.nynd.dao.role.RoleDaoImpl;
import org.nynd.pojo.Role;
import org.nynd.service.roleService.RoleService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    //引入dao层
    private RoleDao roleDao;
    //初始化dao对象

    public RoleServiceImpl() {
        this.roleDao = new RoleDaoImpl();
    }

    //获取用户列表
    @Override
    public List<Role> getRoleList() {
        Connection connection=null;
        List<Role> roleList=new ArrayList<>();
        try{
            connection= BaseDao.getConnection(connection);
            roleList=roleDao.getRoleList(connection);
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }
    @Test
    public void test(){
        RoleService rs=new RoleServiceImpl();
        List<Role> roleList=new ArrayList<>();
        roleList=rs.getRoleList();
        for (Role role:roleList){
            System.out.println(role);
        }
    }
}
