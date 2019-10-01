<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.furniture.entities.Products" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!--- ma resourcse -->
        <!-- Bootstrap Core CSS -->
    <link href="resources/ma/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="resources/ma/css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="resources/ma/css/colors/green.css" id="theme" rel="stylesheet">
    <!-- ma resources end-->
    
    
        <link rel="stylesheet" href="resources/css/all.css"> 
        <link rel="icon" href="img/favicon.png">
		<script type="text/javascript" src="resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.shop.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/style-services.css">		
    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Shop</title>

    <!-- Favicon  -->
    <link rel="icon" href="resources/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="resources/css/core-style.css">
    <link rel="stylesheet" href="style.css">

    <!-- float cart css -->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="resources/cssf/font-awesome.min.css" type="text/css" media="all">
<!--// css -->
<!-- font -->
<link href="//fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic" rel="stylesheet" type="text/css">
<!-- //font -->
<script src="resources/jsf/jquery-1.11.1.min.js"></script>
<script src="resources/jsf/bootstrap.js"></script> 
    
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(function() { // document ready
	if ($('#sticky').length) { // make sure "#sticky" element exists
		var el = $('#sticky');
		var stickyTop = $('#sticky').offset().top; // returns number
		var stickyHeight = $('#sticky').height();

		$(window).scroll(function() { // scroll event
			var limit = $('.newsletter-area').offset().top - stickyHeight - 20;

			var windowTop = $(window).scrollTop(); // returns number

			if (stickyTop < windowTop) {
				el.css({
					position: 'fixed',
					top: 0,
                                        right: 0
				});
			} else {
				el.css('position', 'static');
			}

			if (limit < windowTop) {
				var diff = limit - windowTop;
				el.css({
					top: diff
				});
			}
		});
	}
});
</script>


</head>

<body>

        <div class="row header-top">
            
                                  
            <div class="shopLogo">
                        <img src="resources/img/core-img/logo.png" alt="">

            </div>
              <!-- cart start-->
            <!-- --cart end_-->
            
    </div>
    
    <!-- ##### Main Content Wrapper Start ##### -->
<div class="row">
    <div class="main-content-wrapper d-flex clearfix">


        

<!-- start of side panel -->

        <div class="shop_sidebar_area" style="width: 20%">

            <!-- ##### Single Widget ##### -->
            <div class="widget catagory mb-50">
                <!-- Widget Title -->
                <h6 class="widget-title mb-30">Catagories</h6>

                <!--  Catagories  -->
                <div class="catagories-menu">
                    <ul>
                        <li class="active"><a href="#">Chairs</a></li>
                        <li><a href="#">Beds</a></li>
                        <li><a href="#">Accesories</a></li>
                        <li><a href="#">Furniture</a></li>
                        <li><a href="#">Home Deco</a></li>
                        <li><a href="#">Dressings</a></li>
                        <li><a href="#">Tables</a></li>
                    </ul>
                </div>
            </div>

            <!-- ##### Single Widget ##### -->
            <div class="widget brands mb-50">
                <!-- Widget Title -->
                <h6 class="widget-title mb-30">Brands</h6>

                <div class="widget-desc">
                    <!-- Single Form Check -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="amado">
                        <label class="form-check-label" for="amado">Amado</label>
                    </div>
                    <!-- Single Form Check -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="ikea">
                        <label class="form-check-label" for="ikea">Ikea</label>
                    </div>
                    <!-- Single Form Check -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="furniture">
                        <label class="form-check-label" for="furniture">Furniture Inc</label>
                    </div>
                    <!-- Single Form Check -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="factory">
                        <label class="form-check-label" for="factory">The factory</label>
                    </div>
                    <!-- Single Form Check -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="artdeco">
                        <label class="form-check-label" for="artdeco">Artdeco</label>
                    </div>
                </div>
            </div>

            <!-- ##### Single Widget ##### -->
            <div class="widget color mb-50">
                <!-- Widget Title -->
                <h6 class="widget-title mb-30">Color</h6>

                <div class="widget-desc">
                    <ul class="d-flex">
                        <li><a href="#" class="color1"></a></li>
                        <li><a href="#" class="color2"></a></li>
                        <li><a href="#" class="color3"></a></li>
                        <li><a href="#" class="color4"></a></li>
                        <li><a href="#" class="color5"></a></li>
                        <li><a href="#" class="color6"></a></li>
                        <li><a href="#" class="color7"></a></li>
                        <li><a href="#" class="color8"></a></li>
                    </ul>
                </div>
            </div>

            <!-- ##### Single Widget ##### -->
            <div class="widget price mb-50">
                <!-- Widget Title -->
                <h6 class="widget-title mb-30">Price</h6>

                <div class="widget-desc">
                    <div class="slider-range">
                        <div data-min="10" data-max="1000" data-unit="$" class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" data-value-min="10" data-value-max="1000" data-label-result="">
                            <div class="ui-slider-range ui-widget-header ui-corner-all"></div>
                            <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                            <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                        </div>
                        <div class="range-price">$10 - $1000</div>
                    </div>
                </div>
            </div>
        </div>
<!-- rend of side panel -->

        <!-- start of product_area -->
        
        <div class="amado_product_area" style="width: 50%">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-12">
                        
                        
                        
                        
                        <div class="product-topbar d-xl-flex align-items-end justify-content-between">
                            <!-- Total Products -->
                            <div class="total-products">
                                <p>Showing 1-8 0f 25</p>
                                <div class="view d-flex">
                                    <a href="#"><i class="fa fa-th-large" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-bars" aria-hidden="true"></i></a>
                                </div>
                            </div>
                            <!-- Sorting -->
                            <div class="product-sorting d-flex">
                                <div class="sort-by-date d-flex align-items-center mr-15">
                                    <p>Sort by</p>
                                    <form action="#" method="get">
                                        <select name="select" id="sortBydate">
                                            <option value="value">Date</option>
                                            <option value="value">Newest</option>
                                            <option value="value">Popular</option>
                                        </select>
                                    </form>
                                </div>
                                <div class="view-product d-flex align-items-center">
                                    <p>View</p>
                                    <form action="#" method="get">
                                        <select name="select" id="viewProduct">
                                            <option value="value">12</option>
                                            <option value="value">24</option>
                                            <option value="value">48</option>
                                            <option value="value">96</option>
                                        </select>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                        <c:set var="count" value="0" scope="page" />
                   <input type="hidden" class="catalogueSize" value="${sizo}">
                    <c:forEach  var="lines" items= '<%= request.getAttribute("products") %>'>
                        <c:set var="name" value="${lines.getProductName()}"/>

                     <!-- Single Product Area -->

                    <div class="col-12 col-sm-6 col-md-12 col-xl-6">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
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
                                <img class="hover-img" src="resources/img/product2.jpg" alt="">
                            </div>

                            <!-- Product Description -->
                            <div class="product-description d-flex align-items-center justify-content-between">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price">USD<c:out value="${lines.getPrice()}"/></p>
                                    <a href="${pageContext.request.contextPath}/">
                                        <h6><c:out value="${lines.getProductName()}"/></h6>
                                    </a>
                                </div
                                    <c:set var="id" value="${lines.getProductId()}"/>
                    
                                
                                <!--Product Qty and form to submit-->
<!--<form id="formT" data-parsley-validate novalidate action="${pageContext.request.contextPath}/addToCart" method="post"> -->
    <div>
					
						
	
					
						<div class="input-group">
								<input type="hidden" class="itemID${count}" value="${id}">
                            <!--	<input type="text" placeholder="Quantity" name= "quantity" class="form-control"> -->
                            <input type="text" class="itemQuantiy${count} inputQuantitities" placeholder="Quantity">
								<input type="hidden" class="itemPrice${count}" value="${lines.getPrice()}">
								<input type="hidden" class="itemName${count}" value="${lines.getProductName()}">
                        </div>
			   
                                                
					<button class="add__btn${count} btn btn-custom-primary btn-lg btn-block btn-auth"><i class="fa fa-arrow-circle-o-right"></i> ADD TO CART</button>
                    <c:set var="count" value="${count + 1}" scope="page"/>

                </div>                      

                            </div>
                                                                                        <!-- Ratings & Cart -->
                                <div class="ratings-cart text-right">
                                    <div class="ratings">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                    <div class="cart">
                                        <!--<a href="${pageContext.request.contextPath}/addToCart?itemID=${lines.getProductId()}" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="resources/img/core-img/cart.png" alt=""></a>-->
                                    </div>
                                </div>
                        </div>
                                                        
                    </div>
                    <!-- end Single Product Area -->
</c:forEach>
                </div>

                
                

                
                <div class="row">
                    <div class="col-12">
                        <!-- Pagination -->
                        <nav aria-label="navigation">
                            <ul class="pagination justify-content-end mt-50">
                                <li class="page-item active"><a class="page-link" href="#">01.</a></li>
                                <li class="page-item"><a class="page-link" href="#">02.</a></li>
                                <li class="page-item"><a class="page-link" href="#">03.</a></li>
                                <li class="page-item"><a class="page-link" href="#">04.</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <!-- end of product area -->
                    
       <!-- start of cart region -->
             <!--       <div class="cart_region" style="width: 25%">
    <div>
<form action="${pageContext.request.contextPath}/add" method="post"> 
    <div class="table-responsive">
       <table class="table table-striped" tabindex="1" style="overflow: hidden; outline: none;" id="tee"> 
          <!-- <thead> <tr> <th>Item ID</th> <th>Name</th> <th>Quantity</th> <th>Price</th> <th>Total</th></tr> -->
  <!--                   <thead> <tr> <th>Name</th> <th>Quantity</th> <th>Price</th></tr> 
           </thead>
           <tbody id="floater">
               
       </tbody> 
       </table> 
    </div>
        <button>Submit</button>
</form>                            
    </div>  
   
                        
                    </div> -->
  
  <div class="mother_class">
      
      <!--start of form-->
      
      <form action="${pageContext.request.contextPath}/checkOut" method="post"> 
      
                                    <table class="table table-striped cartTableArea tee">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Quantity</th>
                                                <th class="text-nowrap">Price</th>
                                            </tr>
                                        </thead>
                                        <tbody id="floater">
                                        </tbody>
                                    </table>
      <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Total</th>
                                                <th id="totalField">0</th>
                                            </tr>
                                        </thead>
      </table>
      <div class="col-12 col-lg-12" id="shopping-cart-actions">
       <button class="btn" style="font-size: 1rem; padding: 5px;">Checkout</button>                
    <!-- ${pageContext.request.contextPath}/    <a href="/shop/checkout" class="btn" style="font-size: 1rem; padding: 5px;">Checkout</a> -->
        <a class="btn clearCart" style="font-size: 1rem; color: white; padding: 5px;">Clear Cart</a>   </br></br>              
  <!--  <a href="/shop/viewProducts" class="btn" style="font-size: 1rem;">Continue Shopping</a> -->
   
                         
</div>
  </form>
        <!--end of form -->
        
                                </div>
       <!-- end of cart region--> 
    </div>
</div>
    <!-- ##### Main Content Wrapper End ##### -->

    <!-- ##### Newsletter Area Start ##### -->
    <section class="newsletter-area section-padding-100-0">
        <div class="container">
            <div class="row align-items-center">
                <!-- Newsletter Text -->
                <div class="col-12 col-lg-6 col-xl-7">
                    <div class="newsletter-text mb-100">
                        <h2>Subscribe for a <span>25% Discount</span></h2>
                        <p>Nulla ac convallis lorem, eget euismod nisl. Donec in libero sit amet mi vulputate consectetur. Donec auctor interdum purus, ac finibus massa bibendum nec.</p>
                    </div>
                </div>
                <!-- Newsletter Form -->
                <div class="col-12 col-lg-6 col-xl-5">
                    <div class="newsletter-form mb-100">
                        <form action="#" method="post">
                            <input type="email" name="email" class="nl-email" placeholder="Your E-mail">
                            <input type="submit" value="Subscribe">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
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
                            <a href="indexf.html"><img src="resources/img/core-img/logo2.png" alt=""></a>
                        </div>
                        <!-- Copywrite Text -->
                        <p class="copywrite"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> & Re-distributed by <a href="https://themewagon.com/" target="_blank">Themewagon</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-8">
                    <div class="single_widget_area">
                        <!-- Footer Menu -->
                        <div class="footer_menu">
                            <nav class="navbar navbar-expand-lg justify-content-end">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                                <div class="collapse navbar-collapse" id="footerNavContent">
                                    <ul class="navbar-nav ml-auto">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="indexf.html">Home</a>
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
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area End ##### -->

    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <!--  <script src="resources/js/jquery/jquery-2.2.4.min.js"></script>-->
    <!-- Popper js -->
    <!-- Bootstrap js -->
    <!-- Plugins js -->
    <!-- Active js -->
        <script src="resources/js/app.js"></script>

        <!-- ma drpdown cart events -->
    <script src="resources/ma/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="resources/ma/plugins/bootstrap/js/popper.min.js"></script>
    <script src="resources/ma/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="resources/ma/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="resources/ma/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="resources/ma/js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="resources/ma/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <!--Custom JavaScript -->
    <script src="resources/ma/js/custom.min.js"></script>
    <!-- ============================================================== -->
    <!-- Style switcher -->
    <!-- ============================================================== -->
    <script src="resources/ma/plugins/styleswitcher/jQuery.style.switcher.js"></script>


</body>

</html>