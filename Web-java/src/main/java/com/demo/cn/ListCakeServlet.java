package com.demo.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
@WebServlet("/ListCakeServlet")
public class ListCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req. setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp. setCharacterEncoding("utf-8");
        PrintWriter out= resp.getWriter();
        Collection<Cake> cakes=CakeDB.getAll();
        out.print("本站提供的东西：<br>");
        for (Cake cake:cakes) {
            String url="PurchaseServlet?id="+cake.getId();
            out.write(cake.getName()+"<a href='"+url+"'>点击选择</a><br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
