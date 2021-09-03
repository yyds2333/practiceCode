package com.yyds.utils;

import com.yyds.pojo.Department;
import com.yyds.pojo.Laboratory;
import com.yyds.pojo.User;
import com.yyds.pojo.laboratoryPojo.LaboratoryJ;
import com.yyds.service.others.OthersService;
import com.yyds.service.user.UserService;

import java.util.List;


//工具类，转换
public class LabToLabJUntils {
    //将laboratory转换为laboratoryJ
    public static List<LaboratoryJ> switchLab(List<Laboratory> labList, List<LaboratoryJ> laboratoryJList, OthersService othersService, UserService userService){
        Laboratory lab = null;
        List<Department> department = othersService.getDepartment();
        for (int i=0;i<labList.size();i++){
            LaboratoryJ lj = new LaboratoryJ();
            lab = labList.get(i);
            userService.selectUserById(lab.getToday_m());
            lj.setId(lab.getId());
            lj.setLab_name(lab.getName());
            lj.setCode(lab.getCode());
            for (Department department1:department){
                if (lab.getDepartment()==department1.getId()){
                    lj.setDepartment(department1.getDepart_name());
                    break;
                }
            }
            if (lab.getToday_m()>0){
                lj.setToday_m(userService.selectUserById(lab.getToday_m()).getUser_name());
            }
            if (lab.getToday_n()>0){
                lj.setToday_n(userService.selectUserById(lab.getToday_n()).getUser_name());
            }
            if (lab.getToday_a()>0){
                lj.setToday_a(userService.selectUserById(lab.getToday_a()).getUser_name());
            }
            if (lab.getTom_m()>0){
                lj.setTom_m(userService.selectUserById(lab.getTom_m()).getUser_name());
            }
            if (lab.getTom_n()>0){
                lj.setTom_n(userService.selectUserById(lab.getTom_n()).getUser_name());
            }
            if (lab.getTom_a()>0){
                lj.setTom_a(userService.selectUserById(lab.getTom_a()).getUser_name());
            }
            lj.setPrincipal(lab.getPrincipal());
            lj.setCapacity(lab.getCapacity());
            laboratoryJList.add(i,lj);
        }
        return laboratoryJList;
    }
}
