package com.zyds.Servlet_03;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        // Hello
        ServletContext context=this.getServletContext();
        String name=(String)context.getAttribute("name");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "我是" + name + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}