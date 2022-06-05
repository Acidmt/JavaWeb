package com.demo.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        ArrayList<Cake> cart=null;
        boolean flages=true;
        HttpSession session=req.getSession(false);
        if (session==null){
            flages=false;
        }else {
            cart=(ArrayList<Cake>) session.getAttribute("cart");
            if (cart==null){
                flages=false;
            }
        }
        if (!flages){
            out.write("对不起");
        }else {
            out.write("您的东西：<br>");
            double pice=0;
            for (Cake cake:cart) {
                out.write(cake.getName()+"<br>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
