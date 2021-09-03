package org.yyds.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//先导入Controller接口（springMVC包下的）
public class UserController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndView模型和视图
        ModelAndView mav=new ModelAndView();

        //封装对象，放在ModelAndView中 Model
        mav.addObject("msge","Hello,This is SpringMVC!");

        //封装要跳转的视图，放在ModelAndView中
        mav.setViewName("hello");//WEB-INF/jsp/hello.jsp
        return mav;
    }
}
