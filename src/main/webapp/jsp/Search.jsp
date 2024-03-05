<%--
  Created by IntelliJ IDEA.
  User: sixue
  Date: 2024/3/5
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Share Trip</title>
</head>
<body>
<h1 style="color: red">${neg}</h1>
<h1 style="color: green">${pos}</h1>
<form action="/itinerary/recommendation/${tripId}" method="get">
    <input type="text" name="id" value="${tripId}" hidden="">
    Search City: <input type="text" name="city" required>
    <button>Search</button>
</form>
<br>
<a href="/itinerary/home/${tripId}"><button>Back</button></a>
</body>
</html>