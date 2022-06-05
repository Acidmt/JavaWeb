package com.demo2.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ConterServlet")
public class ConterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String email=req.getParameter("email");

        UserBean userBean=new UserBean();
        userBean.setName(name);
        userBean.setPassword(password);
        userBean.setEmail(email);

        boolean flag=DBUtil.getInstance().insertUSer(userBean);
        if (!flag){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("userBean",userBean);
            HttpSession session= req.getSession();
            Enumeration  sessionName=session.getAttributeNames();
            while (sessionName.hasMoreElements()){
                String eName=sessionName.nextElement().toString();
                Object value=session.getAttribute(eName);
                System.out.println(value);
            }
            req.getRequestDispatcher("/out.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
