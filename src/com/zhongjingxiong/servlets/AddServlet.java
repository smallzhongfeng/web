package com.zhongjingxiong.servlets;

import com.zhongjingxiong.fruit.dao.FruitDAO;
import com.zhongjingxiong.fruit.dao.impl.FruitDAOImpl;
import com.zhongjingxiong.fruit.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddServlet extends HttpServlet {
    // 由于html的method方式为post，所以post方法发送的请求会被该方法接收
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fname = req.getParameter("fname");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer fcount = Integer.parseInt(req.getParameter("fcount"));
        String remark = req.getParameter("remark");

        FruitDAO fruitDAO = new FruitDAOImpl();
        boolean flag = fruitDAO.addFruit(new Fruit(0, fname, price, fcount, remark));
        System.out.println(flag ?"add successfully!":"add fail!");
    }
}
