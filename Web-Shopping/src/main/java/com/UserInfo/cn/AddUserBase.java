package com.UserInfo.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet("/AddUserBase")
public class AddUserBase extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ptst = null;
        String loginName = req.getParameter("name");
        String loginPassword = req.getParameter("password");
        String loginPassword2 = req.getParameter("password2");
        String loginEmail=req.getParameter("email");
        if (loginName!=""&&loginPassword!=""&&loginPassword.equals(loginPassword2)&&loginEmail!=""){
            UserBean userBean=new UserBean();
            userBean.setUsername(loginName);
            userBean.setPassword(loginPassword);
            userBean.setEmail(loginEmail);
            Dao addDao=new Dao();
            boolean b = addDao.insert(userBean);
            if (b){
                req.getSession().setAttribute("userAdd",userBean);
                resp.sendRedirect("/Web-Shopping/LoginServlet?add=1");
            }else {
                req.getSession().setAttribute("Reerror","注册失败请重新填写");
                resp.sendRedirect("/Web-Shopping/register.jsp");
            }
        }else {
            req.getSession().setAttribute("Reerror","账号密码不一致，请重新输入");
            resp.sendRedirect("/Web-Shopping/register.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
