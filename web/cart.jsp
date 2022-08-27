<%-- 
    Document   : cart
    Created on : Aug 4, 2022, 6:00:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cart</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="./public/css/bootstrap.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
        <link rel="stylesheet" href="./public/css/cart.css">
    </head>

    <body>

        <header class="header">
            <nav class="nav-bar fixed-top">
                <div class="container">
                    <div class="row align-items-center brown__btn">
                        <div class="col-2">
                            <div class="header__logo"> <a href="http://localhost:8080/UniqloShop/HomeServlet"><img src="./public/images/login/logo.png"
                                                                                                                   alt=""></a> </div>
                        </div>
                        <div class="col-8">
                            <div class="main__menu">
                                <ul class="d-flex flex-row justify-content-center">
                                    <li class=""><a href="HomeServlet">Home</a></li>
                                    <li class=""><a href="">About</a></li>
                                    <li class=""><a href="">Blog</a></li>
                                    <li class=""><a href="CategoryServlet">Shop</a></li>
                                    <li class=""><a href="">Pages</a></li>
                                    <li class=""><a href="">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="extra__menu">
                                <ul class="d-flex flex-row">
                                    <li class="p-3"><a href=""><i class="fa-solid fa-magnifying-glass"></i></a></li>
                                    <li class="p-3"><a href=""><i class="fa-solid fa-user"></i></a></li>
                                    <li class="p-3"><a href=""><i class="fa-solid fa-cart-shopping"></i></a></li>
                                    <li class="count-cart"><span class="cart-badge">${cartNumber}</span></li>
                                    <li class="p-3"><a href=""><i class="fa-solid fa-bars"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <div class="header__content row text-center align-items-center">
                <div class="header__content__inner">
                    <h1>Cart</h1>
                    <div class="brown__btn"><a href="">Home</a><span> / Cart</span></div>
                </div>
            </div>
        </header>
        <section class="cart">
            <div class="container">
                <div class="table-content">
                    <table class="table align-middle text-center">
                        <thead>
                            <tr>
                                <th scope="col">IMAGE</th>
                                <th scope="col">PRODUCT</th>
                                <th scope="col">PRICE</th>
                                <th scope="col">QUANTITY</th>
                                <th scope="col">TOTAL</th>
                                <th scope="col">REMOVE</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="total" value="0"></c:set>
                            <c:forEach items="${cart}" var="orderDetailSession">
                                <tr class="">
                                    <th scope="row"><img src="${orderDetailSession.img}" alt="" width="125px" height="
                                                         125px"></th>
                                    <td>${orderDetailSession.productName}</td>
                                    <td>${orderDetailSession.price}</td>
                                    <td class="product-quantity">${orderDetailSession.quantity}</td>
                                    <td>${orderDetailSession.price * orderDetailSession.quantity}</td>
                                    <td>
                                        <form action="OrderServlet" method="post">
                                            <input type="hidden" name="action" value="delete"/>
                                            <input type="hidden" name="productId" value="${orderDetailSession.productId}"/>
                                            <button type="submit">x</button>
                                        </form>
                                    </td>
                                </tr>
                                <c:set var="total" value="${total+(orderDetailSession.price * orderDetailSession.quantity)}"></c:set>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="row">

                </div>
            </div>
        </section>
        <section class="cart-total">
            <div class="container">
                <div class="row">
                    <div class="col-8">
                        <button class="btn btn-outline-danger">Update Cart</button>
                        <a href="category.html" class="btn btn-outline-danger">Continue Shopping</a>
                        <div class="coupon">
                            <h3>Coupon</h3>
                            <p>Enter your coupon code if you have one.</p>
                            <input class="coupon-code" type="text" placeholder="Coupon code">
                            <button class="coupon-btn btn btn-dark">APPLY COUPON</button>

                        </div>
                    </div>
                    <div class="col-4">
                        <h2>Cart Totals: ${total}</h2>
                        <table>
               
                        </table>
                        <div class="wc-proceed-to-checkout">
                            <a href="CheckoutServlet" class="checkout-btn btn btn btn-dark">Proceed to Checkout</a>
                        </div>
                    </div>
                </div>
            </div>

        </section>


        <script src="./public/js/navbar_white.js"></script>
    </body>

</html>