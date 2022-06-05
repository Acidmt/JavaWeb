package com.CartNumber;

public class AddCartBean {

    private int userid;
    private int cartid;
    private String cartname;
    private int cartprice;
    private int cartnumber;
    private int cartcout;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "AddCartBean{" +
                "userid=" + userid +
                ", cartid=" + cartid +
                ", cartname='" + cartname + '\'' +
                ", cartprice=" + cartprice +
                ", cartnumber=" + cartnumber +
                ", cartcout=" + cartcout +
                '}';
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public String getCartname() {
        return cartname;
    }

    public void setCartname(String cartname) {
        this.cartname = cartname;
    }

    public int getCartprice() {
        return cartprice;
    }

    public void setCartprice(int cartprice) {
        this.cartprice = cartprice;
    }

    public int getCartnumber() {
        return cartnumber;
    }

    public void setCartnumber(int cartnumber) {
        this.cartnumber = cartnumber;
    }

    public int getCartcout() {
        return cartcout;
    }

    public void setCartcout(int cartcout) {
        this.cartcout = cartcout;
    }


}
