package com.yyds.controller;


import com.yyds.utils.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class MyController {

    @RequestMapping("/json")
    //不走视图解析器
    @ResponseBody
    public String getJson(){
        Date date = new Date();
        return JSONUtils.getJson(date);
    }
}
