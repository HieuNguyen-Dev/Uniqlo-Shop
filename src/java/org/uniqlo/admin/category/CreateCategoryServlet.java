/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.uniqlo.admin.AdminServlet;
import org.uniqlo.dao.CategoryDao;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.model.Category;

/**
 *
 * @author Admin
 */
public class CreateCategoryServlet extends AdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
         request.getRequestDispatcher("admin/categories/create.jsp").include(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        
        Category category = new Category(name, desc);
        
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        categoryDao.insert(category);
        
        response.sendRedirect("IndexCategoryServlet");
    }

}
