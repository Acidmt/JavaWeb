package com.CartNumber;

import com.CartShopping.cn.CartDao;
import com.UserInfo.cn.Dao;
import com.UserInfo.cn.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/CartShopping")
public class CartShopping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartNumberDao cartNumberDao=new CartNumberDao();
        String userName= (String) req.getSession().getAttribute("userName");
        Dao dao=new Dao();
        UserBean userBean=dao.findName(userName);
        int userBeanId=userBean.getId();
        List<AddCartBean> list= cartNumberDao.findAllCart(userBeanId);
        //3. 获取购物车信息

        req.getSession().setAttribute("listCart",list);
        resp.sendRedirect("/Web-Shopping/CartShopping.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
