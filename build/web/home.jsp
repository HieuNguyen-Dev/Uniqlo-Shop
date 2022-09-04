<%-- 
    Document   : home
    Created on : Jul 30, 2022, 6:35:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="stylesheet" href="./public/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="./public/css/style.css">
        <link rel="stylesheet" href="./public/css/homepage.css">
    </head>

    <body>
        <header class="header">
            <%@include file="./inc/nav-bar.jsp" %>
            <div class="header__content" id="header__content">
                <div class="header__content__inner  text-center">
                    <h1>New Product Collection</h1>
                    <div class="brown__btn"><a href="">SHOP NOW</a></div>
                </div>
            </div>
        </header>
        <section class="new__product">
            <div class="container">
                <div class="row text-center brown__btn">
                    <div class="col-6 position-relative"> <a href=""><img src="./public/images/HomePage/NewProductLeft.jpg"
                                                                          alt=""></a>
                        <div class="new__product__content"> <a href="">
                                <h2>New Product Collection</h2>
                            </a>
                            <div><a href="">SHOP NOW --</a></div>
                        </div>
                    </div>
                    <div class="col-6 position-relative"> <a href=""><img src="./public/images/HomePage/NewProductRight.jpg"
                                                                          alt=""></a>
                        <div class="new__product__content"> <a href="">
                                <h2>Basket Collection</h2>
                            </a>
                            <div><a href="">SHOP NOW --</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="best__product">
            <div class="container text-center">
                <h2>New Products</h2>
                <div class="row">
                    <c:forEach items="${newProductList}" var="product">
                        <div class="col-3 best__product-items">
                            <div class="item-thumb"><img class="thumb-img" src="${product.img}" alt=""></div>
                            <div class="item-hover brown__btn">
                                <div class="item-hover__inner d-flex flex-column justify-content-center">
                                    <h3><a href="ProductDetailServlet?productId=${product.id}">${product.name}</a></h3>
                                    <p>$${product.price}</p>
                                    <ul class="d-flex justify-content-center">
                                        <li><a href="" title="View Detail"><i class="fa-solid fa-plus"></i></a></i></li>
                                        <li><a href="" title="Add to cart"><i class="fa-solid fa-cart-shopping"></i></a></li>
                                        <li><a href=""><i class="fa-solid fa-heart"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
        </section>
        <section class="best__product">
            <div class="container text-center">
                <h2>Best Products</h2>
                <div class="row">
                    <c:forEach items="${bestProductList}" var="product">
                        <div class="col-3 best__product-items">
                            <div class="item-thumb"><img class="thumb-img" src="${product.img}" alt=""></div>
                            <div class="item-hover brown__btn">
                                <div class="item-hover__inner d-flex flex-column justify-content-center">
                                    <h3><a href="ProductDetailServlet?productId=${product.id}">${product.name}</a></h3>
                                    <p>$${product.price}</p>
                                    <ul class="d-flex justify-content-center">
                                        <li><a href="" title="View Detail"><i class="fa-solid fa-plus"></i></a></i></li>
                                        <li><a href="" title="Add to cart"><i class="fa-solid fa-cart-shopping"></i></a></li>
                                        <li><a href=""><i class="fa-solid fa-heart"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
        </section>
        <section class="news">
            <div class="container">
                <h2 class="text-center">Recent News</h2>
                <div class="row">
                    <div class="col-4 news__item"> <img src="./public/images/HomePage/blog_img1.jpg" alt="">
                        <div class="news__item__hover">
                            <p>By: Hieu Nguyen</p>
                            <p>Lorem ipsum dolor sit amet consectetu<br>adipisicing elit sed do eius.</p>
                            <div class="read__more__btn brown__btn"> <a href="">Read More</a> </div>
                        </div>
                    </div>
                    <div class="col-4 news__item"> <img src="./public/images/HomePage/blog_img2.jpg" alt="">
                        <div class="news__item__hover">
                            <p>By: Hieu Nguyen</p>
                            <p>Lorem ipsum dolor sit amet consectetu<br>adipisicing elit sed do eius.</p>
                            <div class="read__more__btn brown__btn"> <a href="">Read More</a> </div>
                        </div>
                    </div>
                    <div class="col-4 news__item"> <img src="./public/images/HomePage/blog_img3.jpg" alt="">
                        <div class="news__item__hover">
                            <p>By: Hieu Nguyen</p>
                            <p>Lorem ipsum dolor sit amet consectetu<br>adipisicing elit sed do eius.</p>
                            <div class="read__more__btn brown__btn"> <a href="">Read More</a> </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>  
        <footer class="footer container-fluit">
            <div class="container">
                <div class="top__row">
                    <div class="row">
                        <div class="col-3">
                            <div class="logo"><a href=""><img src="./public/images/HomePage/FooterLogo.png" alt=""></a></div>
                            <p>Get 10% discount with notified about the latest news and updates.</p>
                        </div>
                        <div class="col-3">
                            <h3>Newsletter</h3>
                            <div class="email position-relative"> <input type="email" placeholder="Email Adress">
                                <div class="right__arrow"><a href=""><i class="fa-solid fa-arrow-right"></i></a></div>
                            </div>
                        </div>
                        <div class="col-3 contact">
                            <h3>Contact Us</h3>
                            <p>319 Clematis St. <br>Suite 100 WPB, FL 33401</p>
                        </div>
                        <div class="col-2 follow">
                            <h3>Follow Us</h3>
                            <ul class="d-flex justify-content-between">
                                <li class="twitter"><a href=""><i class="fa-brands fa-twitter"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-instagram"></i></i></a></li>
                                <li><a href=""><i class="fa-brands fa-facebook-f"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-google-plus-g"></i></a></li>
                        </div>
                    </div>
                </div>
                <div class="bottom__row">
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="copyright">
                            <p>© 2022 Uniqlo. Made by Hieu Nguyen</p>
                        </div>
                        <ul class="brown__btn footer_menu d-flex">
                            <li class="p-2"><a href="">Home</a></li>
                            <li class="p-2"><a href="">Product</a></li>
                            <li class="p-2"><a href="">Contact Us</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </body>

</html>