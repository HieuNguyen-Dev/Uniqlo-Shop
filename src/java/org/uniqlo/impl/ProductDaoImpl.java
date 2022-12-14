package org.uniqlo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.db.MySQLDriver;
import org.uniqlo.model.Product;

/**
 *
 * @author Admin
 */
public class ProductDaoImpl implements ProductDao {

    private Connection conn;

    public ProductDaoImpl() {
        conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Product product) {
        String sql = "INSERT INTO PRODUCTS VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getImg());
            stmt.setString(3, product.getDesc());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Product product) {
        String sql = "UPDATE PRODUCTS SET NAME=?, IMG=?, description=?, PRICE=?, QUANTITY=?, CATEGORYID=? WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getImg());
            stmt.setString(3, product.getDesc());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());
            stmt.setInt(7, product.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int productId) {
        String sql = "DELETE FROM PRODUCTS WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Product> all() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM ProductS";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");

                productList.add(new Product(id, name, img, desc, price, quantity, categoryId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public List<Product> allByPages(int first, int last) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM ProductS Limit ?,?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, first);
            stmt.setInt(2, last);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");

                productList.add(new Product(id, name, img, desc, price, quantity, categoryId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public Product find(int id) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String img = rs.getString("img");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");

                return new Product(id, name, img, desc, price, quantity, categoryId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        String sql = "SELECT * FROM PRODUCTS WHERE NAME=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String img = rs.getString("img");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");

                return new Product(id, name, img, desc, price, quantity, categoryId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, int first, int last) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM PRODUCTS WHERE categoryId=? Limit ?,?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setInt(2, first);
            stmt.setInt(3, last);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");

                productList.add(new Product(id, name, img, desc, price, quantity, categoryId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public int countProduct() {
        String sql = "SELECT COUNT(*) AS count FROM products";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countProduct = rs.getInt("count");
                return countProduct;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<Product> searchByName(String productName) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM PRODUCTS WHERE NAME like ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + productName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");

                productList.add(new Product(id, name, img, desc, price, quantity, categoryId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public List<Integer> bestProduct() {
        List<Integer> productIdList = new ArrayList<Integer>();
        String sql = "SELECT productId, SUM(quantity) as quantity FROM orders_details GROUP BY productId ORDER BY `quantity` DESC LIMIT 4;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                productIdList.add(rs.getInt("productId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productIdList;
    }

    @Override
    public List<Product> newProduct() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM `products` WHERE id ORDER BY id DESC LIMIT 4;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");

                productList.add(new Product(id, name, img, desc, price, quantity, categoryId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public int countProductByCategory(int categoryId) {
        String sql = "SELECT COUNT(*) AS count FROM products where categoryid=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countProduct = rs.getInt("count");
                return countProduct;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
