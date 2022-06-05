package com.CartNumber;

import com.CartShopping.cn.CartBean;
import com.CartShopping.cn.CartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartNumberDao cartNumberDao=new CartNumberDao();
        CartDao cartDao=new CartDao();
        cartNumberDao.delete(req.getParameter("cartName"));
        //通知主页购物车商品数量增加
        Integer cartCout=new Integer(req.getParameter("cartCout"));
        CartBean cartBean=cartDao.findName(req.getParameter("cartName"));
        cartDao.addCartShopping(req.getParameter("cartName"),cartCout,cartBean.getNumber());

//        HttpSession session   =   req.getSession();
//        Enumeration<?> enumeration = session.getAttributeNames();
//        while (enumeration.hasMoreElements()) {
//            // 获取session的属性名称
//            String name = enumeration.nextElement().toString();
//            // 根据键值取session中的值
//            Object value = session.getAttribute(name);
//            // 打印结果
//        }
        resp.sendRedirect("/Web-Shopping/OpearBase?deleteCartServlet=deleteCartServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
