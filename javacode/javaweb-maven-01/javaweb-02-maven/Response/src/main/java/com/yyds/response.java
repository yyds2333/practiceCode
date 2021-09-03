package com.yyds;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class response extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取下载文件的路径
        String realPath="D:\\others\\tupian\\本机照片\\kwy.PNG";
        // 2. 下载的文件名
        String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
        // 3. 设置让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+ fileName);
        // 4. 获取下载文件输入流
        FileInputStream file=new FileInputStream(realPath);
        // 5. 创建缓冲区
        int len=0;
        byte[] bytes=new byte[1024];
        // 6. 获取OutputStream对象
        ServletOutputStream out=resp.getOutputStream();
        // 7. 将FileOutputStream流写入到buffer缓冲区
        // 8. 使用OutputStream将缓冲区中的数据输出到客户端
        while((len=file.read(bytes))>0){
            out.write(bytes,0,len);
        }
        //9.关闭输入输出流
        file.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
