package com.UserInfo.cn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
    //添加用户的操作
    public boolean insert(UserBean user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="INSERT INTO Showuser(username,password,email)"+"VALUES('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
            int sqlresult = stmt.executeUpdate(sql);
            if (sqlresult > 0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return false;
    }

    //查询表对象
    public ArrayList<UserBean> findAll(){
        ArrayList<UserBean> list = new ArrayList<UserBean>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM Showuser";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                UserBean userBean=new UserBean();
                userBean.setUsername(rs.getString("username"));
                userBean.setPassword(rs.getString("password"));
                userBean.setEmail(rs.getString("email"));
                userBean.setCart(rs.getString("cart"));
                userBean.setId(rs.getInt("id"));
                list.add(userBean);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return null;
    }

    //获取指定用户信息
    public UserBean findName(String username){
        UserBean userBean=new UserBean();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM `showuser` WHERE username='"+username+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                userBean.setId(rs.getInt("id"));
                userBean.setUsername(rs.getString("username"));
                userBean.setPassword(rs.getString("password"));
                userBean.setEmail(rs.getString("email"));
                userBean.setCart(rs.getString("cart"));
            }
            return userBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return null;
    }


    //删除指定用户
    public boolean delete(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try{
            // 获得数据的连接
            conn=new GetConnection().getConnection();
            // 获得 Statement 对象
            stmt = conn.createStatement();
            // 发送 SOL 语句
            String sql = "DELETE FROM users WHERE id="+ id;
            int num = stmt.executeUpdate(sql);
            if (num >0){
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            new GetConnection().release(rs,stmt,conn);
        }
        return false;
    }

    //修改用户
    public boolean update (UserBean user){
        Connection conn = null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="UPDATE users set username='"+ user.getUsername() +"',password='"
                    +user.getPassword() +"',email='"+user.getEmail()
                    +"', cart='" + user.getCart()+"'WHERE id="+user.getId();
            int num=stmt.executeUpdate(sql);
            if (num>0){
                return true;
            }
            return false;

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            new GetConnection().release(rs,stmt,conn);
        }
        return false;
    }
}
