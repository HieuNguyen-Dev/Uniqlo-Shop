<%-- 
    Document   : nav-bar
    Created on : Sep 1, 2022, 9:47:19 AM
    Author     : Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <nav class="nav-bar fixed-top" >
        <div class="container">
            <div class="row align-items-center brown__btn">
                <div class="col-2">
                    <div class="header__logo"> <a href="HomeServlet"><img src="./public/images/login/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-7">
                    <div class="main__menu">
                        <ul class="d-flex flex-row justify-content-center">
                            <li class=""><a href="HomeServlet">Home</a></li>
                            <li class=""><a href="">About</a></li>
                            <li class=""><a href="">Blog</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="CategoryServlet" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    Shop
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="CategoryServlet">ALL</a>
                                    <a class="dropdown-item" href="CategoryServlet?categoryId=1">FURNITURES</a>
                                    <a class="dropdown-item" href="CategoryServlet?categoryId=2">BAGS</a>
                                    <a class="dropdown-item" href="CategoryServlet?categoryId=3">DECORATION</a>
                                    <a class="dropdown-item" href="CategoryServlet?categoryId=4">ACCESSORIES</a>
                                </div>
                            </li>
                            <li class=""><a href="">Pages</a></li>
                            <li class=""><a href="">Contact</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-3">
                    <div class="extra__menu">
                        <ul class="d-flex flex-row">
                            <li class="p-3  position-relative">
                                <form action="SearchServlet" method="get">
                                    <input class="searchBox text-right" type="text" name="productName"  placeholder="search...">
                                    <button class="search-btn" type="submit" href=""><i class="fa-solid fa-magnifying-glass"></i></button>
                                </form>
                            </li>

                            <li class="p-3"><a href="CartServlet"><i class="fa-solid fa-cart-shopping"></i></a></li>
                            <li class="count-cart"><span class="cart-badge">${cartNumber}</span></li>
                            <li class="p-3">
                                <div class="${dropdown}">
                                    <a type="button" data-toggle="" href="LoginServlet"><i class="fa-solid fa-user"></i></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">My Account</a></li>
                                        <li><a href="#">My Purchase</a></li>
                                        <li><a href="LogoutServlet">Logout</a></li>
                                    </ul>
                                </div>
                            </li>


                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</html>
