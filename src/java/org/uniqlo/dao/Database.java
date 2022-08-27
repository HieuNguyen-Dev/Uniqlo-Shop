/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uniqlo.dao;

import org.uniqlo.impl.CategoryDaoImpl;
import org.uniqlo.impl.OrderDaoImpl;
import org.uniqlo.impl.OrderDetailDaoImpl;
import org.uniqlo.impl.ProductDaoImpl;
import org.uniqlo.impl.UserDaoImpl;

/**
 *
 * @author Hieu
 */
public class Database extends DatabaseDao {
    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImpl();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    @Override
    public OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }

    @Override
    public OrderDetailDao getOrderDetailDao() {
        return new OrderDetailDaoImpl();
    }
    

}
