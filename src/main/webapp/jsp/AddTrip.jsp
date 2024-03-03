<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Book</title>
</head>
<body>
<h1 style="color:red">${neg}</h1>
<h1 style="color:green">${pos}</h1>
<h1>Add Trip Details</h1>
<form action="/trip/addTrip" method="post" enctype="multipart/form-data">
    Name:<input type="text" name="name"><br>
    Budget: <input type="number" name="budget" step="0.01"><br>
    Start Date:<input type="date" name="start_date"><br>
    End Date:<input type="date" name="end_date"><br>
    <button>Add</button>
    <button type="reset">Cancel</button>
</form>
<br>
<a href="/jsp/UserHome.jsp"><button>Back</button></a>
</body>
</html>