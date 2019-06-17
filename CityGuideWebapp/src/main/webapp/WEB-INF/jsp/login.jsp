<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form method="POST" class="form-signin"
			modelAttribute="loginForm">
			<h2>Log in</h2>
			<spring:bind path="username">
				<div class="form-group ${error != null ? 'has-error' : ''}">
					<input name="username" type="text" class="control"
						placeholder="username" autofocus="true" />
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${error != null ? 'has-error' : ''}">
					<input name="password" type="password" class="control"
						placeholder="password" />
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			<button class="btn btn-lg btn-primary" type="submit">Log In</button>
			<h4 class="text-center">
				<a href="${contextPath}/signin">Create an account</a>
			</h4>
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/javascript/bootstrap.min.js"></script>
</body>
</html>