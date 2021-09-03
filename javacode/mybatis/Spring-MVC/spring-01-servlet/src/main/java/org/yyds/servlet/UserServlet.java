package org.yyds.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //前端获取参数
        String method=req.getParameter("method");
        //调用业务逻辑
        if (method!=null){
            if (method.equals("add")){
                req.getSession().setAttribute("msg","使用了add方法");
            }else if (method.equals("delete")){
                req.getSession().setAttribute("msg","使用了delete方法");
            }
        }
        //转发或重定向
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
