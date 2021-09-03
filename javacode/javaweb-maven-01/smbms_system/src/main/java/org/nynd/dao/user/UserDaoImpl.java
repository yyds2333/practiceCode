package org.nynd.dao.user;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.junit.Test;
import org.nynd.dao.BaseDao;
import org.nynd.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public User loginUser(Connection connection,String userCode) {
        User user=new User();
        //创建一个连接对象,获取连接对象,由service层创建
        //创建一个PreparementStatement对象
        PreparedStatement preparedStatement=null;
        //创建一个结果集接收对象
        ResultSet resultSet=null;
        //编写查询语句
        String sql="select * from smbms_user where userCode=?";
        //放入查询关键字
        Object[] objects={userCode};
        //调用公共查询方法取得结果集
        resultSet=BaseDao.execute(connection,preparedStatement,resultSet,sql,objects);
        //根据查询结果来为User赋值
            try{
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setAddress(resultSet.getString("address"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setCreatedBy(resultSet.getInt("createdBy"));
                    user.setCreationDate(resultSet.getDate("creationDate"));
                    user.setModifyBy(resultSet.getInt("modifyBy"));
                    user.setModifyDate(resultSet.getDate("modifyDate"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(user.getUserCode()==null){
                user=null;
                System.out.println("用户为空"+"user is null");
            }
        boolean flag=BaseDao.closeResource(null,preparedStatement,resultSet);
        if (flag){
            System.out.println("资源关闭成功 connected success");
        }else{
            System.out.println("资源关闭失败 connected failed");
        }
        return user;
    }

    //根据userId修改密码
    @Override
    public boolean passwordUpdate(Connection connection, int id, String password) {
        //创建PreparedStatement对象
        PreparedStatement preparedStatement=null;
        //创建Sql语句
        String sql="update smbms_user set userPassword = ? where id = ?";
        Object[] objects={password,id};
        //传参
        boolean flag=false;
        int count=0;
        try{
            count=BaseDao.execute(connection, preparedStatement, sql, objects);
        }finally {
            System.out.println("passwordUpdate run success!");
            BaseDao.closeResource(null,preparedStatement,null);
        }
        if (count>0){
            flag=true;
        }
        System.out.println("+++++++++++");
        System.out.println(flag);
        return flag;
    }

    //根据用户角色userRole或用户userCode查询用户数量
    @Override
    public int userCount(Connection connection, String userName, int userRole) {
        //创建一个PrepraedStatement对象
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        StringBuffer sql=new StringBuffer("select count(1) from smbms_user");
        List<Object> obj=new ArrayList<Object>();
        int count=0;
        //如果userCode不为空
        if (!userName.isEmpty()){
            //追加sql语句
            sql.append(" where userName like ? ");
            obj.add("%"+userName+"%");
        }
        //如果id不为空
        if(userRole!=0){
            //追加sql语句
            sql.append(" and userRole=?");
            obj.add(userRole);
        }
        String sqls=sql.toString();
        //调用查询语句
        rs=BaseDao.execute(connection,preparedStatement,rs,sqls, obj.toArray());
        if (rs!=null){
            try {
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, rs);
                System.out.println("userCount sql close success!");
            }
        }
        return count;
    }

    //根据用户名或用户角色进行查询
    @Override
    public List<User> pageSearch(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) {
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;

        StringBuffer sql=new StringBuffer("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
        List<Object> list = new ArrayList<Object>();
        if (!userName.isEmpty()&&!userName.equals("")){
            sql.append(" and u.userName like ?");
            //将userName的查询语句添加到查询参数中去
            list.add("%"+userName+"%");
            System.out.println("add userName in pageSearch userName is --->"+userName);
        }
        if(userRole>0){
            sql.append(" and u.userRole=?");
            //将userRole的查询语句添加到查询参数中去
            list.add(userRole);
            System.out.println("add userRole in pageSearch userRole is --->"+userRole);
        }
        //最后将分页语句添加到查询语句末尾
        sql.append(" order by creationDate DESC limit ?,?");
        System.out.println("UserDao---->"+currentPageNo+""+pageSize);
        list.add(currentPageNo);
        list.add(pageSize);
        String sqls=sql.toString();
        System.out.println("sqls--->"+sqls+"--->"+userName+"----->"+userRole+"---->"+pageSize);
        //查询并拿到结果
        rs=BaseDao.execute(connection,preparedStatement,rs,sqls,list.toArray());
        //将查询结果装到一个User数组中
        List<User> users=new ArrayList<>();
        try {
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setUserRole(rs.getInt("userRole"));
                //将User对象装入list数组
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        for (User user:users){
            System.out.print("UserDaoImpl--->");
            System.out.println(user);
        }
        //返回List集合
        return users;
    }

    //添加新用户
    @Override
    public boolean addUser(Connection connection, String userCode, String userName, String userPassword, int gender, Date brithday, String phone, String address, int userRole) {
        PreparedStatement preparedStatement=null;
        //用来统计受影响的行数
        int count=0;
        //用来返回数据
        boolean flag=false;
        String sql = "insert into smbms_user values(null,?,?,?,?,?,?,?,?,null,?,null,null)";
        Date date=new Date();
        Object[] objects={userCode,userName,userPassword,gender,brithday,phone,address,userRole,date};
        try{
            count=BaseDao.execute(connection,preparedStatement,sql,objects);
        }finally {
            BaseDao.closeResource(null,preparedStatement,null);
        }
        if (count>0){
            flag=true;
        }
        return flag;
    }

    //查询是否存在相同userCode
    @Override
    public boolean checkUserCode(Connection connection, String userCode) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        boolean flag=false;
        String sql="select * from smbms_user where userCode=?";
        //执行sql
        try {
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,null);
            if (!resultSet.next()){
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }
        return flag;
    }

    @Override
    public int add(Connection connection, User user){
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        int updateRows = 0;
        if(null != connection){
            String sql = "insert into smbms_user (userCode,userName,userPassword," +
                    "userRole,gender,birthday,phone,address,creationDate,createdBy) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {user.getUserCode(),user.getUserName(),user.getUserPassword(),
                    user.getUserRole(),user.getGender(),user.getBirthday(),
                    user.getPhone(),user.getAddress(),user.getCreationDate(),user.getCreatedBy()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }


    @Override
    public User getLoginUser(Connection connection, String userCode)
            throws Exception {
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if(null != connection){
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    @Override
    public User getUserById(Connection connection, String id) throws Exception {
        // TODO Auto-generated method stub
        User user = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if(null != connection){
            String sql = "select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.id=? and u.userRole = r.id";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
                user.setUserRoleName(rs.getString("userRoleName"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    @Override
    public int modify(Connection connection, User user) throws Exception {
        // TODO Auto-generated method stub
        int flag = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update smbms_user set userName=?,"+
                    "gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] params = {user.getUserName(),user.getGender(),user.getBirthday(),
                    user.getPhone(),user.getAddress(),user.getUserRole(),user.getModifyBy(),
                    user.getModifyDate(),user.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    @Override
    public int deleteUserById(Connection connection,Integer delId) throws Exception {
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        int flag = 0;
        if(null != connection){
            String sql = "delete from smbms_user where id=?";
            Object[] params = {delId};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    @Override
    public Date getDateS() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from open_laboratory.lab_date";
        connection = BaseDao.getConnection(connection);
        Object[] obj = new Object[0];
        Date date = null;
        resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,obj);
        try{
            while (resultSet.next()) {
                date = resultSet.getDate(1);
            }
        }catch (Exception e){

        }
        return date;
    }

    @Test
    public void test(){
        Date date = getDateS();
        System.out.println(date);
        Date date1 = new Date();
        System.out.println(date1);

        System.out.println(date.getDay()+"s"+date1.getDay());
    }

}
