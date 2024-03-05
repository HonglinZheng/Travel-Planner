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
<h1>Add Trip Details</h1>
<form action="/itinerary/add/${tripId}" method="post" enctype="multipart/form-data">
    Name:<input type="text" name="name" required><br>
    Date:<input type="date" name="idate" required><br>
    Location:<input type="text" name="location" required><br>
    Attraction:<input type="text" name="attraction"><br>
    WeatherForecast:
    <select name="weatherForecast">
        <option value="">Select Weather</option>
        <option value="Sunny">Sunny</option>
        <option value="Cloudy">Cloudy</option>
        <option value="Rainy">Rainy</option>
        <option value="Snowy">Snowy</option>
    </select><br>
    Detail:<input type="text" name="detail"><br>
    Safety Tips:<input type="text" name="safetyTips"><br>
    <button>Add</button>
    <button type="reset">Cancel</button>
</form>
<br>
<a href="/itinerary/home/${tripId}"><button>Back</button></a>
</body>
</html>