/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uniqlo.model;

import org.uniqlo.dao.DatabaseDao;

/**
 *
 * @author Admin
 */
public class Product {
    private int id;
    private String name;
    private String img;
    private String desc;
    private double price;
    private int quantity;
    private int categoryId;
    
    public static Product find(int id){
        return DatabaseDao.getInstance().getProductDao().find(id);
    }

    public Product(String name, String img, String desc, double price, int quantity, int categoryId) {
        this.name = name;
        this.img = img;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product(int id, String name, String img, String desc, double price, int quantity, int categoryId) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}
