package com.UserInfo.cn;

public class UserBean {

    private String username;
    private String password;
    private String email;
    private String cart;
    private int id;
    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", cart='" + cart + '\'' +
                ", id=" + id +
                '}';
    }
}
