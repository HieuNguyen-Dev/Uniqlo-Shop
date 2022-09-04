/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.uniqlo.admin.AdminServlet;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.OrderDao;
import org.uniqlo.dao.UserDao;
import org.uniqlo.model.Order;
import org.uniqlo.model.User;

public class EditOrderServlet extends AdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);
        
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(order.getUserId());

        request.setAttribute("order", order);
        request.setAttribute("user", user);
        request.getRequestDispatcher("admin/orders/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);

        String status = request.getParameter("status");
        order.setStatus(status);
        orderDao.update(order);
        response.sendRedirect("IndexOrderServlet");
    }

}
