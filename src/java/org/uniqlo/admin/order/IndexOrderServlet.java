/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.uniqlo.BaseServlet;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.OrderDao;
import org.uniqlo.model.Order;

public class IndexOrderServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        List<Order> orderList = null;
        if (request.getParameter("status") == null) {
            orderList = orderDao.all();
        } else {
            String status = request.getParameter("status");
            orderList = orderDao.findByStatus(status);
        }

//        List<String> statusList = new ArrayList<>();
//        statusList.add("Pending");
//        statusList.add("Shipping");
//        statusList.add("Delivered");
//        statusList.add("Canceled");
//        request.setAttribute("statusList", statusList);
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("admin/orders/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
