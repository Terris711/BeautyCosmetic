<%@page import="dao.CategoryDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>

<body>
	<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
		<div class="product-categori">
			<div class="search-product">
				<form action="#">
					<input class="form-control" placeholder="Search here..."
						type="text">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>
			<div class="filter-sidebar-left">
				<div class="title-left">
					<h3>Categories</h3>
				</div>
				<div
					class="list-group list-group-collapse list-group-sm list-group-tree"
					id="list-group-men" data-children=".sub-men">
					<c:forEach var="category" items="${categoryList}">
						<div class="list-group-collapse sub-men">
							<a class="list-group-item list-group-item-action"
								href="shop.jsp?category_name=${category.name}">${category.name}
								<small class="text-muted">(100)</small>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

</body>
</html>