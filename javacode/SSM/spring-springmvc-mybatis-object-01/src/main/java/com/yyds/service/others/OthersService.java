package com.yyds.service.others;

import com.yyds.pojo.Department;
import com.yyds.pojo.Notice;
import com.yyds.pojo.Role;
import com.yyds.pojo.Sex;

import java.util.Date;
import java.util.List;


public interface OthersService {
    //获取所有的部门信息
    public List<Department> getDepartment();

    //获取所有的性别信息
    public List<Sex> getAllSex();

    //获取所有的身份信息
    public List<Role> getAllRole();

    //获取公告信息
    public List<Notice> getAllNotice();

    //添加公告信息
    public int addNotice(Notice notice);

    //根据id获取公告信息
    public Notice getNoticeById(int id);

    //删除公告信息
    public int deleteNoticeById(int id);

    //修改公告信息
    public int updateNotice(Notice notice);

    //
    public Date getDate();

    //
    public int updateDate(Date date);


}
