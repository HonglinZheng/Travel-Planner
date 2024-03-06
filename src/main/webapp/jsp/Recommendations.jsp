<%--
  Created by IntelliJ IDEA.
  User: sixue
  Date: 2024/3/5
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="com.project275.travelplaner.entity.Recommendation"%>
<%@page import="com.project275.travelplaner.entity.Itinerary"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Recommendations</title>
</head>
<body>
<h1 style="color:red">${neg}</h1>
<h1 style="color:green">${pos}</h1>
<%--<h2>Recommendations for ${city}</h2>--%>
<h2>Recommendations</h2>
<%
    List<Recommendation> recommendations = (List<Recommendation>) request.getAttribute("recommendations");
%>
<table border="1">
    <tr>
        <th>Recommendation</th>
        <th>Select</th>
    </tr>
    <%
        for (Recommendation recommendation : recommendations) {
    %>
    <tr>
        <td><%= recommendation.getRecommendation() %></td>
        <td><a href="/itinerary/generate/${tripId}/<%=recommendation.getId()%>"><button>Confirm</button></a></td>
    </tr>
    <%
        }
    %>
</table><br>
<a href="/itinerary/home/${tripId}"><button>Back</button></a>
</body>
</html>
