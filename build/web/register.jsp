<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="./public/css/bootstrap.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
        <link rel="stylesheet" href="./public/css/register.css">
    </head>

    <body>
        <div class="wrapper container-fluit brown__btn">
            <header class="header">
                <%@include file="./inc/nav-bar.jsp" %>
            </header>
            <section class="login-form">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-6 login__register">
                            <ul class="d-flex justify-content-center">
                                <li><a href="LoginServlet">Login</a></li>
                                <li class="reg__btn"><a href="RegisterServlet">Register</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="reg-input row justify-content-center">
                        <div class="col-4">
                            <form action="RegisterServlet" method="post">
                                <p>${error}</p>
                                <input class="email" type="email" placeholder="Email*" name="email">
                                <input class="password" type="password" placeholder="Password*" name="password">
                                <div class="tabs__checkbox row justify-content-center">
                                </div>
                                <div class="text-center">
                                    <input class="register__btn" type="submit" value="Register" />
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="social__connect row justify-content-center">
                        <div class="col-2 text-center">
                            <h2>Or Login With</h2>
                            <ul class="social__list d-flex justify-content-between">
                                <li class="twitter"><a href=""><i class="fa-brands fa-twitter"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-instagram"></i></i></a></li>
                                <li><a href=""><i class="fa-brands fa-facebook-f"></i></a></li>
                                <li><a href=""><i class="fa-brands fa-google-plus-g"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>
            <footer class="footer container-fluit">
                <div class="container">
                    <div class="top__row">
                        <div class="row">
                            <div class="col-3">
                                <div class="logo"><a href=""><img src="./public/images/HomePage/FooterLogo.png" alt=""></a>
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
        </div>

    </body>
</html>
