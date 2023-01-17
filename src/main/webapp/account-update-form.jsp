<%@page import="dao.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./material.min.css">
<script src="./material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://kit.fontawesome.com/76af9337dc.js"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Account</title>

<meta charset="utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>Beauty Cosmetic</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/custom.css">


<!-- Site Icons -->
<link rel="shortcut icon" href="images/lip.jpeg" type="image/x-icon">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
<link rel="stylesheet" href="style-dash.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%-- header area --%>
	<jsp:include page="dashboard-header.jsp"></jsp:include>
	<%-- end of header area --%>

	<%-- main dashboard area (show statistics) --%>
	<main class="mdl-layout__content mdl-color--grey-100">
		<div class="mdl-grid demo-content">
			<div class="dash-content">
				<h1>Account</h1>
				<hr>

				<h3>Update Account information</h3>
				<form action="AccountBOServlet" method="GET">
					<input type="hidden" name="command" value="ADD" />
					<input type="hidden" name="id" value="${LOAD_ACCOUNT.id}}"/>
					
				<div class="form-group">

						<input type="text" class="form-input" name="username" value = "${LOAD_ACCOUNT.username}" placeholder="${LOAD_ACCOUNT.username}"/>
					</div>
					<div class="form-group">
						<input type="password" class="form-input" name="password" value = "${LOAD_ACCOUNT.password}" placeholder="${LOAD_ACCOUNT.password}">

					</div>
					<div class="form-group">
						<input type="text" class="form-input" name="name"  value = "${LOAD_ACCOUNT.name}"  placeholder="Name">
					</div>
					<div class="form-group">
						<input type="email" class="form-input" name="email"  value = "${LOAD_ACCOUNT.email}"  placeholder="Email">
					</div>
					<div class="form-group">
						<input type="text" class="form-input" name="phone"  value = "${LOAD_ACCOUNT.phone}"  placeholder="Phone">
					</div>
					<div class="form-group">
						<input type="text" class="form-input" name="address" value = "${LOAD_ACCOUNT.address}"  placeholder="Address">
					</div>
					

					<a class="click-black" href="DashboardServlet"><i
						class="fa-solid fa-arrow-left"></i> Back to dashboard</a> <input
						class="click-submit" type="submit" value="Save" />

				</form>

			</div>
		</div>
	</main>


	<%-- end of main dashboard area --%>
	<a
		href="https://github.com/google/material-design-lite/blob/mdl-1.x/templates/dashboard/"
		target="_blank" id="view-source"
		class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored mdl-color-text--white">View
		Source</a>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>