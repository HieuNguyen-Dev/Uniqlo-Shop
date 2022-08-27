/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.UserDao;
import org.uniqlo.model.User;
import org.uniqlo.util.Flash;
import org.uniqlo.util.MD5Hashing;


/**
 *
 * @author Hieu
 */
public class RegisterServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Flash.init(request.getSession());
        request.setAttribute("error", Flash.getError());
        request.getRequestDispatcher("register.jsp").forward(request, response);
        Flash.pushError("");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = MD5Hashing.getMD5(request.getParameter("password"));
        

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User findUser = userDao.findByEmail(email);
        if (findUser != null) {
            Flash.init(request.getSession());
            Flash.pushError("Email is existed!");
            response.sendRedirect("RegisterServlet");
        } else {
            User user = new User(email, password, "user");
            userDao.insert(user);
            Flash.init(request.getSession());
            Flash.pushError("Register success - Login your account");
            response.sendRedirect("LoginServlet");
              
        }
    }

}
