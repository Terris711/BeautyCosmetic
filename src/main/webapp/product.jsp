<%@page import="dao.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
		<div class="right-product-box">
			<div class="product-item-filter row">
				<div class="col-12 col-sm-8 text-center text-sm-left">
					<div class="toolbar-sorter-right">
						<span>Sort by</span> <select id="basic"
							class="selectpicker show-tick form-control"
							data-placeholder="$ USD">
							<option data-display="Select">Nothing</option>
							<option value="1">Popularity</option>
							<option value="2">High Price → Low Price</option>
							<option value="3">Low Price → High Price</option>
							<option value="4">Best Selling</option>
						</select>
					</div>
					<p>Showing all 4 results</p>
				</div>
				<div class="col-12 col-sm-4 text-center text-sm-right">
					<ul class="nav nav-tabs ml-auto">
						<li><a class="nav-link active" href="#grid-view"
							data-toggle="tab"> <i class="fa fa-th"></i>
						</a></li>
						<li><a class="nav-link" href="#list-view" data-toggle="tab">
								<i class="fa fa-list-ul"></i>
						</a></li>
					</ul>
				</div>
			</div>


			<div class="product-categorie-box">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane fade show active"
						id="grid-view">
						<div class="row">
							<c:forEach var="product" items="${productList}">
								<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
									<div class="products-single fix">
										<div class="box-img-hover">
											<div class="type-lb">
												<p class="sale">Sale</p>
											</div>
											<img src="${product.imageUrl}" class="img-fluid" alt="Image"
												width="290" height="300">
											<div class="mask-icon">
												<ul>
													<li><a href="#" data-toggle="tooltip"
														data-placement="right" title="View"><i
															class="fas fa-eye"></i></a></li>
													<li><a href="#" data-toggle="tooltip"
														data-placement="right" title="Compare"><i
															class="fas fa-sync-alt"></i></a></li>
													<li><a href="#" data-toggle="tooltip"
														data-placement="right" title="Add to Wishlist"><i
															class="far fa-heart"></i></a></li>
												</ul>
												<a class="cart" href="#">Add to Cart</a>
											</div>
										</div>
										<div class="why-text">
											<h4>${product.brand.name}</h4>
											<h4>${product.name}</h4>
											<h5>${product.unitPrice}</h5>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="list-view">
						<div class="list-view-box">
							<div class="row">
								
								<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
									<div class="products-single fix">
										<div class="box-img-hover">
											<div class="type-lb">
												<p class="new">New</p>
											</div>
											<img src="images/img-pro-01.jpeg" class="img-fluid"
												alt="Image" width="290" height="300">
											<div class="mask-icon">
												<ul>
													<li><a href="#" data-toggle="tooltip"
														data-placement="right" title="View"><i
															class="fas fa-eye"></i></a></li>
													<li><a href="#" data-toggle="tooltip"
														data-placement="right" title="Compare"><i
															class="fas fa-sync-alt"></i></a></li>
													<li><a href="#" data-toggle="tooltip"
														data-placement="right" title="Add to Wishlist"><i
															class="far fa-heart"></i></a></li>
												</ul>

											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
									<div class="why-text full-width">
										<h4>Lorem ipsum dolor sit amet</h4>
										<h5>
											<del>$ 60.00</del>
											$40.79
										</h5>
										<p>Integer tincidunt aliquet nibh vitae dictum. In turpis
											sapien, imperdiet quis magna nec, iaculis ultrices ante.
											Integer vitae suscipit nisi. Morbi dignissim risus sit amet
											orci porta, eget aliquam purus sollicitudin. Cras eu metus
											felis. Sed arcu arcu, sagittis in blandit eu, imperdiet sit
											amet eros. Donec accumsan nisi purus, quis euismod ex
											volutpat in. Vestibulum eleifend eros ac lobortis aliquet.
											Suspendisse at ipsum vel lacus vehicula blandit et
											sollicitudin quam. Praesent vulputate semper libero pulvinar
											consequat. Etiam ut placerat lectus.</p>
										<a class="btn hvr-hover" href="#">Add to Cart</a>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>