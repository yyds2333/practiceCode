package com.yyds.utils;

import com.yyds.pojo.laboratoryPojo.LabDate;
import com.yyds.service.laboratory.LaboratoryService;
import com.yyds.service.others.OthersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DateCheckUtils {

    //用来实时改变数据库中
    public static void justiceDate(OthersService othersService, LaboratoryService laboratoryService, LabDate labDate){
        Date before = othersService.getDate();
        Date now = new Date();
        if (before.getMonth()-now.getMonth()==0){
            if (now.getDay()-before.getDay()==1){
                othersService.updateDate(new Date());
                laboratoryService.updateLabDate();
            }else if (now.getDay()-before.getDay()>1){
                othersService.updateDate(new Date());
                laboratoryService.zeroLabDate();//距离上次预约过去超过两天，清除信息
            }
        }else if (before.getMonth()-now.getMonth()==1){
            if (before.getMonth()==1&before.getMonth()==3&before.getMonth()==5&before.getMonth()==7&before.getMonth()==8&before.getMonth()==10&before.getMonth()==12){
                if (now.getDay()==1){
                    if (before.getYear()%4==0&&before.getYear()%100!=0){
                        if (before.getDay()-now.getDay()==30){

                        }
                    }
                }
            }else if (before.getMonth()==2){

            }
        }else{
            othersService.updateDate(new Date());
            laboratoryService.zeroLabDate();//距离上次预约过去超过两天，清除信息
        }
    }


}
