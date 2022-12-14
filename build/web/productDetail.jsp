<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Details</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="./public/css/bootstrap.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
        <link rel="stylesheet" href="./public/css/products_details.css">
    </head>

    <body>
        <header class="header">
            <%@include file="./inc/nav-bar.jsp" %>
            <div class="header__content row text-center align-items-center">
                <div class="header__content__inner">
                    <h1>Product Details</h1>
                    <div class="brown__btn"><a href="">Home</a><span> / Product Details</span></div>
                </div>
            </div>
        </header>
        <form action="OrderServlet" method="post">
            <input type="hidden" name="action" value="creat"/>
            <input type="hidden" name="productId" value="${product.id}"/>
            <input type="hidden" name="productName" value="${product.name}"/>
            <input type="hidden" name="price" value="${product.price}"/>
            <input type="hidden" name="img" value="${product.img}"/>
            <section class="product__details">
                <div class="container">
                    <div class="row">
                        <div class="col-2">
                            <ul class="d-flex flex-column">
                                <li class="item-image"><a href=""><img src="./public/images/product_details/1.jpg" alt=""></a>
                                </li>
                                <li class="item-image"><a href=""><img src="./public/images/product_details/2.jpg" alt=""></a>
                                </li>
                                <li class="item-image"><a href=""><img src="./public/images/product_details/3.jpg" alt=""></a>
                                </li>
                                <li class="item-image"><a href=""><img src="./public/images/product_details/4.jpg" alt=""></a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-4">
                            <img class="product-img" src="${product.img}" alt="">
                        </div>
                        <div class="col-6 product__details__inner">
                            <h1>${product.name}</h1>
                            <div class="category d-flex">
                                <span>Category:</span>
                                &ensp;
                                <div><a href="CategoryServlet?categoryId=${category.id}">${category.name}</a></div>
                            </div>

                            <p>${product.desc}</p>
                            <ul class="price d-flex">
                                <li class="old-price">$15.21</li>
                                <li class="new-price">$10.00</li>
                            </ul>
                            <div class="product-quantity d-flex align-items-center">
                                <span>Quantity :</span>
                                <div class="quantity">
                                    <input name="quantity" type="number" value="1" min="1">
                                </div>
                            </div>
                            <button class="btn btn-outline-danger add-to-cart" type="submit">Add to cart</button>
                            <a href="#" class="add-to-cart btn btn-outline-danger">Buy Now</a>

                        </div>
                    </div>
                </div>
            </section>
        </form>
        <section class="product__desc">
            <div class="container">
                <h1 class="text-center">Description</h1>
                <h2>Detail</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                    dolore magna aliqua. Ut enim ad minim veniam, quis noexercit ullamco laboris nisi ut aliquip ex ea
                    commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                    fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                    deserunt mollit anim id.
                </p>
                <h2>Features</h2>
                <ul class="features_list">
                    <li class="features_item">Duis aute irure dolor in reprehenderit in voluptate velit esse</li>
                    <li class="features_item">Irure dolor in reprehenderit in voluptate velit esse</li>
                    <li class="features_item">Sed do eiusmod tempor incididunt ut labore et</li>
                    <li class="features_item">Nisi ut aliquip ex ea commodo consequat.</li>
                </ul>
            </div>
        </section>
        <footer class="footer container-fluit">
            <div class="container">
                <div class="top__row">
                    <div class="row">
                        <div class="col-3">
                            <div class="logo"><a href=""><img src="./public/images/Products_List/Logo.png" alt=""></a>
                            </div>
                            <p>Get 10% discount with notified about the latest news and updates.</p>
                        </div>
                        <div class="col-3">
                            <h3>Newsletter</h3>
                            <div class="email position-relative">
                                <input type="email" placeholder="Email Adress">
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
                            <p>?? 2022 Uniqlo. Made by Hieu Nguyen</p>
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