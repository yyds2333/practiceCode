package com.yyds.mapper;

import com.yyds.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    //查询学生
    List<Student> getStudent2();
    //
    List<Student> getStudent();
}
