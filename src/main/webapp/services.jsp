<!--DOCTYPE HTML-->
<html lang="en">
	<head>
		<title>Services - The Legend Barbershop</title>
		<meta charset="utf-8" />
		<!-- Required meta tag for Bootstrap -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
		<link rel="icon" href="img/favicon.png">
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.shop.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/style-services.css">
	</head>
	<body>
    <!--------MENU--------->
    <div class="wrapper">
        <header>
            <nav>

                <div id="navbar">

                    <div class="menu-icon">
                        <i class="fa fa-bars fa-2x"></i>
                    </div>

                    <div class="logo">
                        <a href="index.html"><img src="img/BlackOnWhite.png"></a>
                    </div>
                    <div class="menu">

                        <ul>
                            <li><a href="index.html">Home</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="services.html"  class="active">Services</a></li>
                            <li><a href="gallery.html">Gallery</a></li>
                            <li><a href="contact.html">Contact</a></li>
			<li><a href="shoppingcart.html" class="fas fa-shopping-basket"></a></li>
                        </ul>

                    </div>
            </nav>
        </header>
    </div>
    <!--------END MENU--------->
	<!--JUMBOTRON-->
    <div class="content">
	<div class="jumbotron">
  <div class="container-jumbo">
    <h1 class="display-4">SERVICES</h1>
  </div>
</div>

<!--END JUMBOTRON-->
<div id = "pricelist">
			<img src= "img/pricelist.jpg">
			</div>
	<div id = "site">
			
			<div id="content">
			
			
				<div id="products">
		
			
				
					<ul>
					<h2>BUY A GIFT VOUCHER</h2>
						<li>
							<div class="product-image">
								<img src="img/haircut.jpg" alt="" />
							</div>
							<div class="product-description" data-name="Haircut Gift Voucher" data-price="20">
								
								<p class="product-price">&euro; 20</p>
								<form class="add-to-cart" action="cartTest.jsp" method="get">
									<div>
										<label for="qty-1">Quantity</label>
										<input type="text" name="qty-1" id="qty-1" class="qty" value="1" />
									</div>
									<p><input type="submit" value="Add to cart" class="btn" /></p>
								</form>
							</div>
						</li>
						<li>
							<div class="product-image">
								<img src="img/beardtrim.jpg" alt="" />
							</div>
							<div class="product-description" data-name="Beard Trim Gift Voucher" data-price="16">
								
								<p class="product-price">&euro; 16</p>
								<form class="add-to-cart" action="cartTest.jsp" method="get">
									<div>
										<label for="qty-2">Quantity</label>
										<input type="text" name="qty-2" id="qty-2" class="qty" value="1" />
									</div>
									<p><input type="submit" value="Add to cart" class="btn" /></p>
								</form>
							</div>
						</li>

						<li>
							<div class="product-image">
								<img src="img/hottowel.jpg" alt="" />
							</div>
							<div class="product-description" data-name="Hot Towel Shave Gift Voucher" data-price="30">
								
								<p class="product-price">&euro; 30</p>
								<form class="add-to-cart" action="cartTest.jsp" method="get">
									<div>
										<label for="qty-3">Quantity</label>
										<input type="text" name="qty-3" id="qty-3" class="qty" value="1" />
									</div>
									<p><input type="submit" value="Add to cart" class="btn" /></p>
								</form>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>

    <!-- FOOTER -->
    <footer id="footer">
        <div id="social">
            <!-- FACEBOOK -->
            <a class="fab fa-facebook-f fa-2x" href="https://www.facebook.com/The-Legend-Barbershop-127579068086162/"></a>
            <!-- TWITTER -->
            <a class="fab fa-twitter fa-2x" href="www.twitter.com"></a>
            <!--INSTAGRAM-->
            <a class="fab fa-instagram fa-2x" href="https://www.instagram.com/explore/locations/127579068086162/the-legend-barbershop/?hl=en"></a>
        </div>

        <!-- COPYRIGHT -->

        <p id="copyright">© Copyright 2019 | The Legend Barbershop</p>

    </footer>


    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


	
	<!--JAVASCRIPT FOR MENU -->
    <script type="text/javascript">

        //MENU TOGGLE BUTTON
        $(document).ready(function() {
            $(".menu-icon").on("click", function() {
                $("nav ul").toggleClass("showing");
            });
        });
        //SCROLLING EFFECT
    </script>
    <script>
        window.onscroll = function() {
            myFunction()
        };

        var navbar = document.getElementById("navbar");
        var sticky = navbar.offsetTop;

        function myFunction() {
            if (window.pageYOffset >= sticky) {
                navbar.classList.add("sticky")
            } else {
                navbar.classList.remove("sticky");
            }
        }
    </script>

	</body>
</html>	
