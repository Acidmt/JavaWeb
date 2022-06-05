package com.UserInfo.cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码、响应方式和编码方式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ptst = null;
        String loginName;
        String loginPassword;
        String add;
        add = request.getParameter("add");
        UserBean userBean = (UserBean) request.getSession().getAttribute("userAdd");
        //注册界面获取
        if (add!=null&&userBean!=null){
            loginName=userBean.getUsername();
            loginPassword=userBean.getPassword();

        }else {
            //获取登录页面提交的数据
            loginName = request.getParameter("name");
            loginPassword = request.getParameter("password");
            userBean=null;
        }
        //sql 语句
        String selectUsername = "select username from Showuser";
        String selectPassword = "select password from Showuser where username =?";
        try {
            //获取与数据库的连接
            conn = new GetConnection().getConnection();
            //遍历Showuser表，将数据库中所有username存入集合中
            st = conn.createStatement();
            rs = st.executeQuery(selectUsername);
            List<String> usernameList = new ArrayList<String>();
            while (true) {
                try {
                    if (!rs.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                usernameList.add(rs.getString(1));
            }
            //关闭连接
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            //判断集合中是否存在所要登录的username
            if (usernameList.contains(loginName)) {
                //查找username对应的password
                List<String> passwordList = new ArrayList<String>();
                ptst = (PreparedStatement) conn.prepareStatement(selectPassword);
                //设置ptst参数
                ptst.setString(1, loginName);
                rs = ptst.executeQuery();
                while (rs.next()) {
                    passwordList.add(rs.getString(1));
                }
                //判断数据库与登录页面提交的password是否一致
                if (passwordList.get(0).equals(loginPassword)) {
                    out.println("欢迎登录。3秒后跳转至首页");
                    UserBean userBean1=new UserBean();
                    userBean1.setUsername(loginName);
                    userBean1.setPassword(loginPassword);
                    HttpSession session=request.getSession();
                    session.setAttribute("userName",userBean1.getUsername());
                    session.setAttribute("userPassword",userBean1.getPassword());
                    session.setMaxInactiveInterval(60*60*24*10);
                    response.setHeader("refresh","3;url=index.jsp");
                    Cookie cookie=new Cookie("JSESSIONID",session.getId());
                    cookie.setMaxAge(60*60*24*10);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    out.println("密码错误，请重新输入。3秒后跳转");
                    response.setHeader("refresh","3;url=Login.jsp");
                }
                if (rs != null) {
                    rs.close();
                }
                if (ptst != null) {
                    ptst.close();
                }
            } else {
                out.println("用户名不存在");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        out.flush();
        out.close();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
