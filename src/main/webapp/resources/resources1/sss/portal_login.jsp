<%@page import="java.util.ArrayList"%>
<%@page import="students.portal.model.Course"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="students.portal.model.PortalStudent"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html lang="en">
  <head>
      
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    

    <title> NUST | Students Portal - Login</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
   
    <!--external css-->
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <style>
        *{
            border-radius: 0 !important;
        }
    </style>
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	 
      <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="${pageContext.request.contextPath}/LoginController" method="post">
                          
		        <h2 class="form-login-heading">STUDENT PORTAL LOGIN </h2>
                        <img class="form-login-heading" src="images/nust_logo.png" alt="NUST LOGO" />
                       
		        <div class="login-wrap">
                            <label >Student Number</label>
		            <input type="text" class="form-control" placeholder="Student Number" name="student_id" autofocus pattern="^(N0|n0|P0|p0)+[A-Za-z0-9_]{2,15}$" title="The second character on your Student Number is Digit Zero " >
		            <br>
                            <label >Password</label>
		            <input type="password" class="form-control" placeholder="Barcode" name="password">
		            <label class="checkbox">
		                
                                <center>
                                        <%
                                            if (request.getParameter("message") == null) {
                                                out.println("Enter your credentials to login.");
                                            } else {
                                                out.println(request. getParameter("message")+"</b>");
                                            }
                                        %>
                                    </center>
		                
		            </label>
		            <button class="btn btn-theme btn-block"  type="submit"> <i class="fa fa-lock"></i> LOGIN</button>
		            <hr>
		            <a href="http://portal.nust.ac.zw/forgotpasswd" target="_blank"><p>Forgot Password? Click here.</p></a>
                            <p><strong>WARNING: Protect your privacy! Prevent unauthorized use!</strong> Completely exit your Web browser when you are finished.</p>
                            
		        </div>
		
		          <!-- Modal -->
		          
		          <!-- modal -->
                          
                              <!-- Modal -->
		          
		
		      </form>	  	
	  	
	  	</div>
	  </div>
                                    
                                    

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("images/ZenBG.png", {speed: 500});
    </script>


  </body>
</html>
