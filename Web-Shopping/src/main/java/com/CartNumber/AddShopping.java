package com.CartNumber;

import com.CartShopping.cn.CartBean;
import com.CartShopping.cn.CartDao;
import com.UserInfo.cn.Dao;
import com.UserInfo.cn.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddShoppong")
public class AddShopping extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传递过来的cartid，封装成整型，然后获取数据库中指定商品信息
        String cartidString=req.getParameter("cartid");
        String username= (String) req.getSession().getAttribute("userName");
        Integer cartid=new Integer(cartidString);
        CartDao cartDao=new CartDao();
        CartBean cartBean=cartDao.findId(cartid);
        Dao dao=new Dao();
        UserBean userBean=new UserBean();
        userBean=dao.findName(username);
        //1. 对购物车里的cartBean进行修改，改为CartNumberBean类型(注意添加数量和价格)
        int userid=userBean.getId();
        int cartids=cartBean.getId();
        String cartname=cartBean.getTradenme();
        int cartprice=cartBean.getPrice();
        int cartnumber=1;
        int cartcout=cartprice;
        AddCartBean addCartBean=new AddCartBean();
        addCartBean.setUserid(userid);
        addCartBean.setCartid(cartids);
        addCartBean.setCartname(cartname);
        addCartBean.setCartprice(cartprice);
        addCartBean.setCartnumber(cartnumber);
        addCartBean.setCartcout(cartprice);
        //2. 调用CartNumberDao中的isUserCart判断添加的商品是否重复
        CartNumberDao cartNumberDao=new CartNumberDao();
        AddCartBean  cartCout=cartNumberDao.cartCout(userid,cartname);
        Boolean b=cartNumberDao.isUserCart(userid,cartname);
        Boolean flag=cartNumberDao.insert(addCartBean,b,cartCout);
        if (flag){
            //4. 通知CartDao数量减少
            cartDao.updateCart(cartid,cartBean.getNumber());
            resp.sendRedirect("/Web-Shopping/OpearBase");
        }else {
           resp.getWriter().write("添加失败请重试");
            resp.setHeader("refresh","3;url=index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
