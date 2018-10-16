<!-- 
Author: Bhautik Bhanani
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:choose>
	<c:when
		test="${sessionScope.cart != null && sessionScope.loginUser != null}">
		<c:set var="cartTotal"
			value="${fn:length(sessionScope.cart.get(sessionScope.loginUser.getUserId()))}" />
	</c:when>
	<c:otherwise>
		<c:set var="cartTotal" value="0" />
	</c:otherwise>
</c:choose>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>' />
<style>
body {
	padding-top: 100px;
}

@media ( min-width : 992px) {
	body {
		padding-top: 100px;
	}
}
</style>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Shopping Cart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${sessionScope.loginUser != null}">
						<li class="nav-item"><a class="nav-link" href="./home">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="./products">Products</a></li>
						<li class="nav-item"><a class="nav-link" href="./wishlist">Products</a></li>
						<li class="nav-item"><a class="nav-link" href="./cart">Cart<span>(<c:out
										value="${cartTotal}" />)
							</span></a></li>
						<li class="nav-item"><a class="nav-link" href="./settings">Settings</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="javascript:document.getElementById('logoutForm').submit();">Logout</a></li>
						<c:url value="/j_spring_security_logout" var="logoutURL" />
						<form action="${logoutURL}" method="POST" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="./home">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="./products">Products</a></li>
						<li class="nav-item"><a class="nav-link" href="./login">Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	</nav>