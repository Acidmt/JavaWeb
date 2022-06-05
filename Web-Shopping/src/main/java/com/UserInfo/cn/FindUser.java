package com.UserInfo.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/SelectUser")
public class FindUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao dao=new Dao();
        List<UserBean> list=new ArrayList<UserBean>();
        if (req.getParameter("userName")==null){
            list=dao.findAll();
            req.getSession().setAttribute("findUser",list);
        }else {
            list= Collections.singletonList(dao.findName(req.getParameter("userName")));
            req.getSession().setAttribute("findUser",list);
        }
        resp.sendRedirect("/Web-Shopping/ShowUser.jsp");
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
