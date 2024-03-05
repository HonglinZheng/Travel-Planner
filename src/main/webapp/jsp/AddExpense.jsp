<%--
  Created by IntelliJ IDEA.
  User: sixue
  Date: 2024/3/4
  Time: 19:26
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
<h1>Expense Log</h1>
<form action="/itinerary/expenseLog/${tripId}/${itinerary.getId()}" method="post" enctype="multipart/form-data">
  <input type="text" name="id" value="${itinerary.getId()}" hidden="">
  Name:<input type="text" name="name" value="${name}" readonly><br>
  Transportation:<input type="number" name="transportationExpense" step="0.01" value="${expenseLog.getTransportationExpense()}"><br>
  Accommodation:<input type="number" name="accommodationExpense" step="0.01" value="${expenseLog.getAccommodationExpense()}"><br>
  Meals:<input type="number" name="mealsExpense" step="0.01" value="${expenseLog.getMealsExpense()}"><br>
  Activities:<input type="number" name="activitiesExpense" step="0.01" value="${expenseLog.getActivitiesExpense()}"><br>
  <button>Submit</button>
  <button type="reset">Cancel</button>
</form>
<br>
<a href="/trip/home"><button>Back</button></a>
</body>
</html>
