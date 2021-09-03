package org.nynd.util;

import org.junit.Test;
import org.nynd.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//用户分页工具类
//一页数量
//总页数
//当前页码
public class PageSupport {
    //当前页
    private int currentPageNo=1;
    //总表数
    private int totalPage=0;
    //页面容量
    private int pageSize=0;
    //总页数
    private int totalPageCount=1;

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo>0){
            this.currentPageNo = currentPageNo;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        if (totalPage>0){
            this.totalPage = totalPage;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize>0){
            this.pageSize = pageSize;
        }
    }

    public int getTotalPageCount() {
        if (pageSize!=0){
            //总页数由数据总量除单页数据容量得出
            totalPageCount=(totalPage-1)/pageSize+1;
        }
        return totalPageCount;
    }

    @Test
    public void test(){
        System.out.println((0-1)/(4)+1);
//        Connection connection=null;
//        PreparedStatement preparedStatement=null;
//        String sql="select count(1) from smbms_user";
//        int i=0;
//        ResultSet rs=null;
//        rs=BaseDao.execute(BaseDao.getConnection(connection),preparedStatement,rs,sql,null);
//        try{
//            while (rs.next()) {
//                i=rs.getInt(1);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        System.out.println(i);
    }
}
