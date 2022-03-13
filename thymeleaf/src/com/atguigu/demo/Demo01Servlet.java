package com.atguigu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//演示request保存作用域（demo01和demo02）
@WebServlet("/demo01")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.向request保存作用域保存数据
        request.setAttribute("uname","lili");
        //2.客户端重定向
        // 只保存在一次请求，但是重定向至少两次请求
        //response.sendRedirect("demo02");

        //3.服务器端转发 ,这个才可以保存request的属性，因为是服务器内部做的跳转
        request.getRequestDispatcher("demo02").forward(request,response);
    }
}
