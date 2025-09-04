package com.jdbc.entity;

public class Product {
    private int pid;
    private String pname;
    private int price;

    public Product(int pid, String pname, int price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }

    // Getters
    public int getPid() { return pid; }
    public String getPname() { return pname; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
    }
}
