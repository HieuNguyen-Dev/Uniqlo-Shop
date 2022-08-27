/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.uniqlo.BaseServlet;
import org.uniqlo.model.User;

/**
 *
 * @author Hieu
 */
public class AdminServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkPermission(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkPermission(req, resp);
    }
    
    private void checkPermission(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession session = req.getSession();
        
        if(session.getAttribute("user") != null){
            User findUser = (User) session.getAttribute("user");
            if(!findUser.getRole().equals("Admin"))
                resp.sendRedirect("HomeServlet");
        }else{
            resp.sendRedirect("LoginServlet");
        }
    }

}
