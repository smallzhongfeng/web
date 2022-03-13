package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int fid = Integer.parseInt(request.getParameter("fid"));
        String fnameStr = request.getParameter("fname");
        int price = Integer.parseInt(request.getParameter("price"));
        int fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");

        fruitDAO.updateFruit(new Fruit(fid, fnameStr, price, fcount,remark));

        // return to index
//        super.processTemplate("index", request, response);
        // 等同于在服务器内部进行转发到index.html,但是由于session没有更新，所以展示的还是老数据
        // 我们这边需要进行重定向，重新给index.html发请求，重新获取fruitList，获取到最新的数据
        response.sendRedirect("index.html");
    }
}
