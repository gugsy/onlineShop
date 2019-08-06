<!--DOCTYPE HTML-->
<html>

<head>
    <title>Cart - The Legend Barbershop</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link rel="icon" href="img/favicon.png">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

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
                            <li><a href="services.jsp">Services</a></li>
                            <li><a href="gallery.html">Gallery</a></li>
                            <li><a href="contact.html">Contact</a></li>
                            <li><a href="cart.html" class="fas fa-shopping-basket"></a></li>
                        </ul>

                    </div>
            </nav>
        </header>
    </div>
    <!--------END MENU--------->

    <div id="site">
        <div class="content">
            <h1>Your Shopping Cart</h1>
            <form id="shopping-cart" action="cartTest.jsp" method="get">
                <table class="shopping-cart">
                    <thead>
                        <tr>
                            <th scope="col">Item</th>
                            <th scope="col">Qty</th>
                            <th scope="col" colspan="2">Price</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <p id="sub-total">
                    <strong>Sub Total</strong>: <span id="stotal"></span>
                </p>
                <ul id="shopping-cart-actions">
                    <li>
                        <input type="submit" name="update" id="update-cart" class="btn" value="Update Cart" />
                    </li>
                    <li>
                        <input type="submit" name="delete" id="empty-cart" class="btn" value="Empty Cart" />
                    </li>
                    <li>
                        <a href="services.jsp" class="btn">Continue Shopping</a>
                    </li>
                    <li>
                        <a href="checkout.html" class="btn">Go To Checkout</a>
                    </li>
                </ul>
            </form>
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


    <script type="text/javascript" src="resources/js/jquery.shop.js"></script>
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