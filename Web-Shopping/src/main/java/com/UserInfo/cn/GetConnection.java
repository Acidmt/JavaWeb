package com.UserInfo.cn;

import java.sql.*;

public class GetConnection {
    Connection conn = null;
    public Connection getConnection() throws ClassNotFoundException{
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
        String user="root";
        String password="123456";
        Class.forName(driver);
        try {
            conn= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    // 关闭数据库连接，释放资源
    public void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }

    }

    public void release (ResultSet rs, Statement stmt, Connection conn){
        if(rs!= null){
            try{
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt, conn);
    }
}
