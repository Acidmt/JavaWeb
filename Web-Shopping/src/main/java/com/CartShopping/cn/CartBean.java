package com.CartShopping.cn;

public class CartBean {

    private int id;
    private String tradenme;
    private int price;
    private int number;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTradenme() {
        return tradenme;
    }

    public void setTradenme(String tradenme) {
        this.tradenme = tradenme;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CartBean{" +
                "id=" + id +
                ", tradenme='" + tradenme + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }

}
