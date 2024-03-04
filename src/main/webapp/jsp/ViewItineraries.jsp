<%@page import="java.util.*"%>
<%@page import="com.project275.travelplaner.entity.Itinerary"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Itinerary</title>
</head>
<body>
<h1 style="color:red">${neg}</h1>
<h1 style="color:green">${pos}</h1>
<%
    List<Itinerary> itineraries = (List<Itinerary>) request.getAttribute("itineraries");
%>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Location</th>
        <th>Attraction</th>
        <th>WeatherForecast</th>
        <th>Detail</th>
        <th>Safety Tips</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%
        for (Itinerary i : itineraries) {
    %>
    <tr>
        <th><%=i.getName()%></th>
        <th><%=i.getDate()%></th>
        <th><%=i.getLocation()%></th>
        <th><%=i.getAttraction()%></th>
        <th><%=i.getWeatherForecast()%></th>
        <th><%=i.getDetail()%></th>
        <th><%=i.getSafetyTips()%></th>
        <th><a href="/itinerary/edit/${tripId}/<%=i.getId()%>"><button>Edit</button></a></th>
        <th><a href="/itinerary/delete/${tripId}/<%=i.getId()%>"><button>Delete</button></a></th>
    </tr>
    <%
        }
    %>
</table><br>
<a href="/itinerary/add/${tripId}"><button>Create Itinerary</button></a>
<a href="/trip/home"><button>Back</button></a>
</body>
</html>