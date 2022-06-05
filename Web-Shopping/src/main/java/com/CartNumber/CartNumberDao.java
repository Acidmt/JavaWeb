package com.CartNumber;

import com.UserInfo.cn.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartNumberDao {
    private List<AddCartBean> beanList=new ArrayList<AddCartBean>();


    //查询购物车中的用户id和商品id判断商品是否存在
    public boolean isUserCart(int userid,String cartname){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM cartnumber WHERE userid="+userid+" AND cartname='"+cartname+"'";
            rs=stmt.executeQuery(sql);
            //判断结果集是否为空
            if (rs.next()){
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

    //获取购物车的cartnumber和cartcout
    public AddCartBean cartCout(int userid,String cartname){
        AddCartBean addCartBean=new AddCartBean();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM cartnumber WHERE userid="+userid+" AND cartname='"+cartname+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                addCartBean.setCartnumber(rs.getInt("cartnumber"));
                addCartBean.setCartcout(rs.getInt("cartcout"));
            }
            return addCartBean;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return null;
    }

    //添加与修改用户购物车信息操作
    public boolean insert(AddCartBean addCartBean,boolean b,AddCartBean cartCouts) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int numbercart=addCartBean.getCartnumber()+cartCouts.getCartnumber();
        int coutcart=addCartBean.getCartcout()+cartCouts.getCartcout();
        //b为true表示购物车里已经有商品信息，直接进行修改
        if (b){
            try {
                conn = new GetConnection().getConnection();
                stmt = conn.createStatement();
                String sql="UPDATE cartnumber SET cartnumber="
                        +numbercart+",cartcout="
                        +coutcart+" WHERE userid="
                        +addCartBean.getUserid()+" AND cartname='"+addCartBean.getCartname()+"'";
                int num=stmt.executeUpdate(sql);
                if (num>0){
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                new GetConnection().release(rs, stmt, conn);
            }
        }else {
            try {
                conn = new GetConnection().getConnection();
                stmt = conn.createStatement();
                String sql = "INSERT INTO cartnumber(userid,cartid,cartname,cartprice,cartnumber,cartcout)" +
                        "VALUES(" + addCartBean.getUserid() +
                        "," + addCartBean.getCartid() +
                        ",'" + addCartBean.getCartname() +
                        "'," + addCartBean.getCartprice() +
                        "," + addCartBean.getCartnumber() +
                        "," + addCartBean.getCartcout() + ")";
                int sqlresult = stmt.executeUpdate(sql);
                if (sqlresult > 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                new GetConnection().release(rs, stmt, conn);
            }
        }
        return false;
    }

    //根据商品名，删除购物车中的信息
    public boolean delete(String cartName){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try{
            // 获得数据的连接
            conn=new GetConnection().getConnection();
            // 获得 Statement 对象
            stmt = conn.createStatement();
            // 发送 SOL 语句
            String sql = "DELETE FROM cartnumber WHERE cartname='"+cartName+"'";
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

    //查找购物车信息
    public List<AddCartBean> findAllCart(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn=new GetConnection().getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM cartnumber WHERE userid="+id;
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                AddCartBean addCartBean=new AddCartBean();
                addCartBean.setUserid(rs.getInt("userid"));
                addCartBean.setCartid(rs.getInt("cartid"));
                addCartBean.setCartname(rs.getString("cartname"));
                addCartBean.setCartprice(rs.getInt("cartprice"));
                addCartBean.setCartnumber(rs.getInt("cartnumber"));
                addCartBean.setCartcout(rs.getInt("cartcout"));
                beanList.add(addCartBean);
            }
            return beanList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new GetConnection().release(rs,stmt,conn);
        }
        return null;
    }

}
