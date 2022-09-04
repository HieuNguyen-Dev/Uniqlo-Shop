/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.model.Product;
import org.uniqlo.util.Flash;

public class HomeServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> bestProductList = new ArrayList<Product>();
        List<Integer> productIdList = productDao.bestProduct();
        for (Integer integer : productIdList) {
            bestProductList.add(productDao.find(integer));
        }
        
        List<Product> newProductList = productDao.newProduct();
        
        
        HttpSession session = request.getSession();
        Flash flash = new Flash();
        if (session.getAttribute("user") != null){
            flash.setDropDown("dropdown");
        }else{
            flash.setDropDown("");
        }
        
        request.setAttribute("cartNumber", Flash.cartNumber);
        request.setAttribute("bestProductList", bestProductList);
        request.setAttribute("newProductList", newProductList);
        request.setAttribute("dropdown", flash.getDropDown());
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
