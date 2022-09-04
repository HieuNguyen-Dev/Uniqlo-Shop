/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.uniqlo.admin.AdminServlet;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.UserDao;
import org.uniqlo.model.User;
import org.uniqlo.util.MD5Hashing;

/**
 *
 * @author Hieu
 */
public class CreateUserServlet extends AdminServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
         request.getRequestDispatcher("admin/users/create.jsp").include(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
        String email = request.getParameter("email");
        String password = MD5Hashing.getMD5(request.getParameter("password"));
        String role = request.getParameter("role");
        
        User user = new User(email, password, role);
        
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        userDao.insert(user);
        
        response.sendRedirect("IndexUserServlet");
    }

}
