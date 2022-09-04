/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.uniqlo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import org.uniqlo.dao.CategoryDao;
import org.uniqlo.dao.DatabaseDao;
import org.uniqlo.dao.ProductDao;
import org.uniqlo.model.Category;
import org.uniqlo.model.Product;
import org.uniqlo.util.Flash;

/**
 *
 * @author Hieu
 */
public class CategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.all();
        int first, last, pages, total, loop;
        List<Integer> pagesList = new ArrayList<>();
        last = 8;

        List<Product> productList = null;
        if (request.getParameter("categoryId") == null || request.getParameter("categoryId") == "") {
            total = productDao.countProduct();
            if (total % 8 == 0) {
                loop = total / 8;
            } else {
                loop = total / 8 + 1;
            }
            for (int i = 1; i <= loop; i++) {
                pagesList.add(i);
            }
            if (request.getParameter("pages") != null && Integer.parseInt(request.getParameter("pages")) <= loop) {
                pages = Integer.parseInt(request.getParameter("pages"));
            } else {
                pages = 1;
            }
            first = (pages - 1) * 8;

            productList = productDao.allByPages(first, last);
        } else {
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            total = productDao.countProductByCategory(categoryId);
            if (total % 8 == 0) {
                loop = total / 8;
            } else {
                loop = total / 8 + 1;
            }
            for (int i = 1; i <= loop; i++) {
                pagesList.add(i);
            }
            if (request.getParameter("pages") != null && Integer.parseInt(request.getParameter("pages")) <= loop) {
                pages = Integer.parseInt(request.getParameter("pages"));
            } else {
                pages = 1;
            }
            first = (pages - 1) * 8;

            productList = productDao.findByCategoryId(categoryId, first, last);
            request.setAttribute("categoryId", categoryId);
        }

        request.setAttribute("dropdown", Flash.getDropDown());
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("pagesList", pagesList);
        request.getRequestDispatcher("category.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
