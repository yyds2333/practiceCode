package servlet;

import pojo.Pojo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        System.out.println("two");
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute(Pojo.USER_NAME);
        String password=(String)session.getAttribute(Pojo.PASSWORD);
        System.out.println(username+":"+password);
            if (username.equals("admin") && password.equals("123456")) {
                request.getRequestDispatcher("/client/loginSuccess.jsp").forward(request, response);
            } else if(username==null||password==null){
                response.sendRedirect("/login.jsp");
            }else if (username.equals("admin") | password.equals("123456")) {
                request.getRequestDispatcher("/client/Error.jsp").forward(request, response);
            } else {
            request.getRequestDispatcher("/client/Error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁");
    }
}
