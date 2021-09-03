package com.yyds.service.laboratory;

import com.yyds.mapper.LaboratoryMapper;
import com.yyds.pojo.Laboratory;
import com.yyds.pojo.laboratoryPojo.LabDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service//标明这是一个Service层的spring组件，虽然已经在配置文件中设置了扫描Service下的所有包,其实可以省略
public class LaboratoryServiceImpl implements LaboratoryService{
    //引入mapper层
    private LaboratoryMapper laboratoryMapper;

    @Autowired
    public void setLaboratoryMapper(LaboratoryMapper laboratoryMapper) {
        this.laboratoryMapper = laboratoryMapper;
    }

    @Override
    public List<Laboratory> getAllLaboratory() {
        return laboratoryMapper.getAllLaboratory();
    }

    @Override
    public List<Laboratory> getLaboratory(int id, String code,String lab_name) {
        if (lab_name!=null){
            lab_name = "%"+lab_name+"%";
        }
        return laboratoryMapper.getLaboratory(id, code,lab_name);
    }

    @Override
    public List<Laboratory> getLaboratoryByDepartment(int department) {
        return laboratoryMapper.getLaboratoryByDepartment(department);
    }

    @Override
    public List<LabDate> getLaboratoryDate(int id) {
        return laboratoryMapper.getLaboratoryDate(id);
    }

    @Override
    public List<Laboratory> getLaboratoryByLabDate(LabDate labDate) {
        return laboratoryMapper.getLaboratoryByLabDate(labDate);
    }

    @Override
    public int addLabortory(Laboratory laboratory) {
        return laboratoryMapper.addLabortory(laboratory);
    }

    @Override
    public int deleteLabortory(int id) {
        return laboratoryMapper.deleteLabortory(id);
    }

    @Override
    public int updateLabtory(Laboratory laboratory) {
        return laboratoryMapper.updateLabtory(laboratory);
    }

    @Override
    public int updateLabtoryById(LabDate labDate) {
        return laboratoryMapper.updateLabtoryById(labDate);
    }

    @Override
    public int updateLabtoryByIdClear(LabDate labDate) {
        return laboratoryMapper.updateLabtoryByIdClear(labDate);
    }

    @Override
    public int updateLabDate() {
        return laboratoryMapper.updateLabDate();
    }

    @Override
    public int updateLabDateNull(int id) {
        return laboratoryMapper.updateLabDateNull(id);
    }

    @Override
    public int zeroLabDate() {
        return laboratoryMapper.zeroLabDate();
    }
}
