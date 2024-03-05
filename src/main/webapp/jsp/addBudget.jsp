<%--
  Created by IntelliJ IDEA.
  User: sixue
  Date: 2024/3/4
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Edit Budget</title>
</head>
<body>
<h1 style="color: red">${neg}</h1>
<h1 style="color: green">${pos}</h1>
<h1>Edit Budget Details</h1>
<form action="/trip/editBudget/${tripId}" method="post" enctype="multipart/form-data">
  <input type="text" name="id" value="${budgetTracker.getId()}" hidden="">
  Name:<input type="text" name="name" value="${name}" readonly><br>
  Total Budget: <input type="number" name="totalbudget" value="${budget}" readonly><br>
  Transportation:<input type="number" name="transportationBudget" step="0.01" value="${budgetTracker.getTransportationBudget()}"><br>
  Accommodation:<input type="number" name="accommodationBudget" step="0.01" value="${budgetTracker.getAccommodationBudget()}"><br>
  Meals:<input type="number" name="mealsBudget" step="0.01" value="${budgetTracker.getMealsBudget()}"><br>
  Activities:<input type="number" name="activitiesBudget" step="0.01" value="${budgetTracker.getActivitiesBudget()}"><br>
  <button>Submit</button>
  <button type="reset">Cancel</button>
</form>
<br>
<a href="/trip/home"><button>Back</button></a>
</body>
</html>