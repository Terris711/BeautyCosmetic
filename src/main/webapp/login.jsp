<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
     <title>Beauty Cosmetic </title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/lip.jpeg" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
   
<jsp:include page="header.jsp"></jsp:include>

    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>SIGN IN</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href=""index.jsp">Home</a></li>
                        <li class="breadcrumb-item active"> Sign In </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->
    <!-- Start Contact Us  -->
    <div class="">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-sm-12">
                    <div class="sign-in">
                        <p>This is the first time you log in, please register.</p>
                        <form action="LoginServlet" id="form-signin" method="post">
                            <div class="form-group">
                                <i class="far fa-user"></i>
                                <p style="color: red">${err}</p>
                                <input type="text" class="form-input" name= "username" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <i class="fas fa-key"></i>
                                <input type="password" class="form-input" name="password" placeholder="Password">
                                <div id="eye">
                                    <i class="far fa-eye"></i>
                                </div>
                            </div>
                            	<span>
								<input type="checkbox" class="checkbox"> 
								Keep me signed in
							</span>
                            <input type="submit" value="SIGN IN" class="form-submit">

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Cart -->
    <jsp:include page="footer.jsp"></jsp:include>
    
    <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

    <!-- ALL JS FILES -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    <script src="js/jquery.superslides.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/inewsticker.js"></script>
    <script src="js/bootsnav.js."></script>
    <script src="js/images-loded.min.js"></script>
    <script src="js/isotope.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/baguetteBox.min.js"></script>
    <script src="js/form-validator.min.js"></script>
    <script src="js/contact-form-script.js"></script>
    <script src="js/custom.js"></script>
    <script src="js/app.js"></script>
</body>

</html>
