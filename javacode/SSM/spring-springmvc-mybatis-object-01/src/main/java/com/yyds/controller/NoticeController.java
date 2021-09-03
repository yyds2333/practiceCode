package com.yyds.controller;

import com.yyds.pojo.Notice;
import com.yyds.service.others.OthersService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private OthersService othersService;

    @RequestMapping("/getAllNotice")
    public String getAllNotice(Model model){
        List<Notice> noticeList = othersService.getAllNotice();
        model.addAttribute("notices",noticeList);
        return "admin/notice";
    }

    //删除公告
    @RequestMapping("/deleteNotice")
    public String deleteNotice(int id){
        othersService.deleteNoticeById(id);
        return "redirect:/notice/getAllNotice";
    }

    @RequestMapping("/updateNotice")
    public String updateNotice(int id,Model model){
        Notice notice = othersService.getNoticeById(id);
        model.addAttribute("notice",notice);
        return "/admin/updateNotice";
    }

    //根据id获取信息，
    @RequestMapping("/updateNoticePage")
    public String updateNoticePage(Notice notice){
        othersService.updateNotice(notice);
        System.err.println("notice===================>"+notice);
        return "redirect:/notice/getAllNotice";
    }

    @RequestMapping("/addNotice")
    public String addNotice(){
        return "/admin/addNotice";
    }

    @RequestMapping("/addNoticePage")
    public String addNoticePage(Notice notice){
        othersService.addNotice(notice);
        return "redirect:/notice/getAllNotice";
    }
}
