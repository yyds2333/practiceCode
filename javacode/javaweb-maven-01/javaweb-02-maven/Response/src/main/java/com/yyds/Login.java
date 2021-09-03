package com.yyds;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //设置编码
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String[] hobbys=req.getParameterValues("hobbys");
        System.out.println(username + ":" + password);
        System.out.println(Arrays.toString(hobbys));
        //转发请求
        req.getRequestDispatcher("/re").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
