<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/signin.css">
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="container">
		<img class="banner-image" src="/images/brisbane-city-1224451.jpg">
		<form:form method="POST" modelAttribute="userForm">
			<h2>Create your account</h2>
			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" class="control" path="username"
						placeholder="username"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" class="control" path="password"
						placeholder="password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" class="control" path="passwordConfirm"
						placeholder="confirm password"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>
			<button  class = "btn btn-lg btn-primary" type="submit">Register</button>
		</form:form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="/javascript/bootstrap.min.js"></script>
</body>
</html>