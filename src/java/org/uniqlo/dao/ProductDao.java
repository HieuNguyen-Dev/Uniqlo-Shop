/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uniqlo.dao;

import java.util.List;
import org.uniqlo.model.Product;

/**
 *
 * @author Hieu
 */
public interface ProductDao {
    public boolean insert(Product product);
    public boolean update(Product product);
    public boolean delete(int id);
    
    public List<Product> all();
    public List<Product> allByPages(int first, int last);
    public Product find(int id);
    public Product findByName(String name);
    public List<Product> findByCategoryId(int categoryId, int first, int last);
    public List<Product> searchByName(String productName);
    public int countProduct();
    public int countProductByCategory(int categoryId);
    public List<Integer> bestProduct();
    public List<Product> newProduct();
}
