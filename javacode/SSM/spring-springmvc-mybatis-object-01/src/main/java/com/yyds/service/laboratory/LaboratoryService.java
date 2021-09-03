package com.yyds.service.laboratory;

import com.yyds.pojo.Laboratory;
import com.yyds.pojo.laboratoryPojo.LabDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LaboratoryService {
    //获取全部实验室信息
    public List<Laboratory> getAllLaboratory();
    //根据实验室id或实验室code获取信息 获取实验室信息
    public List<Laboratory> getLaboratory(@Param("id") int id, @Param("code") String code,String lab_name);
    //根据实验室所属院系获取实验室信息
    public List<Laboratory> getLaboratoryByDepartment(@Param("department") int department);
    //根据id获取实验室预约情况
    public List<LabDate> getLaboratoryDate(int id);
    //根据预约情况查询
    public List<Laboratory> getLaboratoryByLabDate(LabDate labDate);
    //增加实验室
    public int addLabortory(Laboratory laboratory);
    //删除实验室
    public int deleteLabortory(@Param("id") int id);
    //修改实验室信息
    public int updateLabtory(Laboratory laboratory);
    //修改预约信息
    public int updateLabtoryById(LabDate labDate);
    //置零预约信息
    public int updateLabtoryByIdClear(LabDate labDate);
    //根据LabDate设置,根据时间将后一天的信息挪到当天
    public int updateLabDate();
    //设置laboratory的预约值
    public int updateLabDateNull(int id);
    //将所有预约置为0
    public int zeroLabDate();
}
