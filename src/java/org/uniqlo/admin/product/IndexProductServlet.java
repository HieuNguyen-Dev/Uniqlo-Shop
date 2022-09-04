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
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.model.Product;

public class IndexProductServlet extends AdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.all();
        request.setAttribute("productList", productList);
        
        request.getRequestDispatcher("admin/products/index.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
