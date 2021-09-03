package com.yyds.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器
public class MyClientInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        if (session.getAttribute("user")!=null){
            return true;
        }
        //转发回未登录的首页
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return false;
    }
}
