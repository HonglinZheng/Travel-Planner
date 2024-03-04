<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Trip</title>
</head>
<body>
<h1 style="color:red">${neg}</h1>
<h1 style="color:green">${pos}</h1>
<h1>Add Trip Details</h1>
<form action="/trip/add" method="post" enctype="multipart/form-data">
    Name:<input type="text" name="name" required><br>
    Budget: <input type="number" name="budget" step="0.01" value=0.0><br>
    Start Date:<input type="date" name="start_date" required><br>
    End Date:<input type="date" name="end_date" required><br>
    <button>Add</button>
    <button type="reset">Cancel</button>
</form>
<br>
<a href="/trip/home"><button>Back</button></a>
</body>
</html>