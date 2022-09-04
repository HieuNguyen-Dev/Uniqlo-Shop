/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.model.Product;
import org.uniqlo.util.Flash;

/**
 *
 * @author Hieu
 */
public class SearchServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = null;      
        if(request.getParameter("productName") == null){
            productList = productDao.allByPages(4,4);            
        }
        else{
            String productName = request.getParameter("productName");
            productList = productDao.searchByName(productName);
        }
        
        request.setAttribute("dropdown", Flash.getDropDown());
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
