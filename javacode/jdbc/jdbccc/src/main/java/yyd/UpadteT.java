package yyd;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UpadteT {
    public static void uPdate() throws  Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsql?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=true", "root","54188");
        PreparedStatement preparedStatement=connection.prepareStatement("update smbms_role set createdBy=1 creationDate=? where id=2");
        DateFormat dateFormat=new SimpleDateFormat();
        System.out.println(dateFormat);
        preparedStatement.setObject(1,dateFormat.getCalendar().getTime());
        int i=preparedStatement.executeUpdate();
    }

    public static void main(String[] args) {
        try {
            DateFormat dateFormat=new SimpleDateFormat();
            dateFormat.getCalendar().getTime();
            System.out.println(dateFormat.getCalendar().getTime());
            uPdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
