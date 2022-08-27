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
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.OrderDao;
import org.uniqlo.dao.OrderDetailDao;
import org.uniqlo.entity.OrderDetailSession;
import org.uniqlo.model.Order;
import org.uniqlo.model.OrderDetail;
import org.uniqlo.model.User;
import org.uniqlo.util.Flash;
import org.uniqlo.util.GetDateTime;
import org.uniqlo.util.StringHelper;

/**
 *
 * @author Hieu
 */
public class CheckoutServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateTimeFormatter format = DateTimeFormatter
            .ofPattern("YYYY-MM-dd");
        if (isLogged(request, response)) {
            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");
            OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
            String code = StringHelper.randomString(8);
            String currentDateTime = GetDateTime.now.format(format);
            Order order = new Order(code, "Pending", user.getId(), currentDateTime);
            orderDao.insert(order);
            order = orderDao.findByCode(code);

            OrderDetailDao orderDetailDao = DatabaseDao.getInstance().getOrderDetailDao();

            if (session.getAttribute("cart") != null) {
                List<OrderDetailSession> orderDetailSessionList = (List<OrderDetailSession>) session.getAttribute("cart");
                for (OrderDetailSession orderDetailSession : orderDetailSessionList) {
                    OrderDetail orderDetail = new OrderDetail(orderDetailSession.getQuantity(), orderDetailSession.getProductId(), order.getId());
                    orderDetailDao.insert(orderDetail);
                }
                Flash.cartNumber = 0;   
                session.removeAttribute("cart");
            }

            response.sendRedirect("CartServlet");
        } else {
            response.sendRedirect("LoginServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        isLogged(request, response);
    }

    private boolean isLogged(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        return session.getAttribute("user") != null;
    }
}
