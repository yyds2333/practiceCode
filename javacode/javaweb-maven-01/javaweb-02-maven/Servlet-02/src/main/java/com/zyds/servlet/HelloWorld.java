package com.zyds.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

public class HelloWorld extends HttpServlet {
    //由于doGet和doPost业务逻辑相同，可以相互调用
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServerException{
        PrintWriter writer=response.getWriter();//响应流
        System.out.println("进入doGet方法");
        writer.print("hello,world!");
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServerException{
        doGet(request,response);
    }
}
