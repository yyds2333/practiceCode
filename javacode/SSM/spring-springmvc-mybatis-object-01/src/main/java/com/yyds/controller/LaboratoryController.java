package com.yyds.controller;


import com.alibaba.fastjson.JSON;
import com.yyds.pojo.Laboratory;
import com.yyds.pojo.laboratoryPojo.LabDate;
import com.yyds.pojo.laboratoryPojo.LaboratoryJ;
import com.yyds.service.laboratory.LaboratoryService;
import com.yyds.service.others.OthersService;
import com.yyds.service.user.UserService;
import com.yyds.utils.LabToLabJUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/laboratory")//该页面管理所有的laboratory的数据
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;

    @Autowired
    private OthersService othersService;

    @Autowired
    private UserService userService;

    @RequestMapping("/labAll")
    public String getAllLaboratory(Model model){
        List<Laboratory> labList = laboratoryService.getAllLaboratory();
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        model.addAttribute("labList",laboratoryJList);
        return "/admin/lab";
    }
    @RequestMapping("/labAllUser")
    public String getAllLaboratoryUser(Model model){
        List<Laboratory> labList = laboratoryService.getAllLaboratory();
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        model.addAttribute("labList",laboratoryJList);
        return "/userWelcome";
    }

//    @RequestMapping("/all")
//    @ResponseBody
//    public String list(){
//        //查询列表数据
//        System.out.println("=======================");
//        System.out.println("+++++++++++++++++++++++");
//        List<Laboratory> lab_list=laboratoryService.getAllLaboratory();
//        System.out.println(JSON.toJSONString(lab_list));
//        return JSON.toJSONString(lab_list);
//    }

    //跳转到添加实验室信息的页面
    @RequestMapping("/add")
    public String add(){
        return "/admin/addLab";
    }

    //添加实验室信息
    @RequestMapping("/addLab")
    public String addlab(Laboratory laboratory){
        laboratoryService.addLabortory(laboratory);
        System.err.println("laboratory.getName()==>"+laboratory.getName());
        return "redirect:/laboratory/labAll";
    }

    //返回查询的实验室信息
    @RequestMapping("/getLabByName")
    public String getLabByName(@RequestParam("name") String name,Model model){
        List<Laboratory> labList = laboratoryService.getLaboratory(0,null,name);
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        if (labList!=null){
            laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        }else{
            return "redirect:/laboratory/labAll";
        }
        model.addAttribute("labList",laboratoryJList);
        return "/admin/lab";
    }

    @RequestMapping("/getLabtoryById")
    @ResponseBody
    public String getLabById(int id){
        String msg = "";
        List<Laboratory> laboratoryList = laboratoryService.getLaboratory(id,null,null);
        if (laboratoryList.size()<1){
            msg = "yes";
        }else{
            msg = "no";
        }
        return msg;
    }


    @RequestMapping("/deleteLab")
    public String deleteLab(Integer id){
        laboratoryService.deleteLabortory(id);
        return "redirect:/laboratory/labAll";
    }


    //跳转到更新数据页面
    @RequestMapping("/updateLab")
    public String updateLab(int id,Model model){
        List<Laboratory> laboratoryList = laboratoryService.getLaboratory(id,null,null);
        Laboratory laboratory = laboratoryList.get(0);
        model.addAttribute("labortory",laboratory);
        return "/admin/updateLab";
    }

    //updateLab
    @RequestMapping("/updateLabor")
    public String updateLabor(Laboratory laboratory){
        laboratoryService.updateLabtory(laboratory);
        System.out.println("laboratory====>"+laboratory);
        return "redirect:/laboratory/labAll";
    }

    //
//    @RequestMapping("/updateLabDate")
//    public String updateLabDate(Laboratory laboratory){
//        LabDate labDate = new LabDate(laboratory.getId(),
//                laboratory.getToday_m(),
//                laboratory.getToday_a(),
//                laboratory.getToday_n(),
//                laboratory.getTom_m(),
//                laboratory.getTom_a(),
//                laboratory.getTom_n());
//        laboratoryService.updateLabtoryById(labDate);
//        return "redirect:/laboratory/labAll";
//    }
}
