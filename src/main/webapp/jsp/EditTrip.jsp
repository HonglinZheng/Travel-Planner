<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Book</title>
</head>
<body>
<h1 style="color: red">${neg}</h1>
<h1 style="color: green">${pos}</h1>
<h1>Edit Trip Details</h1>
<form action="/trip/updateTrip" method="post">
    <input type="text" name="id" value="${trip.getId()}" hidden="">
    Name:<input type="text" name="name" value="${trip.getName()}"><br>
    Budget: <input type="number" name="budget" step="0.01" value="${trip.getBudget()}"><br>
    Start Date:<input type="date" name="start_date" value="${trip.getStartDate()}"><br>
    End Date:<input type="date" name="end_date" value="${trip.getEndDate()}"><br>
    <button>Update</button>
    <button type="reset">Cancel</button>
</form>
<br>
<a href="/jsp/UserHome.jsp"><button>Back</button></a>
</body>
</html>