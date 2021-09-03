package org.nynd.filter;

import org.nynd.pojo.User;
import org.nynd.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        //获取Session信息
        User user= (User) req.getSession().getAttribute(Constants.USER_SESSION);
        if (user==null){
            //用户不存在
            resp.sendRedirect("/error.jsp");
        }
        //继续转发
        filterChain.doFilter(req,resp);
        //web.xml中注册
    }

    @Override
    public void destroy() {

    }
}
