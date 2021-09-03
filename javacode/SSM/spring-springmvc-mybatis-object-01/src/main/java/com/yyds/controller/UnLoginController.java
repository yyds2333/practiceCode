package com.yyds.controller;


import com.yyds.pojo.Laboratory;
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

import java.util.ArrayList;
import java.util.List;

@Controller
//本类用于未登录用户对实验室信息的查询
@RequestMapping("/unLoginPage")
public class UnLoginController {

    //自动装填labservice类
    @Autowired
    private LaboratoryService laboratoryService;

    @Autowired
    private OthersService othersService;

    @Autowired
    private UserService userService;

    @RequestMapping("/laboratoryList")
    public String laboratoryList(Model model){
        List<Laboratory> labList = laboratoryService.getAllLaboratory();
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        model.addAttribute("labList",laboratoryJList);
        return "laboratoryList";
    }

    @RequestMapping("/getLabByName")
    public String getLabByName(@RequestParam("name") String name, Model model){
        List<Laboratory> labList = laboratoryService.getLaboratory(0,null,name);
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        if (labList!=null){
            laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
            model.addAttribute("labList",laboratoryJList);
        }else{
            return "redirect:/unLoginPage/laboratoryList";
        }
        return "/laboratoryList";
    }

}
