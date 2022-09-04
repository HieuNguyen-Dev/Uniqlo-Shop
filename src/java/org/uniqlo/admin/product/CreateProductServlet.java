/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin.product;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.uniqlo.admin.AdminServlet;
import org.uniqlo.dao.CategoryDao;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.model.Category;
import org.uniqlo.model.Product;

public class CreateProductServlet extends AdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.all();
        
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("admin/products/create.jsp").include(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String desc = request.getParameter("desc");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        
        Product product = new Product(name, img, desc, price, quantity, categoryId);
        
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        productDao.insert(product);
        
        response.sendRedirect("IndexProductServlet");
    }

}
