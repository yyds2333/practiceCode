package org.nynd.servlet.userServlet;

//import org.junit.Test;
import org.nynd.pojo.User;
import org.nynd.service.userService.UserService;
import org.nynd.service.userService.userServiceImpl.UserServiceImpl;
import org.nynd.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //处理请求，并将处理过的信息向上提交
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得表单提交的人物userCode和userPassword
        String userCode=req.getParameter("userCode");
        String userPassword=req.getParameter("userPassword");
        //通过取得的信息提交到业务层进行对比
        UserService ul=new UserServiceImpl();
        //用一个User对象来接收查询到的信息
        User user=ul.loginCheck(userCode,userPassword);
        //判断是否存在该用户
        if (user!=null){
            if (user.getUserRole()==1) {
                //将用户信息存到Session中去
                req.getSession().setAttribute(Constants.USER_SESSION, user);
                //将页面转发到登录成功的页面
                resp.sendRedirect("/jsp/frame.jsp");
            }else{
                //该用户不存在或者用户名，密码错误
                //转发到指定页面去
                req.setAttribute("error","权限不足！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else{
            //该用户不存在或者用户名，密码错误
            //转发到指定页面去
            req.setAttribute("error","用户名或密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        //在web.xml中注册servlet
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

//    @Test
//    public void test(){
//        UserLogin ul=new UserLoginImpl();
//        User user=ul.loginCheck("wen","123");
//        System.out.println(user);
//    }
}
