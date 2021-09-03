package org.yyds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//将该类注册到spring中作为组件
public class TestController {

    @RequestMapping("/hell/{a}/{b}")
    //加了@PathVariable标签后，{a}能直接在地址栏获取a的值
    public String getPage(@PathVariable int a,@PathVariable int b, Model model){
        int s=a+b;

        model.addAttribute("msg","方法一的值为"+s);

        return "hello";
    }

    @PostMapping("/hell/{a}/{b}")
    public String getPage2(@PathVariable int a,@PathVariable int b, Model model){
        int s=a+b;

        model.addAttribute("msg","方法二的值为"+s);

        return "hello";
    }
    @RequestMapping("/t1")
    public String gpTo(){
        return "hello";
    }
}
