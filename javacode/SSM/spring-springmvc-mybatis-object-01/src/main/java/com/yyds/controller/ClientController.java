package com.yyds.controller;

import com.yyds.pojo.Laboratory;
import com.yyds.pojo.Notice;
import com.yyds.pojo.User;
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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private LaboratoryService laboratoryService;

    @Autowired
    private OthersService othersService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getLabByName")
    public String getLabByName(@RequestParam("name") String name, Model model){
        List<Laboratory> labList = laboratoryService.getLaboratory(0,null,name);
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        if (labList!=null){
            laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        }else{
            return "redirect:/client/labAll";
        }
        model.addAttribute("labList",laboratoryJList);
        return "/userWelcome";
    }



    public List<String> notice(){
        List<Notice> noticeList = othersService.getAllNotice();
        List<String> att = new ArrayList<>();
        System.err.println(noticeList);
        for (int i=0;i<noticeList.size();i++){
            att.add(noticeList.get(i).getNotice());

        }
        return att;
    }

    @RequestMapping("/labAllUser")
    public String getAllLaboratoryUser(Model model){
        List<Laboratory> labList = laboratoryService.getAllLaboratory();
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        model.addAttribute("labList",laboratoryJList);
        model.addAttribute("notice",notice());
        System.err.println(notice());
        return "/userWelcome";
    }

    @RequestMapping("/labAllUserLogin")
    public String getAllLaboratoryUserL(Model model){
        List<Laboratory> labList = laboratoryService.getAllLaboratory();
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        model.addAttribute("labList",laboratoryJList);
        model.addAttribute("notice",notice());
        System.err.println(notice());
        return "/userWelcome2";
    }

    @RequestMapping("/todaym")
    public String todaym(String interval,int id, HttpSession session,Model model){
        User user= (User) session.getAttribute("user");
        int iid = user.getId();
        System.err.println(iid+"================================>");
        int lid = 0;
        boolean flag = false;
        flag = updateLabDate(iid,lid,id,interval);
        if (flag){
            return "redirect:/client/labAllUser";
        }
        return "redirect:/client/labAllTo";
    }

    @RequestMapping("/labAllTo")
    public String getAllLaboratoryTo(Model model){
        List<Laboratory> labList = laboratoryService.getAllLaboratory();
        List<LaboratoryJ> laboratoryJList = new ArrayList<>();
        laboratoryJList = LabToLabJUntils.switchLab(labList,laboratoryJList, othersService, userService);
        model.addAttribute("labList",laboratoryJList);
        model.addAttribute("notice",notice());
        model.addAttribute("success","预约成功");
        return "/userWelcome";
    }

    @RequestMapping("/clientUp")
    public String clientUp(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "client/clientControl";
    }

    @RequestMapping("/getUpPassword")
    public String getPasswordPage(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        String password = user.getPassword();
        model.addAttribute("pass",password);
        return "/client/updatePasswrod";
    }

    @RequestMapping("/getPass")
    @ResponseBody
    public String getPass(String oldPass,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user.getPassword().equals(oldPass)){
            return "Y";
        }
        return "X";
    }

    @RequestMapping("/getUpPasswordPage")
    public String updatePassword(String oldPass,String newPass,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user.getPassword().equals(oldPass)){
            user.setPassword(newPass);
        }
        userService.updateUser(user);
        return "redirect:/client/labAllTo";
    }


    //工具类，进行LabDate的更改
    public boolean updateLabDate(int iid,int lid,int id,String interval){
        //根据id获取要更改的预约
        //lid ：这是当前实验室当前时段的id
        if (interval.equals("tdm")){
            lid = laboratoryService.getLaboratory(id,null,null).get(0).getToday_m();
            //如果获取到的lid不为0且与教师id不同
            if (lid>0&&lid!=iid){
                System.err.println("NO=====================>"+iid+"==="+lid);
                return false;
            }else if (iid==lid){
                LabDate labDate = new LabDate(0,1,1,1,1,1,1);
                labDate.setId(id);
                labDate.setToday_m(0);
                System.err.println("YES=====================>"+iid+"=0=1="+lid+"=====>>>"+id);
                laboratoryService.updateLabtoryByIdClear(labDate);
            }else if (lid==0){
                LabDate labDate = new LabDate(0,0,0,0,0,0,0);
                labDate.setId(id);
                labDate.setToday_m(iid);
                System.err.println("YES=====================>"+iid+"=0=2="+lid+"=====>>>"+id);
                laboratoryService.updateLabtoryById(labDate);
            }
            return true;
        }else if (interval.equals("tdn")){
            lid = laboratoryService.getLaboratory(id,null,null).get(0).getToday_n();
            //如果获取到的lid不为0且与教师id不同
            if (lid!=iid&&lid>0){
                System.err.println("NO=====================>"+iid+"==="+lid);
                return false;
            }else if (iid==lid){
                LabDate labDate = new LabDate(0,1,1,1,1,1,1);
                labDate.setId(id);
                labDate.setToday_n(0);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryByIdClear(labDate);
            }else if (lid==0){
                LabDate labDate = new LabDate(0,0,0,0,0,0,0);
                labDate.setId(id);
                labDate.setToday_n(iid);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryById(labDate);
            }
            return true;
        }else if (interval.equals("tda")){
            lid = laboratoryService.getLaboratory(id,null,null).get(0).getToday_a();
            //如果获取到的lid不为0且与教师id不同
            if (lid!=iid&&lid>0){
                System.err.println("NO=====================>"+iid+"==="+lid);
                return false;
            }else if (iid==lid){
                LabDate labDate = new LabDate(0,1,1,1,1,1,1);
                labDate.setId(id);
                labDate.setToday_a(0);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryByIdClear(labDate);
            }else if (lid==0){
                LabDate labDate = new LabDate(0,0,0,0,0,0,0);
                labDate.setId(id);
                labDate.setToday_a(iid);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryById(labDate);
            }
            return true;
        }else if (interval.equals("tmm")){
            lid = laboratoryService.getLaboratory(id,null,null).get(0).getTom_m();
            //如果获取到的lid不为0且与教师id不同
            if (lid!=iid&&lid>0){
                System.err.println("NO=====================>"+iid+"==="+lid);
                return false;
            }else if (iid==lid){
                LabDate labDate = new LabDate(0,1,1,1,1,1,1);
                labDate.setId(id);
                labDate.setTom_m(0);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryByIdClear(labDate);
            }else if (lid==0){
                LabDate labDate = new LabDate(0,0,0,0,0,0,0);
                labDate.setId(id);
                labDate.setTom_m(iid);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryById(labDate);
            }
            return true;
        }else if (interval.equals("tma")){
            lid = laboratoryService.getLaboratory(id,null,null).get(0).getTom_a();
            //如果获取到的lid不为0且与教师id不同
            if (lid!=iid&&lid>0){
                System.err.println("NO=====================>"+iid+"==="+lid);
                return false;
            }else if (iid==lid){
                LabDate labDate = new LabDate(0,1,1,1,1,1,1);
                labDate.setId(id);
                labDate.setTom_a(0);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryByIdClear(labDate);
            }else if (lid==0){
                LabDate labDate = new LabDate(0,0,0,0,0,0,0);
                labDate.setId(id);
                labDate.setTom_a(iid);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryById(labDate);
            }
            return true;
        }else if (interval.equals("tmn")){
            lid = laboratoryService.getLaboratory(id,null,null).get(0).getTom_n();
            //如果获取到的lid不为0且与教师id不同
            if (lid!=iid&&lid>0){
                System.err.println("NO=====================>"+iid+"==="+lid);
                return false;
            }else if (iid==lid){
                LabDate labDate = new LabDate(0,1,1,1,1,1,1);
                labDate.setId(id);
                labDate.setTom_n(0);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryByIdClear(labDate);
            }else if (lid==0){
                LabDate labDate = new LabDate(0,0,0,0,0,0,0);
                labDate.setId(id);
                labDate.setTom_n(iid);
                System.err.println("YES=====================>"+iid+"=0=0="+lid);
                laboratoryService.updateLabtoryById(labDate);
            }
            return true;
        }
        return false;
    }
}
