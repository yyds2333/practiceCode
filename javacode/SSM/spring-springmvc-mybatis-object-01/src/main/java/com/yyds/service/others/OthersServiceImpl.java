package com.yyds.service.others;

import com.yyds.mapper.OthersMapper;
import com.yyds.pojo.Department;
import com.yyds.pojo.Notice;
import com.yyds.pojo.Role;
import com.yyds.pojo.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OthersServiceImpl implements OthersService{

    @Autowired
    private OthersMapper othersMapper;

    @Override
    public List<Department> getDepartment() {
        return othersMapper.getDepartment();
    }

    @Override
    public List<Sex> getAllSex() {
        return othersMapper.getAllSex();
    }

    @Override
    public List<Role> getAllRole() {
        return othersMapper.getAllRole();
    }

    @Override
    public List<Notice> getAllNotice() {
        return othersMapper.getAllNotice();
    }

    @Override
    public int addNotice(Notice notice) {
        return othersMapper.addNotice(notice);
    }

    @Override
    public Notice getNoticeById(int id) {
        return othersMapper.getNoticeById(id);
    }

    @Override
    public int deleteNoticeById(int id) {
        return othersMapper.deleteNoticeById(id);
    }

    @Override
    public int updateNotice(Notice notice) {
        return othersMapper.updateNotice(notice);
    }

    @Override
    public Date getDate() {
        return othersMapper.getDate();
    }

    @Override
    public int updateDate(Date date) {
        return othersMapper.updateDate(date);
    }
}
