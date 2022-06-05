package com.CartShopping.cn;

import com.UserInfo.cn.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private List<CartBean> beanList=new ArrayList<CartBean>();

    //查询购物车信息
    public List<CartBean> findAllCart(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM CommodityBase";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                CartBean cartBean=new CartBean();
                cartBean.setId(rs.getInt("id"));
                cartBean.setTradenme(rs.getString("tradename"));
                cartBean.setPrice(rs.getInt("price"));
                cartBean.setNumber(rs.getInt("number"));
                beanList.add(cartBean);
            }
            return beanList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return null;
    }

    //根据指定id查找商品
    public CartBean findId(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM CommodityBase WHERE id="+id;
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                CartBean cartBean=new CartBean();
                cartBean.setId(rs.getInt("id"));
                cartBean.setTradenme(rs.getString("tradename"));
                cartBean.setPrice(rs.getInt("price"));
                cartBean.setNumber(rs.getInt("number"));
                return cartBean;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return null;
    }

    //根据指定name查找商品
    public CartBean findName(String name){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM CommodityBase WHERE tradename='"+name+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                CartBean cartBean=new CartBean();
                cartBean.setId(rs.getInt("id"));
                cartBean.setTradenme(rs.getString("tradename"));
                cartBean.setPrice(rs.getInt("price"));
                cartBean.setNumber(rs.getInt("number"));
                return cartBean;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return null;
    }

    //减少购物车数量
    public boolean updateCart(int id,int number){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int numberCart=number-1;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="UPDATE CommodityBase set number="+ numberCart +" WHERE id="+id;
            int num=stmt.executeUpdate(sql);
            if (num>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            new GetConnection().release(rs,stmt,conn);
        }
        return false;
    }

    //增加购物车数量
    public boolean addCartShopping(String cartName,Integer number,int cartNumber){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int numberCart=number+cartNumber;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="UPDATE CommodityBase set number="+ numberCart +" WHERE tradename='"+cartName+"'";
            int num=stmt.executeUpdate(sql);
            if (num>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            new GetConnection().release(rs,stmt,conn);
        }
        return false;
    }

}
