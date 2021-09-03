package com.yyds.mapper;

import com.yyds.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher2(@Param("id") int id);
    List<Teacher> getTeacher(@Param("id") int id);
}
