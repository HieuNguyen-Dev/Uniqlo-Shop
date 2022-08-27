/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uniqlo.model;

import java.time.format.DateTimeFormatter;
import org.uniqlo.dao.DatabaseDao;

/**
 *
 * @author Admin
 */
public class Order {
    private int id;
    private String code;
    private String status;
    private int userId;
    public String currentDateTime;
    
    
    
    public static Order find(int id){
        return DatabaseDao.getInstance().getOrderDao().find(id);
    }

    public Order(String code, String status, int userId, String currentDateTime) {
        this.code = code;
        this.status = status;
        this.userId = userId;
        this.currentDateTime = currentDateTime;
    }

    public Order(int id, String code, String status, int userId, String currentDateTime) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.userId = userId;
        this.currentDateTime = currentDateTime;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
