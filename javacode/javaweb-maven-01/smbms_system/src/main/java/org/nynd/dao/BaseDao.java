package org.nynd.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    //连接数据库基本
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    //使用静态代码块进行数据库连接资源的读取
    static {
        InputStream im=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
        Properties properties=new Properties();
        try {
            properties.load(im);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }

    //获取连接
    public static Connection getConnection(Connection connection){
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    // 基础查询公共类
    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] obj){
        try {
            preparedStatement=connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            System.out.println("获取PreparedStatement错误");
            throwables.printStackTrace();
        }
        if (obj!=null){
            for (int i = 0; i < obj.length; i++) {
                try {
                    preparedStatement.setObject(i + 1, obj[i]);
                } catch (SQLException throwables) {
                    System.out.println("添加PreparedStatement参数错误");
                    throwables.printStackTrace();
                }
            }
        }
        try {
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            System.out.println("查询ResultSet错误");
            throwables.printStackTrace();
        }
        System.out.println("BaseDao--->"+sql);
        return resultSet;
    }

    //重载execute方法，增删改公共查询方法
    public static int execute(Connection connection,PreparedStatement preparedStatement,String sql,Object[] obj){
        //定义一个boolean用来接收返回值
       int count=0;
        try {
            preparedStatement=connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            System.out.println("获取PreparedStatement错误");
            throwables.printStackTrace();
        }
        for (int i=0;i< obj.length;i++){
            try {
                preparedStatement.setObject(i+1,obj[i]);
            } catch (SQLException throwables) {
                System.out.println("添加PreparedStatement参数错误");
                throwables.printStackTrace();
            }
        }
        try {
            count=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
    //关闭连接公共类
    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        //设置一个boolean来返回是否关闭成功
        boolean flag=true;
        if (resultSet!=null){
            try {
                resultSet.close();
                //通知GC回收
                resultSet=null;
            } catch (SQLException throwables) {
                System.out.println("ResultSet关闭失败");
                flag=false;
                throwables.printStackTrace();
            }
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
                //通知GC回收
                preparedStatement=null;
            } catch (SQLException throwables) {
                System.out.println("PreparedStatement关闭失败");
                flag=false;
                throwables.printStackTrace();
            }
        }
        if (preparedStatement!=null){
            try {
                connection.close();
                //通知GC回收
                connection=null;
            } catch (SQLException throwables) {
                System.out.println("Connection关闭失败");
                flag=false;
                throwables.printStackTrace();
            }
        }
        return flag;
    }
}
