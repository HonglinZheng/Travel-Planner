<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Itinerary</title>
</head>
<body>
<h1 style="color:red">${neg}</h1>
<h1 style="color:green">${pos}</h1>
<h1>Edit Trip Details</h1>
<form action="/itinerary/update/${tripId}" method="post" enctype="multipart/form-data">
    <input type="text" name="id" value="${itinerary.getId()}" hidden="">
    Name:<input type="text" name="name" value="${itinerary.getName()}" required><br>
    Date:<input type="date" name="idate" value="${itinerary.getDate()}" required><br>
    Location:<input type="text" name="location" value="${itinerary.getLocation()}" required><br>
    Attraction:<input type="text" name="attraction" value="${itinerary.getAttraction()}"><br>
    WeatherForecast:
    <select name="weatherForecast">
        <option value="" ${itinerary.getWeatherForecast() eq '' ? 'selected' : ''}>Select Weather</option>
        <option value="Sunny" ${itinerary.getWeatherForecast() eq 'Sunny' ? 'selected' : ''}>Sunny</option>
        <option value="Cloudy" ${itinerary.getWeatherForecast() eq 'Cloudy' ? 'selected' : ''}>Cloudy</option>
        <option value="Rainy" ${itinerary.getWeatherForecast() eq 'Rainy' ? 'selected' : ''}>Rainy</option>
        <option value="Snowy" ${itinerary.getWeatherForecast() eq 'Snowy' ? 'selected' : ''}>Snowy</option>
    </select><br>
    Detail:<input type="text" name="detail" value="${itinerary.getDetail()}"><br>
    Safety Tips:<input type="text" name="safetyTips" value="${itinerary.getSafetyTips()}"><br>
    <button>Update</button>
    <button type="reset">Cancel</button>
</form>
<br>
<a href="/trip/home"><button>Back</button></a>
</body>
</html>