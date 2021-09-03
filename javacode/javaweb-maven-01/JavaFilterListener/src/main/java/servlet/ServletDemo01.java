package servlet;

import pojo.Pojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
        session.setAttribute(Pojo.USER_NAME,username);
        session.setAttribute(Pojo.PASSWORD,password);
        String s=(String) req.getSession().getAttribute(Pojo.USER_NAME);
        String s2=(String) req.getSession().getAttribute(Pojo.PASSWORD);
        System.out.println(s+":one:"+s2);
        resp.sendRedirect("/client/loginSuccess.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
