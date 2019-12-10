<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.furniture.entities.Products" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en"><head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/all.css"> 
		<link rel="icon" href="img/favicon.png">
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.shop.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style-services.css">	
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
     
    <!-- Title  -->
    <title>Smart Store </title>

    <!-- Favicon  -->
    <link rel="icon" href="resources/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="resources/css/core-style.css">
    <link rel="stylesheet" href="resources/style.css">
    

</head>

<body>
    <!-- Search Wrapper Area Start -->
    <div class="search-wrapper section-padding-100">
        <div class="search-close">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-content">
                        <form action="#" method="get">
                            <input type="search" name="search" id="search" placeholder="Type your keyword...">
                            <button type="submit"><img src="resources/img/core-img/search.png" alt=""></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Search Wrapper Area End -->

    <!-- ##### Main Content Wrapper Start ##### -->
    <div class="main-content-wrapper d-flex clearfix">

        <!-- Mobile Nav (max width 767px)-->
        <div class="mobile-nav">
            <!-- Navbar Brand -->
            <div class="amado-navbar-brand">
                <a href="index.jsp"><img src="resources/img/core-img/smart.jpg" alt=""></a>
            </div>
            <!-- Navbar Toggler -->
            <div class="amado-navbar-toggler">
                <span></span><span></span><span></span>
            </div>
        </div>

        <!-- Header Area Start -->
        <header class="header-area clearfix">
            <!-- Close Icon -->
            <div class="nav-close">
                <i class="fa fa-close" aria-hidden="true"></i>
            </div>
            <!-- Logo -->
            <div class="logo">
                <a href="index.jsp"><img src="resources/img/core-img/smart.jpg" alt=""></a>
           </div>
            <!-- Amado Nav -->
                        <!-- Button Group -->
            <div class="amado-btn-group mt-30 mb-100">
                <a href="#" class="btn amado-btn mb-15">%Discount%</a>
                <a href="#" class="btn amado-btn active">New this week</a>
            </div>
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100">
                <a href="cart.jsp" class="cart-nav"><img src="resources/img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
                <a href="#" class="fav-nav"><img src="resources/img/core-img/favorites.png" alt=""> Favourite</a>
                <a href="#" class="search-nav"><img src="resources/img/core-img/search.png" alt=""> Search</a>
            </div>
            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
        </header>
        <!-- Header Area End -->

        <div class="cart-table-area section-padding-100">
             <form id="shopping-cart" action="cart.jsp" method="get">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-8">
                        <div class="cart-title mt-50">
                            <h2>Shopping Cart</h2>
                        </div>

                        <div class="cart-table clearfix">
                            
<table class="table table-responsive" tabindex="1" style="overflow: hidden; outline: none;">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
           <c:forEach  var="lines" items= '<%= request.getAttribute("cart") %>'>
                   <tr>   
                     <c:set var="name" value="${lines.getProductName()}"/>
                                    
                                 
                                        <td class="cart_product_img">
                                                                           <c:choose>
                                    <c:when test="${name=='chair'}">
                                <img src="resources/img/chair.jpg" alt="kkk">
                                     </c:when>
                                     <c:when test="${name=='table'}">
                                <img src="resources/img/table.jpg" alt="">
                                     </c:when>
                                    <c:when test="${name=='tvstand'}">
                                <img src="resources/img/tvstand.jpg" alt="">
                                     </c:when>
                                </c:choose>
                                <!-- Hover Thumb -->
                               
                                
                                        </td>
                                        <td class="cart_product_desc">
                                    <c:out value="${lines.getProductName()}"/>
                                        </td>
                                        <td class="price">
                                            <span><c:out value="${lines.getPrice()}"/></span>
                                        </td>
                                        <td class="qty">
                                            <span><c:out value="${lines.getQuantity()}"/></span>                   
                                        </td>
                                        
                                    
                                            </tr>    
                           
                                                    
</c:forEach>
                                

                                </tbody>
                                
                                
<div class="col-12 col-lg-12" id="shopping-cart-actions">
                
                      <a href="${pageContext.request.contextPath}/updateCart" class="btn">Update Cart</a>
                  
                  <a href="${pageContext.request.contextPath}/clearCart" class="btn">Clear Cart</a>                 
                  <a href="${pageContext.request.contextPath}/viewProducts" class="btn">Continue Shopping</a>
                 
                                       
</div>

                                                                  
                            </table>

                        </div>
                    </div>
                    <div class="col-12 col-lg-4">
                        <div class="cart-summary">
                            <h5>Cart Total</h5>
                            <ul class="summary-table">
                                <li><span>subtotal:</span> <span>${subTotal}</span></li>
                                <li><span>delivery:</span> <span>${delivery}</span></li>
                                <li><span>total:</span> <span>${Total}</span></li>
                            </ul>
                            <div class="cart-btn mt-100">
                                <a href="checkout.jsp" class="btn amado-btn w-100">Checkout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                   </form>
        </div>
                 
    </div>
    <!-- ##### Main Content Wrapper End ##### -->

    <!-- ##### Newsletter Area Start ##### -->
  <!-- ##### Newsletter Area End ##### -->

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer_area clearfix">
        <div class="container">
            <div class="row align-items-center">
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-4">
                    <div class="single_widget_area">
                        <!-- Logo -->
                        <div class="footer-logo mr-50">
                           <a href="index.jsp"><img src="resources/img/core-img/smart.jpg" alt=""></a>
             </div>
                        <!-- Copywrite Text -->
                        <p class="copywrite"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright 20192019 All rights reserved</p>
                    </div>
                </div>
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-8">
                    <div class="single_widget_area">
                        <!-- Footer Menu -->
                        <div class="footer_menu">
                           <!-- <nav class="navbar navbar-expand-lg justify-content-end">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                                <div class="collapse navbar-collapse" id="footerNavContent">
                                    <ul class="navbar-nav ml-auto">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="index.html">Home</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="shop.html">Shop</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="product-details.html">Product</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="cart.html">Cart</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="checkout.jsp">Checkout</a>
                                        </li>
                                    </ul>
                                </div>
                            </nav>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area End ##### -->

    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
      <script type="text/javascript" src="resources/js/jquery.shop.js"></script>
  <!--  <script src="resources/js/jquery/jquery-2.2.4.min.js"></script>-->.
  
    <script src="js/slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  <!--  <script src="resources/js/jquery/jquery-2.2.4
    <!-- Popper js -->
    <script src="resources/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="resources/js/s.min.js"></script>
    <!-- Plugins js -->
    <script src="resources/js/plugins.js"></script>
    <!-- Active js -->
    <script src="resources/js/active.js"></script><a id="scrollUp" href="#top" style="position: fixed; z-index: 2147483647; display: none;"><i class="fa fa-angle-up" aria-hidden="true"></i></a><div id="ascrail2000" class="nicescroll-rails nicescroll-rails-vr" style="width: 8px; z-index: 1; cursor: default; position: absolute; top: 154.953px; left: 611px; height: 531px; display: none; opacity: 0;"><div class="nicescroll-cursors" style="position: relative; top: 0px; float: right; width: 6px; height: 531px; background-color: rgb(66, 66, 66); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 5px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails nicescroll-rails-hr" style="height: 8px; z-index: 1; top: 677.953px; left: 15px; position: absolute; cursor: default; width: 604px; opacity: 0; display: block;"><div class="nicescroll-cursors" style="position: absolute; top: 0px; height: 6px; width: 483px; background-color: rgb(66, 66, 66); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 5px; left: 0px;"></div></div><a id="scrollUp" href="#top" style="position: fixed; z-index: 2147483647;"><i class="fa fa-angle-up" aria-hidden="true"></i></a><div id="ascrail2000" class="nicescroll-rails nicescroll-rails-vr" style="width: 8px; z-index: 1; cursor: default; position: absolute; top: 189px; left: 616px; height: 535px; display: none; opacity: 0;"><div class="nicescroll-cursors" style="position: relative; top: 0px; float: right; width: 6px; height: 535px; background-color: rgb(66, 66, 66); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 5px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails nicescroll-rails-hr" style="height: 8px; z-index: 1; top: 716px; left: 15px; position: absolute; cursor: default; width: 609px; opacity: 0; display: block;"><div class="nicescroll-cursors" style="position: absolute; top: 0px; height: 6px; width: 487px; background-color: rgb(66, 66, 66); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 5px; left: 0px;"></div></div>



</body></html>