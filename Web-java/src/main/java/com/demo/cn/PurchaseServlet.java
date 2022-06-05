package com.demo.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        if (id==null){
            String url="ListCakeServlet";
            resp.sendRedirect(url);
            return;
        }
        Cake cake=CakeDB.getCake(id);
        HttpSession session=req.getSession();
        ArrayList<Cake> cart=(ArrayList<Cake>)session.getAttribute("cart");
        if (cart==null){
            cart=new ArrayList<Cake>();
            session.setAttribute("cart",cart);
        }
        cart.add(cake);
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        System.out.println(cookie.getValue());
        cookie.setMaxAge(60*30);
        cookie.setPath("//Web-java");
        String url="CartServlet";
        resp.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
