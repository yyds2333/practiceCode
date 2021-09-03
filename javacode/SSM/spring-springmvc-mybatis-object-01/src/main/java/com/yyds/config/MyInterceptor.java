package com.yyds.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//负责登录功能拦截
public class MyInterceptor implements HandlerInterceptor {
    //return true放行
    //return false拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        String path = request.getServletPath();
        if (path.contains("/unLogin")||path.contains("/login")){
            return true;
        }else if (session.getAttribute("user")!=null||session.getAttribute("adminUser")!=null){
            return true;
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return false;
    }
}
