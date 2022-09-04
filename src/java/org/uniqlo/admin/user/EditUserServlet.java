/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.uniqlo.admin.AdminServlet;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.UserDao;
import org.uniqlo.model.User;

/**
 *
 * @author Hieu
 */
public class EditUserServlet extends AdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        int userId = Integer.parseInt(request.getParameter("userId"));

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);

        request.setAttribute("user", user);
        request.getRequestDispatcher("admin/users/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
        int userId = Integer.parseInt(request.getParameter("userId"));

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);

        String role = request.getParameter("role");
        user.setRole(role);
        userDao.update(user);
        response.sendRedirect("IndexUserServlet");
    }
}
