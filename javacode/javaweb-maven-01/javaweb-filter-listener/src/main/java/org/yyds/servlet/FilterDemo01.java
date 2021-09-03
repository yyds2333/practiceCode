package org.yyds.servlet;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("过滤器被调用");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器使用完毕");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁");
    }
}
