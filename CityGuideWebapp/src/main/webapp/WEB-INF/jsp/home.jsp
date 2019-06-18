<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}">
<meta charset="utf-8">
<link rel="stylesheet" href="/css/home.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="resources/javascript/wrongStatusCode.js"></script>
</head>
<body>

	<form action="login">
		<button type="submit" class="user">
			<script>
		if("${message}"!=""){
			window.document.write("${message}");
		}else{
			window.document.write("Log in");
		}</script>
		</button>
	</form>
	<form action="signin">
		<button type="submit" class="user">Sign in</button>
	</form>
	<div class="banner">
		<img class="banner-image" src="/images/london-01-1446474.jpg">
		<div class="main-title">
			Check out your city!
			<div class="search-container">
				<form action="getCity">
					City name: <input type="text" name="cityName"
						placeholder="Search...">
					<button type="submit" id="searchButton">
						<i class="fa fa-search"></i>
					</button>
					<script>
 					if(${statusCode}!="200"){
 						alert("City not found!");
					}
 					</script>
				</form>
			</div>
		</div>
	</div>

	<div class="cities">Most frequently searched cities:</div>

	<div class="row">
		<div class="column-image">
			<form action="getCity">
				<button type="submit" class="image-button" name="cityName"
					value="Paris">
					<img class="resized-image" src="/images/paris1.jpg">
				</button>
			</form>
			<span class="caption">Paris</span>
		</div>
		<div class="column-image">
			<form action="getCity">
				<button type="submit" class="image-button" name="cityName"
					value="Warsaw">
					<img class="resized-image" src="/images/warsaw1.jpg">
				</button>
			</form>
			<span class="caption">Warsaw</span>
		</div>
		<div class="column-image">
			<form action="getCity">
				<button type="submit" class="image-button" name="cityName"
					value="Rome">
					<img class="resized-image" src="/images/rome1.jpg"> <span
						class="caption">Rome</span>
				</button>
			</form>
		</div>
	</div>
	<h1>MaciejG web app - <i>City Search</i></h1>
	<h3>This site or product includes IP2Location™ Country Multilingual Database which available from https://www.ip2location.com</h3>
</body>
</html>
