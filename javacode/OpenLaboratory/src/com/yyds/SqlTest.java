package com.yyds;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newsql?serverTimezone=GMT","root","54188");
        Statement stat=conn.createStatement();
        ResultSet rs=stat.executeQuery("select last_name from tbl_employ where id=2");
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
    }
}
