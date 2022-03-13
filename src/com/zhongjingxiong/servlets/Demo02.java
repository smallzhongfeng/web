package com.zhongjingxiong.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Demo02 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo06");
        // server 内部转发
        // demo3是组件名字
//        req.getRequestDispatcher("demo3").forward(req,resp);
        resp.sendRedirect("demo3");
    }
//
//    public static void main(String[] args) throws IOException {
//        FileInputStream aa = new FileInputStream(new File("/Users/didi/IdeaProjects/java-web/web/WEB-INF/web.xml"));
//        FileOutputStream fileOutputStream = new FileOutputStream("/Users/didi/IdeaProjects/java-web/web/WEB-INF/web");
//        byte[] buf = new byte[8192];
//        int len;
//        while ((len = aa.read(buf)) != -1){
//            fileOutputStream.write(buf, 0, len);
//        }
//    }
}
