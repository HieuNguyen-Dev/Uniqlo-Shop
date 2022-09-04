/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.uniqlo.dao.CategoryDao;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.model.Category;
import org.uniqlo.model.Product;
import org.uniqlo.util.Flash;

/**
 *
 * @author Hieu
 */
public class ProductDetailServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);
        
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(product.getCategoryId());
        
        request.setAttribute("cartNumber", Flash.cartNumber);
        request.setAttribute("product", product);
        request.setAttribute("category", category);
        request.getRequestDispatcher("productDetail.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
