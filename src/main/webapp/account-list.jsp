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
		
	

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Account</a></li>
			</ul>
		<div class="mdl-grid demo-content">

			<h1>Account</h1>
			<a class="click-black" style="position: absolute; right: 10%;"
				href="account-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD
				NEW ACCOUNT</a>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>User Name</th>
						<th>Password</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Address</th>
						<th colspan= "2">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="account" items="${ACCOUNT_LIST}">
						<c:url var="updateLink" value="AccountBOServlet">
							<c:param name="command" value="LOAD"></c:param>
							<c:param name="id" value="${account.id}"></c:param>
						</c:url>

						<c:url var="deleteLink" value="AccountBOServlet">
							<c:param name="command" value="DELETE"></c:param>
							<c:param name="id" value="${account.id}"></c:param>
						</c:url>

						<tr>
							<td>${account.id}</td>
							<td>${account.accountName}</td>
							<td>${account.password}</td>
							<td>${account.name}</td>
							<td>${account.email}</td>
							<td>${account.phone}</td>
							<td>${account.address}</td>
							<td><a href="${updateLink}">Update</a></td>
							<td><a href="${deleteLink}"
								onclick="if (!(confirm('Delete this Account?'))) return false;">Delete</a></td>
						</tr>


					</c:forEach>
				</tbody>
			</table>
			<br> <input type="button"" value= "add account" onClick="window.location.href='account-add-form.jsp; return false;'" class="account-add-form"/><br>

			<a class="click-black" href="account-add-form.jsp"><i
				class="fa-solid fa-plus"></i>ADD NEW ACCOUNT</a>
		</div>
	</main>


	<%-- end of main dashboard area --%>

	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>