<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}">
<link rel="stylesheet" href="/css/city.css">
<script type="text/javascript" src="/javascript/jquery-3.4.1.min.js"></script>
<meta charset="utf-8">
</head>
<body>
	<div class="container">
		<div class="h1">${city}</div>
		<div class="h1">${country}</div>
		<div id="weather-icon">
			<script>
				var rain = "${main}";
				var a = document.createElement("img");
				var src = document.getElementById("weather-icon");
				src.appendChild(a);
				switch (rain) {
				case "Rain":
					a.src = "/images/iconfinder_Weather_Weather_Forecast_Rain_Cloud_Climate_3859144.png";
					break;
				case "Clear":
					a.src = "/images/iconfinder_Weather_Weather_Forecast_Hot_Sun_Day_3859136.png";
					break;
				case "Drizzle":
					a.src = "/images/iconfinder_Weather_Weather_Forecast_Rain_Cloud_Climate_3859144.png";
					break;

				case "Snow":
					a.src = "/images/iconfinder_Weather_Weather_Forecast_Flake_Cloud_Climate_3859133.png";
					break;

				case "Clouds":
					a.src = "/images/iconfinder_Weather_Weather_Forecast_Cloudy_Season_Cloud_3859132.png";
					break;

				case "Thunderstorm":
					a.src = "/images/iconfinder_Weather_Weather_Forecast_Lightning_Cloud_Storm_3859137.png";
					break;

				default:
					a.src = "/images/iconfinder_Weather_Weather_Forecast_Wind_Blowing_Climate_3859154.png"
					break;
				}
				src.appendChild(a);
			</script>
		</div>
		<div class="weather-data">
			<span>${temperature} &#176;</span>C, ${description}
		</div>
		<br>
		<div class="weather-data">
			<span>Lat :${latitude}&#176;</span>
		</div>
		<img src="/images/latitude.png">
		<div class="weather-data">
			<span> Lon: ${longitude}&#176;</span>
		</div>
		<img src="/images/longitude.png">
	</div>
</body>
</html>