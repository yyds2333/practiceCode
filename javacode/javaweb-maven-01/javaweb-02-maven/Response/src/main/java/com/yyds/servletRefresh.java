package com.yyds;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class servletRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //浏览器自动刷新
        resp.setHeader("refresh","10");
        //内存中创建图片
        BufferedImage image=new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D g=(Graphics2D) image.getGraphics();//pen
        //设置图片颜色
        g.setColor(Color.yellow);
        g.fillRect(0,0,80,20);
        //给图片写数据
        g.setColor(Color.black);
        g.setFont(new Font(null,2,20));
        g.drawString(makeNum(),0,20);
        //告诉浏览器这是张图片
        resp.setContentType("image/png");
        //把图片写给浏览器
        ImageIO.write(image,"png",resp.getOutputStream());
    }

    private String makeNum(){
            Random rand=new Random();
            String ran=rand.nextInt(999999)+"";
            StringBuffer sb=new StringBuffer(ran);
            for (int i=0;i<7-ran.length();i++){
                sb.append("0");
            }
            return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
