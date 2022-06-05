package com.CartShopping.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/OpearBase")
public class OpearBase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartDao cartDao=new CartDao();
        List<CartBean> list=cartDao.findAllCart();
        req.getSession().setAttribute("list",list);
//        Iterator<CartBean> it = list.iterator();
//        while (it.hasNext()){
//            CartBean s=it.next();
//        }
        if (req.getParameter("deleteCartServlet")!=null){
            resp.sendRedirect("/Web-Shopping/CartShopping");
        }else {
            resp.sendRedirect("/Web-Shopping/index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
