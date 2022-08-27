/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import org.uniqlo.BaseServlet;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.OrderDao;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.dao.UserDao;
import org.uniqlo.util.GetDateTime;

/**
 *
 * @author Hieu
 */
public class DashboardServlet extends AdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        
        int countUser = userDao.countUser();
        int countProduct = productDao.countProduct();
        int countOrder = orderDao.countOrder();
        int countPendingOrder = orderDao.countPendingOrder();
        int countShippingOrder = orderDao.countShippingOrder();
        int countDeliveredOrder = orderDao.countDeliveredOrder();
        int countCanceledOrder = orderDao.countCanceledOrder();
        
        List<String> dateList = GetDateTime.get7Date();
        List<Integer> countEachDay = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
           countEachDay.add(orderDao.countOrderByDay(dateList.get(i)));
        }
        
        request.setAttribute("countEachDay", countEachDay);
        request.setAttribute("dateList", dateList);
        request.setAttribute("countUser", countUser);
        request.setAttribute("countProduct", countProduct);
        request.setAttribute("countOrder", countOrder);
        request.setAttribute("countPendingOrder", countPendingOrder);
        request.setAttribute("countShippingOrder", countShippingOrder);
        request.setAttribute("countDeliveredOrder", countDeliveredOrder);
        request.setAttribute("countCanceledOrder", countCanceledOrder);
        request.getRequestDispatcher("admin/index.jsp").include(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
